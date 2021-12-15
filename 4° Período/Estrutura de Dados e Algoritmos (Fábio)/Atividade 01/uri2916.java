package Atividade01;
import java.util.Scanner;

public class Uri2916 {
    public static void main (String []args) {
        Scanner entrada = new Scanner(System.in);
        int n, k, sumNotes = 0;

        while (entrada.hasNext()){
            n = entrada.nextInt();
            k = entrada.nextInt();

            int []array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = entrada.nextInt();
            }

            insertionSortDescending(array);

            for (int i = 0; i < k; i++) {
                sumNotes += array[i];
            }

            System.out.println(sumNotes);
            sumNotes = 0;
        }
    }

    private static void insertionSortDescending(int[] arrayF) {
        for (int i = 1; i < arrayF.length; i++) {
            int valueToSort = arrayF[i];
            int j = i;
            while (j > 0 && arrayF[j - 1] < valueToSort) {
                arrayF[j] = arrayF[j - 1];
                j--;
            }
            arrayF[j] = valueToSort;
        }
    }
}