import java.io.*;
import java.util.*;

public class HuxleyCode {
    public static void main (String []args) {
        String entrada_MN, entradaNumeros, mString, nString;
        String NumStr;
        int m, n, counter = 0, num;
        Scanner entradaStr = new Scanner(System.in);

        //Dimens�es da Matriz
        entrada_MN = entradaStr.nextLine();

        //Separando as dimens�es e convertendo o tipo primitivo
        String[] entradaSplit = entrada_MN.split(" ");
        mString = entradaSplit[0];
        nString =entradaSplit[1];
        m = Integer.parseInt(mString);
        n = Integer.parseInt(nString);

        int [][]matriz = new int[m][n]; //Cria��o da matriz
        int []arrayAux = new int[m * n];
        int outroCounter = 0;
        for (int i = 0; i < m; i++) {
            entradaNumeros = entradaStr.nextLine();
            entradaSplit = entradaNumeros.split(" ");

            for (String s : entradaSplit) {
                NumStr = s;
                num = Integer.parseInt(NumStr);
                arrayAux[outroCounter] = num;
                outroCounter++;
            }
            counter++;
            counter++;
        }

        insertionSort_Crescent(arrayAux); //Ordenando os n�meros fornecidos no array

        //Transferindo os dados do array para a matriz
        int counteraux = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = arrayAux[counteraux];
                counteraux++;
            }
        }

        //Print da matriz
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                if (j < (n-1)) {
                    System.out.print(matriz[i][j] + " ");
                }
                else {
                    System.out.print(matriz[i][j]);
                }

            }
        }
    }

    public static void insertionSort_Crescent(int[] arrayF) {
        int arrayFLenght = arrayF.length;
        for (int j = 1; j < arrayFLenght; j++) {
            int key = arrayF[j];
            int i = j - 1;
            while ((i > -1) && (arrayF[i] > key)) {
                arrayF[i + 1] = arrayF[i];
                i--;
            }
            arrayF[i + 1] = key;
        }
    }
}