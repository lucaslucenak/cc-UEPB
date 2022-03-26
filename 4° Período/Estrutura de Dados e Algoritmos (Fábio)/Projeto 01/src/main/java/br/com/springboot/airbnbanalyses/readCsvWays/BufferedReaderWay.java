package br.com.springboot.airbnbanalyses.readCsvWays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderWay {
    public static void main (String []args) {
        String path = "E:\\Backup\\Lucas\\Tudo\\UEPB\\4° Período\\Estrutura de Dados e Algoritmos (Fábio)\\Projeto 01 (Play Store)\\googleplaystore.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}