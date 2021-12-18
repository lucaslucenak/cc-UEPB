package Atividade01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Uri2916 {
    public static void main (String []args) {
        Scanner entrada = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, k, sumNotes = 0;

        while (entrada.hasNext()) {
            n = entrada.nextInt(); //Quantidade de notas
            k = entrada.nextInt(); //Quantidade de maiores notas a somar

            int []array = new int[n];

            //Recebe todas as n notas
            for (int i = 0; i < array.length; i++) {
                array[i] = entrada.nextInt();
            }

            insertionSortDescending(array); //Organiza de forma descrescente

            for (int i = 0; i < k; i++) { //Realiza a soma das k notas
                sumNotes += array[i];
            }

            System.out.println(sumNotes);
            sumNotes = 0; //contador é zerado para a próxima entrada
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
