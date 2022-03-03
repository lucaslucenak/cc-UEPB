package QuintoRoteiro;

import java.util.Scanner;

public class Huxley3931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr;

        inputStr = sc.nextLine();

        String[] inputSplit = inputStr.split(" ");

        int[] array = new int[inputSplit.length];

        for (int i = 0; i < inputSplit.length; i++) {
            int aux;
            aux = Integer.parseInt(inputSplit[i]);
            array[i] = aux;
        }

        countSort(array, array.length);
        System.out.println();
        for (int j : array) {
            System.out.print(j + " ");
        }

    }

    public static void countSort(int[] v1, int size) {
        int[] arrayOut = new int[size + 1];


        int max = v1[0];
        for (int i = 1; i < size; i++) {

            if (v1[i] > max) {
                max = v1[i];
            }
        }

        int[] count = new int[max + 1];


        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }


        for (int i = 0; i < size; i++) {
            count[v1[i]]++;
        }

        for (int j : count) {
            System.out.print(j + " ");
        }


        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            arrayOut[count[v1[i]] - 1] = v1[i];
            count[v1[i]]--;
        }

        if (size >= 0) System.arraycopy(arrayOut, 0, v1, 0, size);
    }
}
