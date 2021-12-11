import java.util.Scanner;

public class Questao02 {
    public static void main(String []args) {
        /*Faça um programa que leia uma matriz MxN, onde M e N são informados pelo usuário,
        e que imprima o maior valor encontrado na matriz.*/

        int m, n, i, j;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a dimensão M: ");
        m = entrada.nextInt();
        System.out.print("Informe a dimensão N: ");
        n = entrada.nextInt();

        int matriz[][] = new int[m][n];
        int maiorNumero = matriz[0][0];

        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                System.out.print("Digite o valor do campo [" + (i+1) + "][" + (j+1) + "]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maiorNumero) {
                    maiorNumero = matriz[i][j];
                }
            }
        }

        System.out.println("O maior valor inserido na matriz é: " + maiorNumero);
    }
}
