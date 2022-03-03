package QuintoRoteiro;

import java.util.Scanner;

public class Huxley577 {
    public static int counter = 0;
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

        System.out.print("Estado inicial: ");

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " | ");
        }
        System.out.println();

        System.out.print("Estado Atual da Heap: ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " | ");
        }
        System.out.println();
        System.out.println("Maior elemento neste passo: " + array[0]);
        HeapSort(array);
        System.out.print("Estado Final: ");

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " | ");
        }

    }

    public static void HeapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            aplicarHeap(array, n, i);
        }

        for (int j = n - 1; j > 0; j--) {
            int auxC = array[0];
            array[0] = array[j];
            array[j] = auxC;
            aplicarHeap(array, j, 0);
            System.out.print("Estado Atual da Heap: ");
            int tamanho = array.length - counter;

            for (int k = 0; k < tamanho; k++) {
                if (k == tamanho - 1) {

                }
                else if (k == tamanho - 2) {
                    System.out.print(array[k]);
                }
                else {
                    System.out.print(array[k] + " | ");
                }

            }
            counter++;
            System.out.println();
            System.out.println("Maior elemento neste passo: " + array[0]);
        }
    }

    public static void aplicarHeap(int[] array, int n, int i) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && array[esquerda] > array[raiz]) {
            raiz = esquerda;
        }
        if (direita < n && array[direita] > array[raiz]) {
            raiz = direita;
        }

        if (raiz != i) {
            int auxC = array[i];
            array[i] = array[raiz];
            array[raiz] = auxC;
            aplicarHeap(array, n, raiz);
        }
    }
}