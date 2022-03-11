package SextoRoteiro;

import java.util.Scanner;

class Fila {
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    int[] fila;

    public Fila() {
        inicio = fim = -1;
        tamanho = 100;
        fila = new int[tamanho];
        qtdeElementos = 0;
    }

    public boolean isEmpty() {
        return qtdeElementos == 0;
    }

    public boolean isFull() {
        return qtdeElementos == tamanho - 1;
    }

    public void add(int e) {
        if (!isFull()) {
            if (inicio == -1) {
                inicio = 0;
            }
            fim++;
            fila[fim] = e;
            qtdeElementos++;
        }
    }

    public void remove() {
        if (!isEmpty()) {
            inicio++;
            qtdeElementos--;
        }
    }

    public void show() {
        StringBuilder elementos = new StringBuilder();
        for (int i = inicio; i <= fim; i++) {
            if (i == fim) {
                elementos.append(fila[i]);
            }
            else {
                elementos.append(fila[i]).append(" ");
            }
        }
        System.out.print(elementos);
    }
}

public class Huxley2831 {
    public static void main(String[] args) {
        Fila f = new Fila();

        Scanner sc = new Scanner(System.in);

        String[] array;

        do {

            String entrada = sc.nextLine();

            array = entrada.split(" ");

            if (array[0].equals("Enfileirar")) {
                f.add(Integer.parseInt(array[1]));
            }
            if (array[0].equals("Desenfileirar")) {
                f.remove();
            }
            if (array[0].equals("Imprimir")) {
                f.show();
                System.out.println();
            }
        }

        while (!array[0].equals("Finalizar"));

    }
}