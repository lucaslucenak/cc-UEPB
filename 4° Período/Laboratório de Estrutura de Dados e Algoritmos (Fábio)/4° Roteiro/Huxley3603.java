package QuartoRoteiro;

import java.util.Scanner;

public class Huxley3603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String array1Input = sc.nextLine();
        String array2Input = sc.nextLine();

        int[] array1 = parseInt(array1Input.split(" "));
        int[] array2 = parseInt(array2Input.split(" "));

        boolean vect_verific = verifyOrdenation(array1);
        boolean vect_verific2 = verifyOrdenation(array2);

        if (!vect_verific || !vect_verific2) {
            System.out.println(-1);
        }
        else {
            ordenate(array1);
            ordenate(array2);
            int[] intercalatedArray = intercalary(array1, array2);

            printArray(intercalatedArray);
        }

        sc.close();
    }

    public static int[] parseInt(String[] term) {
        int[] array = new int[term.length];
        for (int i = 0; i < term.length; i++) {
            array[i] = Integer.parseInt(term[i]);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public static boolean verifyOrdenation(int[] vect) {
        int[] vect_ordened = ordenate(vect.clone());
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != vect_ordened[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] intercalary(int[] array1, int[] array2) {
        int arraysLenght = (array1.length + array2.length);
        int[] intercalatedArray = new int[arraysLenght];

        fill(intercalatedArray, 0, array1, array1.length);
        fill(intercalatedArray, array1.length, array2, intercalatedArray.length);

        return ordenate(intercalatedArray);
    }

    public static void fill(int[] array, int position, int[] arrayToFill, int lastTerm) {
        int counter = 0;

        for (int i = position; i < lastTerm; i++) {
            array[i] = arrayToFill[counter];
            counter++;
        }
    }

    public static int[] ordenate(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int aux = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }
}