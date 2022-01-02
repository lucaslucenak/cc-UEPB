package app;

import entities.PlayStoreApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String []args) {
        File path = new File("E:\\Backup\\Lucas\\Tudo\\UEPB\\4° Período\\Estrutura de Dados e Algoritmos (Fábio)\\Projeto 01 (Play Store)\\googleplaystore.csv"); //Endereço do arquivo
        List<PlayStoreApp> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //Descarta a primeira linha com o cabeçalho
            line = br.readLine();

            while (line != null) {
                String[] appData = line.split(","); //Os dados são separados por vírgulas no .clx (padrão internacional)
                setObject(appData, list);
                line = br.readLine();
            }

            System.out.println("Apps:");
            for (PlayStoreApp i : list) {
                System.out.println(i);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void setObject(String []appData, List<PlayStoreApp> list) {
        String name = appData[0];
        String category = appData[1];
        String rating = appData[2];
        //Double rating = Double.parseDouble(appData[2]);
        //Integer reviews = Integer.parseInt(appData[3]);
        String reviews = appData[3];
        String size = appData[4];
        String installs = appData[5];
        String type = appData[6];
        String price = appData[7];
        String contentRating = appData[8];
        String genres = appData[9];
        String lastUpdated = appData[10];
        String currentVer = appData[11];
        String androidVer  = appData[12];

        PlayStoreApp app = new PlayStoreApp(name, category, rating, reviews, size,
                installs, type, price, contentRating, genres, lastUpdated, currentVer,
                androidVer);

        list.add(app);
    }
}
