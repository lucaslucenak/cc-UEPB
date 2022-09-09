import java.util.Arrays;
import java.util.Scanner;

public class Huxley3584 {
    public static void main (String []args) {
        Scanner entradaStr = new Scanner(System.in);
        String entrada_MN, numerosStr, mString, nString, auxStr;
        int m, n, auxInt;

        //Dimensões da Matriz
        entrada_MN = entradaStr.nextLine();

        //Separando as dimensões e convertendo o tipo primitivo
        String[] entradaSplit = entrada_MN.split(" ");
        mString = entradaSplit[0];
        nString =entradaSplit[1];
        m = Integer.parseInt(mString);
        n = Integer.parseInt(nString);
        int []array = new int[m];

        numerosStr = entradaStr.nextLine();
        entradaSplit = numerosStr.split(" ");

        for (int i = 0; i < m; i++) {
            auxStr = entradaSplit[i];
            auxInt = Integer.parseInt(auxStr);
            array[i] = auxInt;
        }
        bubbleSort(array, n);
    }

    public static void bubbleSort(int[] arrayF, int qtdVzs) {
        for (int i = 0; i < qtdVzs; i++) {
            for (int j = 0; j < arrayF.length - 1 - i; j++) {
                if (arrayF[j] > arrayF[j + 1]) {
                    int aux = arrayF[j];
                    arrayF[j] = arrayF[j + 1];
                    arrayF[j + 1] = aux;
                }
            }
            System.out.println(Arrays.toString(arrayF));
        }
    }
}
