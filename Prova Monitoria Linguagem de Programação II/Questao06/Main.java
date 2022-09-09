package Questao06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String []args) {
        Scanner entradaStr = new Scanner(System.in);
        Scanner entradaNbr = new Scanner(System.in);
        List<Filme> filmes = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "° Filme:\n");
            System.out.print("Nome do filme: ");
            String nomeFilme = entradaStr.next();
            System.out.print("Nome do autor: ");
            String autor = entradaStr.next();
            System.out.print("Ano de lançamento: ");
            int ano = entradaNbr.nextInt();
            System.out.print("Preço: ");
            double preco = entradaNbr.nextDouble();
            Filme filme = new Filme(nomeFilme, autor, ano, preco);
            filmes.add(filme);
        }

        int counter = 0;
        for (Filme i : filmes) {
            counter++;
            System.out.println();
            System.out.printf("Nome do %d° filme: %s\n", counter, i.getNome());
            System.out.printf("Nome do autor do %d° filme: %s\n", counter, i.getAutor());
            System.out.printf("Ano de lançamento do %d° filme: %d\n", counter, i.getAno());
            System.out.printf("Preço do %d° filme: %.2f\n", counter, i.getPreco());
        }
    }
}
