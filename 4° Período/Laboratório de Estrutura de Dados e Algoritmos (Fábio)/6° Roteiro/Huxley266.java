package SextoRoteiro;

import java.io.*;
import java.util.*;

public class Huxley266 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entradaStr = sc.nextLine();

        int[] entradaInt = parseInt(entradaStr.split(" "));

        insertionSort(entradaInt);

        for (int j : entradaInt) {
            System.out.print(j + " ");
        }
    }

    private static int[] parseInt(String[] entrada) {

        int[] array = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }
        return array;
    }

    public static void insertionSort(int[] array) {

        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}