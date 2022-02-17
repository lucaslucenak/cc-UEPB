package QuartoRoteiro;

import java.util.Scanner;

public class Huxley3604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String arrayInput = sc.nextLine();
            String[] arrayStr = arrayInput.split(" ");
            int[] arrayInt = parseInt(arrayStr);

            partition(arrayInt, 0, arrayInt.length - 1);
            printArray(arrayInt);
        }

        sc.close();
    }

    public static void partition(int[] array, int inicio, int fim) {

        int higherNumber = getHigherNumber(array);
        int lowerNumber = getLowerNumber(array);
        int pivot = (higherNumber + lowerNumber) / 2;
        int pivotIndex = verify(array, pivot);

        swap(array, pivotIndex, fim);

        System.out.println(array[fim]);

        int pivo = array[fim];

        int i = inicio;
        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                int aux = array[j];
                array[j] = array[i];
                array[i] = aux;
                i++;
            }
        }
        int aux = array[i];
        array[i] = array[fim];
        array[fim] = aux;

    }

    public static int verify(int[] array, int pivot) {

        int lower = getHigherNumber(array);
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == pivot) {
                return i;
            }
            else if (pivot > array[i]) {

                int difference = pivot - array[i];
                if (difference < lower) {
                    lower = difference;
                    index = i;
                }
            }
            else if (array[i] > pivot) {
                int difference = array[i] - pivot;
                if (difference < lower) {
                    lower = difference;
                    index = i;
                }
            }
        }
        return index;
    }

    public static int getHigherNumber(int[] list) {
        int maior = 0;
        for (int i : list) {
            if (i > maior) {
                maior = i;
            }
        }
        return maior;
    }

    public static int getLowerNumber(int[] list) {
        int menor = list[0];
        for (int j : list) {
            if (j < menor) {
                menor = j;
            }
        }
        return menor;
    }

    public static void swap(int[] array, int medianaIndex, int end) {
        int aux = array[end];
        array[end] = array[medianaIndex];
        array[medianaIndex] = aux;
    }

    public static int[] parseInt(String[] term) {
        int[] array = new int[term.length];
        for (int i = 0; i < term.length; i++) {
            array[i] = Integer.parseInt(term[i]);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
