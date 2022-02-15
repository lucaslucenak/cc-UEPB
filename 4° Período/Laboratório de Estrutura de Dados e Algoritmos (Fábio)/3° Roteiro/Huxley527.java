import java.util.Scanner;

public class Huxley527 {
    public static void main (String []args) {
        Scanner entradaStr = new Scanner(System.in);
        String entrada, auxStr;
        int auxInt;

        entrada = entradaStr.nextLine();
        String[] entradaSplit = entrada.split(" ");
        int []array = new int[entradaSplit.length];

        for (int i = 0; i < entradaSplit.length; i++) {
            auxStr = entradaSplit[i];
            auxInt = Integer.parseInt(auxStr);
            array[i] = auxInt;
        }

        insertionSort(array);
        System.out.print("Resultado Final: ");
        printarProcesso(array);
    }

    public static void insertionSort(int[] arrayF) {
        for (int i = 1; i < arrayF.length; i++) {
            int key = arrayF[i];

            System.out.print("Chave: " + key + "\n");
            int aux = i - 1;

            System.out.print("Estado Atual: ");
            while (aux >= 0 && arrayF[aux] > key) {
                arrayF[aux + 1] = arrayF[aux];
                printarProcesso(arrayF); //PRINT DO PROCESSO DE ORDENAÇÃO COM A CHAVE ATUAL
                aux = aux - 1;
            }
                //JA VOLTO
            arrayF[aux + 1] = key;
            printarProcesso(arrayF);
            System.out.println();
        }
    }

    public static void printarProcesso(int []arrayF) {
        for (int k = 0; k < arrayF.length; k++) {
            if (k != arrayF.length - 1) {
                System.out.print(arrayF[k] + " | ");
            }
            else if (k == arrayF.length - 1) {
                System.out.print(arrayF[k]);
            }
        }
        System.out.println();

    }
}
