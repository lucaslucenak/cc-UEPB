package br.com.springboot.airbnbanalyses.app;

import br.com.springboot.airbnbanalyses.entities.AirBnbListings;
import br.com.springboot.airbnbanalyses.ordenationMethods.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.*;

public class AirBnbAnalysesApplication {

    /*
    * Para que os arquivos sejam gerados corretamente é necessário que:
    * 1° - O clone do projeto seja realizado na área de trabalho (para evitar ter que trocar os parâmetros das constantes)
    * 2° - O valor da constante "USER" seja alterado para o nome do usuário que está logado no Windows
    * 3° - Após ajustar os endereços de criação dos arquivos, basta executar esta classe (AirBnbAnalysesApplication.java)
    */

    private static final String USER = "lukki"; // Alterar para o seu usuário
    private static final int SLEEP_TIME = 3000;

    private static final String CSV_LISTINGS = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\csvFiles\\listings.csv";
    private static final String CSV_LISTINGS_REVIEW_DATE = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\csvFiles\\listings_review_date.csv";
    private static final String CSV_LISTINGS_GT_AVG_PRICES = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\csvFiles\\listings_gt_avg_prices.csv";
    private static final String CSV_LISTINGS_LT_AVG_PRICES = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\csvFiles\\listings_lt_avg_prices.csv";



    private static final String CSV_LISTINGS_PRICE_COUNTINGSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_prices_countingSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_COUNTINGSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_prices_countingSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_COUNTINGSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_prices_countingSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_numberOfReviews_countingSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_numberOfReviews_countingSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\countingSort\\listings_numberOfReviews_countingSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_HEAPSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_prices_heapSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_HEAPSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_prices_heapSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_HEAPSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_prices_heapSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_HEAPSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_names_heapSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_HEAPSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_names_heapSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_HEAPSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_names_heapSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_numberOfReviews_heapSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_numberOfReviews_heapSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\heapSort\\listings_numberOfReviews_heapSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_INSERTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_names_insertionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_INSERTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_names_insertionSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_INSERTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_names_insertionSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_INSERTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_prices_insertionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_INSERTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_prices_insertionSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_INSERTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_prices_insertionSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_numberOfReviews_insertionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_numberOfReviews_insertionSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\insertionSort\\listings_numberOfReviews_insertionSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_MERGESORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_names_mergeSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_MERGESORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_names_mergeSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_MERGESORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_names_mergeSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_MERGESORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_prices_mergeSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_MERGESORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_prices_mergeSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_MERGESORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_prices_mergeSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_numberOfReviews_mergeSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_numberOfReviews_mergeSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\mergeSort\\listings_numberOfReviews_mergeSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_QUICKSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_prices_quickSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_QUICKSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_prices_quickSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_QUICKSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_prices_quickSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_QUICKSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_names_quickSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_QUICKSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_names_quickSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_QUICKSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_names_quickSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_numberOfReviews_quickSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_numberOfReviews_quickSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort\\listings_numberOfReviews_quickSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_QUICKSORT_MD3_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_names_quickSort_md3_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_QUICKSORT_MD3_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_names_quickSort_md3_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_QUICKSORT_MD3_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_names_quickSort_md3_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_numberOfReviews_quickSort_md3_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_numberOfReviews_quickSort_md3_piorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_numberOfReviews_quickSort_md3_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_QUICKSORT_MD3_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_price_quickSort_md3_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_QUICKSORT_MD3_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_price_quickSort_md3_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_QUICKSORT_MD3_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\quickSort_MedianaDe3\\listings_price_quickSort_md3_melhorCaso.csv";

    private static final String CSV_LISTINGS_NAMES_SELECTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_names_selectionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NAMES_SELECTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_names_selectionSort_piorCaso.csv";
    private static final String CSV_LISTINGS_NAMES_SELECTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_names_selectionSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_PRICE_SELECTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_price_selectionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_PRICE_SELECTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_price_selectionSort_piorCaso.csv";
    private static final String CSV_LISTINGS_PRICE_SELECTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_price_selectionSort_melhorCaso.csv";

    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MEDIOCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_numberOfReviews_selectionSort_medioCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_PIORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_numberOfReviews_selectionSort_melhorCaso.csv";
    private static final String CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MELHORCASO = "C:\\Users\\"+USER+"\\Desktop\\airBnb-dataAnalyses\\src\\main\\resources\\ordenatedCsvFiles\\selectionSort\\listings_numberOfReviews_selectionSort_piorCaso.csv";


