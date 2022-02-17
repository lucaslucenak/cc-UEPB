package QuartoRoteiro;

import java.util.Scanner;

public class Huxley579 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String leitura = scanner.nextLine();

        String[] array = leitura.split(" ");

        int[] A = new int[array.length];

        for (int j = 0; j < array.length; j++) {
            A[j] = Integer.parseInt(array[j]);
        }

        System.out.print("Estado inicial: ");

        for (int i = 0; i < A.length; i++) {
            if (i == A.length-1) {
                System.out.print(A[i]);

            } else {System.out.print(A[i] + " | ");
            }

        }System.out.println("");
        System.out.println("");

        quickSort(A,0,A.length-1);

        System.out.print("Resultado Final: ");

        for (int u = 0; u < A.length; u++) {
            if (u == A.length-1) {
                System.out.print(A[u]);
            } else {System.out.print(A[u] + " | ");
            }
        }
    }


    private static int particiona(int[] A, int primeiro, int ultimo) {
        int pivot = A[ultimo];

        System.out.println("Pivot: " + pivot);
        System.out.print("Partition(A," + (primeiro+1) + "," + (ultimo+1) + "): " );

        for (int k = primeiro; k < ultimo; k++) {
            if (A[k] <= pivot) {
                System.out.print(A[k] + " ");}

        }
        System.out.print("<= "+ pivot + " <");

        int i = primeiro-1;

        for (int j = primeiro; j <= ultimo-1; j++) {
            if (A[j] <= pivot) {
                i = i+1;
                int troca = A[i];
                A[i] = A[j];
                A[j] = troca;
            }
        }

        int t = A[i+1];
        A[i+1] = A[ultimo];
        A[ultimo] = t;


        for (int k = primeiro; k <= ultimo; k++) {
            if (A[k] > pivot  ) {
                if(k == (ultimo-1)) {
                    System.out.print(" " + A[k]);
                }
                else {
                    System.out.print(" " + A[k]);
                }
            }
        }

        System.out.println();

        System.out.print("Estado atual de A: ");
        for (int r1 = 0; r1 < A.length; r1++) {
            if (r1 == A.length-1) {
                System.out.print(A[r1]);
            }
            else {
                System.out.print(A[r1] + " | ");
            }
        }

        System.out.println("");
        System.out.println("");

        return i+1;
    }


    private static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = particiona(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }
}
