package SextoRoteiro;

import java.util.*;

public class HuxleyCode {
    public Object[] pilha;
    public int posicaoPilha;

    public HuxleyCode() {
        this.posicaoPilha = -1;

        this.pilha = new Object[1000];

    }

    public boolean pilhaVazia() {
        return this.posicaoPilha == -1;
    }

    public int tamanho() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public Object exibeTodosValores(int valor) {
        //top
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha - valor];
    }

    public void desempilhar() {
        //pop
        if (pilhaVazia()) {
            return;
        }
        this.posicaoPilha--;
    }

    public void empilhar(Object valor) {
        // push
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }

    public static void main(String[] args) {
        HuxleyCode pilha = new HuxleyCode();
        Scanner sc = new Scanner(System.in);
        String[] array;

        do {
            String entrada = sc.nextLine();

            array = entrada.split(" ");

            if (array[0].equals("Empilhar")) {
                pilha.empilhar(array[1]);
            }
            if (array[0].equals("Desempilhar")) {
                pilha.desempilhar();
            }
            if (array[0].equals("Imprimir")) {
                int cont = 0;
                while (cont < pilha.tamanho()) {
                    if (cont == (pilha.tamanho()-1)) {
                        System.out.print(pilha.exibeTodosValores(cont));
                    }
                    else {
                        System.out.print(pilha.exibeTodosValores(cont) + " ");
                    }
                    cont++;
                }
                System.out.println();
            }
        }
        while (!array[0].equals("Finalizar"));

    }
}
