import java.util.Scanner;

public class HuxleyCode {
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
        createMaxHeap(array);
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

    public static void maxHeapify(int[] array, int index, int arrayLenght) {
        int nodeLeft = 2 * index + 1, nodeRight = 2 * index + 2, maiorIndex = index;

        if (nodeLeft < arrayLenght && array[nodeLeft] > array[maiorIndex]) {
            maiorIndex = nodeLeft;
        }
        
        if (nodeRight < arrayLenght && array[nodeRight] > array[maiorIndex]) {
            maiorIndex = nodeRight;
        }
        
        if (maiorIndex != index) {
            int save = array[maiorIndex];
            array[maiorIndex] = array[index];
            array[index] = save;
            maxHeapify(array, maiorIndex, arrayLenght);
        }
    }

    public static void createMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
            
            if (i != array.length / 2) {
                System.out.print("Estado Atual: ");
                
                for (int j = 0; j < array.length; j++) {
                    if (j == array.length - 1)
                        System.out.print(array[j]);
                    else
                        System.out.print(array[j] + " | ");
                }
                
                System.out.println();
            }
        }
    }
}