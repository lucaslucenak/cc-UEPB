package QuintoRoteiro;

import java.util.Scanner;

public class Huxley577 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputStr;

        inputStr = sc.nextLine();

        String[] inputSplit = inputStr.split(" ");

        int[] array = new int[inputSplit.length];

        for (int i = 0; i < inputSplit.length; i++) {
            int aux;
            aux = Integer.parseInt(inputSplit[i]);
            array[i] = aux;
        }

        System.out.print("Estado inicial: ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + " | ");
            }
        }
        System.out.println();

        heapSort(array);

        System.out.print("Resultado Final: ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + " | ");
            }
        }
    }

    public static void heapSort(int[] array){
        int arrayLenght = array.length;
        int index = arrayLenght / 2, father, son, temp;


        while (true){
            if (index > 0){
                index--; temp = array[index];
            }

            else{
                System.out.print("Estado Atual da Heap:");
                for (int i = 0; i < arrayLenght; i++){

                    if(i < arrayLenght - 1) {
                        System.out.print(" "+array[i]+" |");
                    }
                    if(i == arrayLenght - 1) {
                        System.out.print(" "+array[i]+"\n");
                    }
                }
                if(arrayLenght != 1) {
                    System.out.print("Maior elemento neste passo: "+array[0]+"\n");
                }


                arrayLenght--;
                if (arrayLenght <= 0) {
                    return;
                }
                temp = array[arrayLenght];
                array[arrayLenght] = array[0];

            }

            father = index;
            son = ((index * 2) + 1);
            while (son < arrayLenght) {
                if ((son + 1 < arrayLenght) && (array[son + 1] > array[son])) {
                    son++;
                }
                if (array[son] > temp) {
                    array[father] = array[son];
                    father = son;
                    son = father * 2 + 1;
                }
                else {
                    break;
                }
            }
            array[father] = temp;
        }
    }
}