    public static void main (String []args) {
        try {
            System.out.println("Criando os seguintes arquivos:\n" +
                    "listings_review_date.csv\n" +
                    "listings_gt_avg_prices.csv\n" +
                    "listings_lt_avg_prices.csv");
            sleep(SLEEP_TIME);


            List<AirBnbListings> list = readCsv(CSV_LISTINGS).parse();
            convertDate(list);
            List<Integer> priceList = createPriceList(list);

            //Cria os arquivos .csv "listings_review_date.csv", "listings_lt_avg_prices.csv" e "listings_gt_avg_prices.cvs"
            writeCsvFiles(CSV_LISTINGS_REVIEW_DATE, CSV_LISTINGS_GT_AVG_PRICES, CSV_LISTINGS_LT_AVG_PRICES, list, returnAvgPrice(priceList));
            System.out.println("Arquivos .csv criados com sucesso.");

            System.out.println("Lendo e armazenando os valores do arquivo 'listings_review_date.csv'...");
            sleep(SLEEP_TIME);
            List<AirBnbListings> listings_review_date = readCsv(CSV_LISTINGS_REVIEW_DATE).parse(); //Armazenando os valores em memória

            Integer[] arrayId = new Integer[listings_review_date.size()];
            String[] arrayName = new String[listings_review_date.size()];
            Integer[] arrayHostId = new Integer[listings_review_date.size()];
            String[] arrayHostName = new String[listings_review_date.size()];
            String[] arrayNeighbourhoodGroup = new String[listings_review_date.size()];
            String[] arrayNeighbourhood = new String[listings_review_date.size()];
            Double[] arrayLatitude = new Double[listings_review_date.size()];
            Double[] arrayLongitude = new Double[listings_review_date.size()];
            String[] arrayRoomType = new String[listings_review_date.size()];
            Integer[] arrayPrice = new Integer[listings_review_date.size()];
            Integer[] arrayMinimumNights = new Integer[listings_review_date.size()];
            Integer[] arrayNumberOfReviews = new Integer[listings_review_date.size()];
            String[] arrayLastReview= new String[listings_review_date.size()];
            Double[] arrayReviewsPerMonth = new Double[listings_review_date.size()];
            Integer[] arrayCalculatedHostListingsCount = new Integer[listings_review_date.size()];
            Integer[] arrayAvaiability365 = new Integer[listings_review_date.size()];

            Scanner sc = new Scanner(System.in);
            int opcaoAlgoritmo, opcaoParametro;

            do {
                resetArrays(listings_review_date, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

                System.out.println("Algoritmos de ordenação:\n" +
                        "1 - CountingSort\n" +
                        "2 - HeapSort\n" +
                        "3 - InsertionSort\n" +
                        "4 - MergeSort\n" +
                        "5 - QuickSort\n" +
                        "6 - QuickSort_MedianaDe3\n" +
                        "7 - SelectionSort\n" +
                        "8 - Sair\n");
                System.out.print("Algoritmo de ordenação desejado: ");
                opcaoAlgoritmo = sc.nextInt();


                if (opcaoAlgoritmo == 1) {
                    System.out.println("Selecionado: Counting Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Number of reviews\n" +
                            "3 - Todos\n" +
                            "Last review é indisponível\n" +
                            "Names é indisponível.\n");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] countingSort_Prices_executionTimes;

                        countingSort_Prices_executionTimes = CountingSortMethods.countigSort_Prices(listings_review_date, CSV_LISTINGS_PRICE_COUNTINGSORT_MEDIOCASO,
                            CSV_LISTINGS_PRICE_COUNTINGSORT_MELHORCASO, CSV_LISTINGS_PRICE_COUNTINGSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, arrayPrice.length);

                        printExecutionTimes(countingSort_Prices_executionTimes);
                    }

                    else if (opcaoParametro == 2) {
                        double[] countingSort_NumberOfReviews_executionTimes;

                        countingSort_NumberOfReviews_executionTimes = CountingSortMethods.countigSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MEDIOCASO,
                            CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, arrayPrice.length);

                        printExecutionTimes(countingSort_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        CountingSortMethods.countigSort_Prices(listings_review_date, CSV_LISTINGS_PRICE_COUNTINGSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_COUNTINGSORT_MELHORCASO, CSV_LISTINGS_PRICE_COUNTINGSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, arrayPrice.length);

                        CountingSortMethods.countigSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_COUNTINGSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, arrayPrice.length);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 2) {
                    System.out.println("Selecionado: Heap Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos\n");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] heapSort_Prices_executionTimes;

                        heapSort_Prices_executionTimes = HeapSortMethods.heapSort_Prices(CSV_LISTINGS_PRICE_HEAPSORT_MEDIOCASO,
                            CSV_LISTINGS_PRICE_HEAPSORT_MELHORCASO, CSV_LISTINGS_PRICE_HEAPSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(heapSort_Prices_executionTimes);
                    }

                    else if (opcaoParametro == 2) {
                        double[] heapSort_Names_executionTimes;

                        heapSort_Names_executionTimes = HeapSortMethods.heapSort_Names(CSV_LISTINGS_NAMES_HEAPSORT_MEDIOCASO,
                            CSV_LISTINGS_NAMES_HEAPSORT_MELHORCASO, CSV_LISTINGS_NAMES_HEAPSORT_PIORCASO, arrayName, arrayPrice, arrayId,
                            arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(heapSort_Names_executionTimes);
                    }

                    else if (opcaoParametro == 3) {
                        double[] heapSort_NumberOfReviews_executionTimes;

                        heapSort_NumberOfReviews_executionTimes = HeapSortMethods.heapSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MEDIOCASO,
                            CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(heapSort_NumberOfReviews_executionTimes);
                    }

                    else if (opcaoParametro == 4) {
                        HeapSortMethods.heapSort_Prices(CSV_LISTINGS_PRICE_HEAPSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_HEAPSORT_MELHORCASO, CSV_LISTINGS_PRICE_HEAPSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        HeapSortMethods.heapSort_Names(CSV_LISTINGS_NAMES_HEAPSORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_HEAPSORT_MELHORCASO, CSV_LISTINGS_NAMES_HEAPSORT_PIORCASO, arrayName, arrayPrice, arrayId,
                                arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        HeapSortMethods.heapSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_HEAPSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 3) {
                    System.out.println("Selecionado: Insertion Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] insertionSort_Prices_executionTimes;

                        insertionSort_Prices_executionTimes = InsertionSortMethods.insertionSort_Prices(CSV_LISTINGS_PRICE_INSERTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_PRICE_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_PRICE_INSERTIONSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(insertionSort_Prices_executionTimes);
                    }
                    else if (opcaoParametro == 2) {
                        double[] insertionSort_Names_executionTimes;

                        insertionSort_Names_executionTimes = InsertionSortMethods.insertionSort_Names(CSV_LISTINGS_NAMES_INSERTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_NAMES_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_NAMES_INSERTIONSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(insertionSort_Names_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        double[] insertionSort_NumberOfReviews_executionTimes;

                        insertionSort_NumberOfReviews_executionTimes = InsertionSortMethods.insertionSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(insertionSort_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 4) {
                        InsertionSortMethods.insertionSort_Prices(CSV_LISTINGS_PRICE_INSERTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_PRICE_INSERTIONSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        InsertionSortMethods.insertionSort_Names(CSV_LISTINGS_NAMES_INSERTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_NAMES_INSERTIONSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        InsertionSortMethods.insertionSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_INSERTIONSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 4) {
                    System.out.println("Selecionado: Merge Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] mergeSort_Prices_executionTimes;

                        mergeSort_Prices_executionTimes = MergeSortMethods.mergeSort_Prices(CSV_LISTINGS_PRICE_MERGESORT_MEDIOCASO,
                            CSV_LISTINGS_PRICE_MERGESORT_PIORCASO, CSV_LISTINGS_PRICE_MERGESORT_MELHORCASO,
                            arrayPrice, arrayId, arrayHostId,
                            arrayMinimumNights, arrayNumberOfReviews,
                            arrayCalculatedHostListingsCount, arrayAvaiability365,
                            arrayName, arrayHostName, arrayNeighbourhoodGroup,
                            arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude,
                            arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(mergeSort_Prices_executionTimes);
                    }
                    else if (opcaoParametro == 2) {
                        double[] mergeSort_Names_executionTimes;

                        mergeSort_Names_executionTimes = MergeSortMethods.mergeSort_Names(CSV_LISTINGS_NAMES_MERGESORT_MEDIOCASO,
                            CSV_LISTINGS_NAMES_MERGESORT_MELHORCASO, CSV_LISTINGS_NAMES_MERGESORT_PIORCASO,
                            arrayName, arrayPrice, arrayId,
                            arrayHostId, arrayMinimumNights, arrayNumberOfReviews,
                            arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup,
                            arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude,
                            arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(mergeSort_Names_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        double[] mergeSort_NumberOfReviews_executionTimes;

                        mergeSort_NumberOfReviews_executionTimes = MergeSortMethods.mergeSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MEDIOCASO,
                            CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_PIORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MELHORCASO,
                            arrayPrice, arrayId, arrayHostId,
                            arrayMinimumNights, arrayNumberOfReviews,
                            arrayCalculatedHostListingsCount, arrayAvaiability365,
                            arrayName, arrayHostName, arrayNeighbourhoodGroup,
                            arrayNeighbourhood, arrayRoomType,
                            arrayLastReview, arrayLatitude, arrayLongitude,
                            arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(mergeSort_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 4) {
                        MergeSortMethods.mergeSort_Prices(CSV_LISTINGS_PRICE_MERGESORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_MERGESORT_PIORCASO, CSV_LISTINGS_PRICE_MERGESORT_MELHORCASO,
                                arrayPrice, arrayId, arrayHostId,
                                arrayMinimumNights, arrayNumberOfReviews,
                                arrayCalculatedHostListingsCount, arrayAvaiability365,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup,
                                arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude,
                                arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        MergeSortMethods.mergeSort_Names(CSV_LISTINGS_NAMES_MERGESORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_MERGESORT_MELHORCASO, CSV_LISTINGS_NAMES_MERGESORT_PIORCASO,
                                arrayName, arrayPrice, arrayId,
                                arrayHostId, arrayMinimumNights, arrayNumberOfReviews,
                                arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup,
                                arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude,
                                arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        MergeSortMethods.mergeSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_PIORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_MERGESORT_MELHORCASO,
                                arrayPrice, arrayId, arrayHostId,
                                arrayMinimumNights, arrayNumberOfReviews,
                                arrayCalculatedHostListingsCount, arrayAvaiability365,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup,
                                arrayNeighbourhood, arrayRoomType,
                                arrayLastReview, arrayLatitude, arrayLongitude,
                                arrayReviewsPerMonth, 0, arrayPrice.length-1);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 5) {
                    System.out.println("Selecionado: Quick Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] quickSort_Prices_executionTimes;

                        quickSort_Prices_executionTimes = QuickSortMethods.quickSort_Prices(listings_review_date, CSV_LISTINGS_PRICE_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_QUICKSORT_MELHORCASO, CSV_LISTINGS_PRICE_QUICKSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(quickSort_Prices_executionTimes);
                    }
                    else if (opcaoParametro == 2) {
                        double[] quickSort_Names_executionTimes;

                        quickSort_Names_executionTimes = QuickSortMethods.quickSort_Names(listings_review_date, CSV_LISTINGS_NAMES_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_QUICKSORT_MELHORCASO, CSV_LISTINGS_NAMES_QUICKSORT_PIORCASO,
                                arrayAvaiability365, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayName.length-1);

                        printExecutionTimes(quickSort_Names_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        double[] quickSort_NumberOfReviews_executionTimes;

                        quickSort_NumberOfReviews_executionTimes = QuickSortMethods.quickSort_NumberOfReviews(listings_review_date, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_PIORCASO,
                                arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(quickSort_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 4) {
                        QuickSortMethods.quickSort_Prices(listings_review_date, CSV_LISTINGS_PRICE_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_QUICKSORT_MELHORCASO, CSV_LISTINGS_PRICE_QUICKSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        QuickSortMethods.quickSort_Names(listings_review_date, CSV_LISTINGS_NAMES_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_QUICKSORT_MELHORCASO, CSV_LISTINGS_NAMES_QUICKSORT_PIORCASO,
                                arrayAvaiability365, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayName.length-1);

                        QuickSortMethods.quickSort_NumberOfReviews(listings_review_date, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_PIORCASO,
                                arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 6) {
                    System.out.println("Selecionado: Quick Sort_Mediana de 3\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] quickSortMD3_Prices_executionTimes;

                        quickSortMD3_Prices_executionTimes = QuickSort_MedianaDe3_Methods.quickSortMD3_Prices(CSV_LISTINGS_PRICE_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_PRICE_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_PRICE_QUICKSORT_MD3_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(quickSortMD3_Prices_executionTimes);
                    }
                    else if (opcaoParametro == 2) {
                        double[] quickSortMD3_Names_executionTimes;

                        quickSortMD3_Names_executionTimes = QuickSortMethods.quickSort_Names(listings_review_date, CSV_LISTINGS_NAMES_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_NAMES_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_NAMES_QUICKSORT_MD3_PIORCASO,
                                arrayAvaiability365, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayName.length-1);

                        printExecutionTimes(quickSortMD3_Names_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        double[] quickSort_MD3_NumberOfReviews_executionTimes;

                        quickSort_MD3_NumberOfReviews_executionTimes = QuickSortMethods.quickSort_NumberOfReviews(listings_review_date, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_PIORCASO,
                                arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        printExecutionTimes(quickSort_MD3_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 4) {
                        QuickSort_MedianaDe3_Methods.quickSortMD3_Prices(CSV_LISTINGS_PRICE_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_PRICE_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_PRICE_QUICKSORT_MD3_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);

                        QuickSortMethods.quickSort_Names(listings_review_date, CSV_LISTINGS_NAMES_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_NAMES_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_NAMES_QUICKSORT_MD3_PIORCASO,
                                arrayAvaiability365, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayName.length-1);

                        QuickSortMethods.quickSort_NumberOfReviews(listings_review_date, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_QUICKSORT_MD3_PIORCASO,
                                arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, 0, arrayPrice.length-1);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 7) {
                    System.out.println("Selecionado: Selection Sort\n");
                    System.out.println("Parâmetros de ordenação:\n" +
                            "1 - Prices\n" +
                            "2 - Names\n" +
                            "3 - Number of reviews\n" +
                            "4 - Todos\n");
                    System.out.print("Parâmetro de ordenação desejado: ");
                    opcaoParametro = sc.nextInt();
                    System.out.println("Ordenando e gerando os arquivos...");
                    sleep(SLEEP_TIME);

                    if (opcaoParametro == 1) {
                        double[] selectionSort_Prices_executionTimes;

                        selectionSort_Prices_executionTimes = SelectionSortMethods.selectionSort_Prices(CSV_LISTINGS_PRICE_SELECTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_PRICE_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_PRICE_SELECTIONSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                            arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(selectionSort_Prices_executionTimes);
                    }
                    else if (opcaoParametro == 2) {
                        double[] selectionSort_Names_executionTimes;

                        selectionSort_Names_executionTimes = SelectionSortMethods.selectionSort_Names(CSV_LISTINGS_NAMES_SELECTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_NAMES_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_NAMES_SELECTIONSORT_PIORCASO,
                            arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                            arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(selectionSort_Names_executionTimes);
                    }
                    else if (opcaoParametro == 3) {
                        double[] selectionSort_NumberOfReviews_executionTimes;

                        selectionSort_NumberOfReviews_executionTimes = SelectionSortMethods.selectionSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MEDIOCASO,
                            CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_PIORCASO,
                            arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                            arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                            arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        printExecutionTimes(selectionSort_NumberOfReviews_executionTimes);
                    }
                    else if (opcaoParametro == 4) {

                        SelectionSortMethods.selectionSort_Prices(CSV_LISTINGS_PRICE_SELECTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_PRICE_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_PRICE_SELECTIONSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        SelectionSortMethods.selectionSort_Names(CSV_LISTINGS_NAMES_SELECTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_NAMES_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_NAMES_SELECTIONSORT_PIORCASO,
                                arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

                        SelectionSortMethods.selectionSort_NumberOfReviews(CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MEDIOCASO,
                                CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_MELHORCASO, CSV_LISTINGS_NUMBEROFREVIEWS_SELECTIONSORT_PIORCASO,
                                arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount,
                                arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood,
                                arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
                    }

                    else {
                        System.out.println("Opção inválida.");
                    }
                }

                else if (opcaoAlgoritmo == 8) {
                    System.exit(0);
                }

                else {
                    System.out.println("Opção inválida.\n");
                }

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void printExecutionTimes(double[] executionTimes) {
        System.out.println("Tempo de execução do médio caso: " + executionTimes[0]);
        System.out.println("Tempo de execução do melhor caso: " + executionTimes[1]);
        System.out.println("Tempo de execução do pior caso: " + executionTimes[2]);
    }

    public static void sleep(int time) {
        try { Thread.sleep (time);
        } catch (InterruptedException e) {
            System.out.println("ERRO: " + e);
        }
    }

    //Reseta os arrays para o médio caso
    public static void resetArrays(List<AirBnbListings> listings_review_date, Integer[] arrayId, String[] arrayName, Integer[] arrayHostId,
                                   String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, Double[] arrayLatitude, Double[] arrayLongitude,
                                   String[] arrayRoomType, Integer[] arrayPrice, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews,
                                   String[] arrayLastReview, Double[] arrayReviewsPerMonth, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365) {

        //Movendo todos os arquivos do objeto para um array simples
        int j = 0;
        for (AirBnbListings i : listings_review_date) {
            arrayId[j] = i.getId();
            arrayName[j] = i.getName();
            arrayHostId[j] = i.getHost_id();
            arrayHostName[j] = i.getHost_name();
            arrayNeighbourhoodGroup[j] = i.getNeighbourhood_group();
            arrayNeighbourhood[j] = i.getNeighbourhood();
            arrayLatitude[j] = i.getLatitude();
            arrayLongitude[j] = i.getLongitude();
            arrayRoomType[j] = i.getRoom_type();
            arrayPrice[j] = i.getPrice();
            arrayMinimumNights[j] = i.getMinimum_nights();
            arrayNumberOfReviews[j] = i.getNumber_of_reviews();
            arrayLastReview[j] = i.getLast_review();
            arrayReviewsPerMonth[j] = i.getReviews_per_month();
            arrayCalculatedHostListingsCount[j] = i.getCalculated_host_listings_count();
            arrayAvaiability365[j] = i.getAvailability_365();
            j++;
        }
    }

    //Cria uma lista com os preços apenas
    public static List<Integer> createPriceList(List<AirBnbListings> list) {
        List<Integer> priceList = new ArrayList<>();

        for (AirBnbListings i : list) {
            Integer price = i.getPrice();
            //Integer price = Integer.parseInt(i.getPrice());
            priceList.add(price);
        }

        return priceList;
    }

    //Recebe uma lista de preços e retorna a média dela
    public static int returnAvgPrice(List<Integer> priceList) {
        int avgPrice;
        int priceCounter = 0, diviser = 0;

        for (Integer i : priceList) {
            priceCounter += i;
            diviser++;
        }

        avgPrice =(priceCounter / diviser);

        return  avgPrice;
    }

}