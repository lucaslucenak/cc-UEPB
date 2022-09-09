import java.util.Scanner;

public class Questao03 {
    public static void main(String[] args) {
        /*Construa um programa que recebe duas matrizes inteiras de ordem 5 e imprima a soma
        e a diferença entre elas*/
        int i, j;
        Scanner entrada = new Scanner(System.in);
        int matriz1[][] = new int[5][5], matriz2[][] = new int[5][5], matrizSomada[][] = new int[5][5], matrizSubtraida[][] = new int[5][5];
        int somaMatriz1 = 0, somaMatriz2 = 0;

        for (i = 0; i < matriz1.length; i++) {
            for (j = 0; j < matriz1.length; j++) {
                System.out.print("Digite o valor do campo [" + (i+1) + "] [" + (j+1) + "] primeira matriz 5x5: ");
                matriz1[i][j] = entrada.nextInt();
                somaMatriz1 += matriz1[i][j];
            }
        }

        for (i = 0; i < matriz2.length; i++) {
            for (j = 0; j < matriz2.length; j++) {
                System.out.print("Digite o valor do campo [" + (i+1) + "] [" + (j+1) + "] segunda matriz 5x5: ");
                matriz2[i][j] = entrada.nextInt();
                somaMatriz2 += matriz2[i][j];
            }
        }

        for (i = 0; i < matriz2.length; i++) {
            for (j = 0; j < matriz2.length; j++) {
                matrizSomada[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        for (i = 0; i < matriz2.length; i++) {
            for (j = 0; j < matriz2.length; j++) {
                matrizSubtraida[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        System.out.println("SOMA DAS MATRIZES: ");

        for(i = 0; i < matriz2.length; i++) {
            System.out.print("\n");
            for (j = 0; j < matriz2.length; j++) {
                System.out.print(matrizSomada[i][j] + " ");
            }
        }

        System.out.print("\n");
        System.out.println("SUBTRAÇÃO DAS MATRIZES: ");
        for(i = 0; i < matriz2.length; i++) {
            System.out.print("\n");
            for (j = 0; j < matriz2.length; j++) {
                System.out.print(matrizSubtraida[i][j] + " ");
            }
        }

        System.out.println("\nSoma dos valores das matrizes: " + (somaMatriz1 + somaMatriz2));
        System.out.println("Diferença dos valores das matrizes: " + (somaMatriz1 - somaMatriz2));

    }
}
