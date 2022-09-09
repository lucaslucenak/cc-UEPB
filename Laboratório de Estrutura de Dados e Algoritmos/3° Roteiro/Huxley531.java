package TerceiroRoteiro;

import java.util.Scanner;

public class Huxley531 {
    public static void main (String []args) {
        Scanner entrada = new Scanner(System.in);
        String numerosStr, auxStr;
        int auxInt;

        numerosStr = entrada.nextLine();
        String[] entradaSplit = numerosStr.split(" ");
        int[] array = new int[entradaSplit.length];

        for (int i = 0; i < entradaSplit.length; i++) {
            auxStr = entradaSplit[i];
            auxInt = Integer.parseInt(auxStr);
            array[i] = auxInt;
        }

        selectionSort(array);
        System.out.print("Resultado Final: ");
        for (int k = 0; k < array.length; k++) {
            if (k != array.length - 1) {
                System.out.print(array[k] + " | ");
            }
            else if (k == array.length - 1) {
                System.out.print(array[k]);
            }
        }
    }

    public static void selectionSort(int[] arrayF) {
        for (int i = 0; i < arrayF.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arrayF.length; j++) {
                if (arrayF[j] < arrayF[index]) {
                    index = j;
                }
            }
            int menorNumero = arrayF[index];
            arrayF[index] = arrayF[i];
            arrayF[i] = menorNumero;

            System.out.printf("Menor elemento neste passo: %d\n", menorNumero);
            System.out.print("Estado atual: ");
            for (int k = 0; k < arrayF.length; k++) {
                if (k != arrayF.length - 1) {
                    System.out.print(arrayF[k] + " | ");
                }
                else if (k == arrayF.length - 1) {
                    System.out.print(arrayF[k]);
                }
            }
            System.out.println("\n");
        }
    }
}
