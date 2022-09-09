import java.util.Arrays;
import java.util.Scanner;

public class Huxley3588 {
    public static void main (String []args) {
        Scanner entradaStr = new Scanner(System.in);
        String entrada_MN, numerosStr, mString, nString, auxStr;
        int m, n, auxInt;

        entrada_MN = entradaStr.nextLine();

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

        selectionSort(array, n);
    }

    public static void selectionSort (int[] arrayF, int qtdVzs) {
        for (int i = 0; i < qtdVzs; i++) {
            int index = i;
            for (int j = i + 1; j < arrayF.length; j++) {
                if (arrayF[j] < arrayF[index]) {
                    index = j;
                }
            }
            int menorNumero = arrayF[index];
            arrayF[index] = arrayF[i];
            arrayF[i] = menorNumero;
            System.out.println(Arrays.toString(arrayF));
        }
    }
}
