package br.com.springboot.airbnbanalyses.app;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.com.springboot.airbnbanalyses.entities.AirBnbListings;

public class CsvManipulation {

    public static void convertDate(List<AirBnbListings> list) {
        for (AirBnbListings i : list) {
            try {
                String dataNoFormat = i.getLast_review();

                DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatUS.parse(dataNoFormat);

                DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataConvertida = formatBR.format(date);
                i.setLast_review(dataConvertida);
            } catch (ParseException e) {
                e.getStackTrace();

            }
        }
    }

    //Lê um arquivo Csv
    public static CsvToBean readCsv(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(AirBnbListings.class).build();
        return  csvToBean;
    }

    public static void writeAlgorithmsFiles(String path ,Integer[] arrayId, String[] arrayName, Integer[] arrayHostId, String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, Double[] arrayLatitude, Double[] arrayLongitude, String[] arrayRoomType, Integer[] arrayPrice, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, String[] arrayLastReview, Double[] arrayReviewsPerMonth, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, ParseException {
        try {

            List<AirBnbListings> data = new ArrayList<>();

            for (int i = 0; i < arrayId.length; i++) {
                data.add(new AirBnbListings(arrayId[i], arrayName[i], arrayHostId[i], arrayHostName[i], arrayNeighbourhoodGroup[i],
                        arrayNeighbourhood[i], arrayLatitude[i], arrayLongitude[i], arrayRoomType[i], arrayPrice[i],
                        arrayMinimumNights[i], arrayNumberOfReviews[i], arrayLastReview[i], arrayReviewsPerMonth[i],
                        arrayCalculatedHostListingsCount[i], arrayAvaiability365[i]));
            }

            for (AirBnbListings i: data) {
                System.out.println("entrou no for!!");
                System.out.println(i);;
            }

            Writer writer = Files.newBufferedWriter(Paths.get(path));
            StatefulBeanToCsv<AirBnbListings> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCsvFiles(String path, String pathUpper, String pathLower, List<AirBnbListings> list, int avgPrice) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, ParseException {
        try {

            List<AirBnbListings> data = new ArrayList<>();
            List<AirBnbListings> upperAvgPrices = new ArrayList<>();
            List<AirBnbListings> lowerAvgPrices = new ArrayList<>();

            //Adiciona todos itens na lista que será utilizada para organizar as datas
            for (AirBnbListings i : list) {
                data.add(new AirBnbListings(i.getId(), i.getName(), i.getHost_id(), i.getHost_name(), i.getNeighbourhood_group(),
                        i.getNeighbourhood(), i.getLatitude(), i.getLongitude(), i.getRoom_type(), i.getPrice(), i.getMinimum_nights(),
                        i.getNumber_of_reviews(), i.getLast_review(), i.getReviews_per_month(), i.getCalculated_host_listings_count(),
                        i.getAvailability_365()
                ));
            }

            //Adiciona todos itens nas listas para criar os arquivos de preços acima ou abaixo da média (preços iguais à media são cosniderados como maiores)
            for (AirBnbListings i : list) {
                String[] airBnbItem = {};

                //if (Integer.parseInt(i.getPrice()) >= avgPrice) {
                if (i.getPrice() >= avgPrice) {
                    upperAvgPrices.add(new AirBnbListings(i.getId(), i.getName(), i.getHost_id(), i.getHost_name(), i.getNeighbourhood_group(),
                            i.getNeighbourhood(), i.getLatitude(), i.getLongitude(), i.getRoom_type(), i.getPrice(), i.getMinimum_nights(),
                            i.getNumber_of_reviews(), i.getLast_review(), i.getReviews_per_month(), i.getCalculated_host_listings_count(),
                            i.getAvailability_365()));
                }
                else {
                    lowerAvgPrices.add(new AirBnbListings(i.getId(), i.getName(), i.getHost_id(), i.getHost_name(), i.getNeighbourhood_group(),
                            i.getNeighbourhood(), i.getLatitude(), i.getLongitude(), i.getRoom_type(), i.getPrice(), i.getMinimum_nights(),
                            i.getNumber_of_reviews(), i.getLast_review(), i.getReviews_per_month(), i.getCalculated_host_listings_count(),
                            i.getAvailability_365()));
                }
            }

            Writer writer = Files.newBufferedWriter(Paths.get(path));
            StatefulBeanToCsv<AirBnbListings> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(data);
            writer.flush();
            writer.close();

            Writer writerUpper = Files.newBufferedWriter(Paths.get(pathUpper));
            StatefulBeanToCsv<AirBnbListings> beanToCsvUpper = new StatefulBeanToCsvBuilder(writerUpper).build();
            beanToCsvUpper.write(upperAvgPrices);
            writerUpper.flush();
            writerUpper.close();

            Writer writerLower = Files.newBufferedWriter(Paths.get(pathLower));
            StatefulBeanToCsv<AirBnbListings> beanToCsvLower = new StatefulBeanToCsvBuilder(writerLower).build();
            beanToCsvLower.write(lowerAvgPrices);
            writerLower.flush();
            writerLower.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}













/*package br.com.springboot.airbnbanalyses.app;

import br.com.springboot.airbnbanalyses.entities.AirBnbListings;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvManipulation {

    public static void convertDate(List<AirBnbListings> list) {
        for (AirBnbListings i : list) {
            try {
                String dataNoFormat = i.getLast_review();
                DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");

                Date date = formatUS.parse(dataNoFormat);
                DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");

                String dataConvertida = formatBR.format(date);
                i.setLast_review(dataConvertida);

            } catch (ParseException e) {
                e.getStackTrace();
            }
        }
    }

    public static void writeCsvFiles(String path, String pathUpper, String pathLower, List<AirBnbListings> list, int avgPrice) {
        try {
            FileWriter fw = new FileWriter(path);
            CSVWriter cw = new CSVWriter(fw);

            FileWriter fwUpper = new FileWriter(pathUpper);
            CSVWriter cwUpper = new CSVWriter(fwUpper);

            FileWriter fwLower = new FileWriter(pathLower);
            CSVWriter cwLower = new CSVWriter(fwLower);

            List<String[]> data = new ArrayList<>();
            List<String[]> upperAvgPrices = new ArrayList<>();
            List<String[]> lowerAvgPrices = new ArrayList<>();

            //Adiciona todos itens na lista que será utilizada para organizar as datas
            for (AirBnbListings i : list) {
                String[] airBnbItem = {i.getId(), i.getName(), i.getHost_id(), i.getHost_name(), i.getNeighbourhood_group(),
                        i.getNeighbourhood(), i.getLatitude(), i.getLongitude(), i.getRoom_type(), i.getPrice(), i.getMinimum_nights(),
                        i.getNumber_of_reviews(), i.getLast_review(), i.getReviews_per_month(), i.getCalculated_host_listings_count(),
                        i.getAvailability_365()};
                data.add(airBnbItem);
            }

            //Adiciona todos itens nas listas para criar os arquivos de preços acima ou abaixo da média (preços iguais à media são cosniderados como maiores)
            for (AirBnbListings i : list) {
                String[] airBnbItem = {i.getId(), i.getName(), i.getHost_id(), i.getHost_name(), i.getNeighbourhood_group(),
                        i.getNeighbourhood(), i.getLatitude(), i.getLongitude(), i.getRoom_type(), i.getPrice(), i.getMinimum_nights(),
                        i.getNumber_of_reviews(), i.getLast_review(), i.getReviews_per_month(), i.getCalculated_host_listings_count(),
                        i.getAvailability_365()};

                if (Integer.parseInt(i.getPrice()) >= avgPrice) {
                    upperAvgPrices.add(airBnbItem);
                }
                else {
                    lowerAvgPrices.add(airBnbItem);
                }
            }

            //Adiciona o conteudo da lista no .csv
            cwUpper.writeAll(upperAvgPrices);
            cwUpper.close();
            fwUpper.close();

            cwLower.writeAll(lowerAvgPrices);
            cwLower.close();
            fwLower.close();

            cw.writeAll(data);
            cw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/