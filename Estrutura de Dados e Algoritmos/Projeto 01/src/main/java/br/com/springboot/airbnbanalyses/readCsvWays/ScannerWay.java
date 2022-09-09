package br.com.springboot.airbnbanalyses.readCsvWays;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerWay {
    public static void main (String []args) {
        File file = new File("E:\\Backup\\Lucas\\Tudo\\UEPB\\4° Período\\Estrutura de Dados e Algoritmos (Fábio)\\Projeto 01 (Play Store)\\googleplaystore.csv"); //Endereço do arquivo

        try (Scanner sc = new Scanner(file)) { //Criar o scanner dentro do try evita que haja vazamento de memótia na leitura do arquivo
            while (sc.hasNextLine()) { //Lê o arquivo até que haja uma quebra de linha
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}