import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      int aux;
        int[] array = new int[3];
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = entrada.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    
  }
}