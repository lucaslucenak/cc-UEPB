import java.io.*;
import java.util.*;

public class HuxleyCode {
    public static void main (String []args) {
        int []array = new int[3];
        boolean hasNegative = false;
        Scanner entradaInt = new Scanner(System.in);
        //Entrada dos n�meros
        for (int i = 0; i <array.length; i++) {
            array[i] = entradaInt.nextInt();
            if (array[i] < 0) { //Valida ter um n�mero negativo
                hasNegative = true;
            }
        }

        if (hasNegative) {
            System.out.println("Ordenacao cancelada.");
        }


        if (array[0] % 2 == 0 && !hasNegative) { //Primeiro n�mero par (decrescente)
            insertionSort_Decreasing(array);
            showArray(array);
        }

        else if (array[0] % 2 == 1 && !hasNegative) { //Primeiro n�mero impar (crescente)
            insertionSort_Crescent(array);
            showArray(array);
        }


    }

    public static void showArray(int[] arrayF) {
        for (int j : arrayF) {
            System.out.println(j);
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

    public static void insertionSort_Decreasing(int[] arrayF) {
        int arrayFLenght = arrayF.length;
        for (int j = 1; j < arrayFLenght; j++) {
            int key = arrayF[j];
            int i = j - 1;
            while ((i > -1) && (arrayF[i] < key)) {
                arrayF[i + 1] = arrayF[i];
                i--;
            }
            arrayF[i + 1] = key;
        }
    }
}