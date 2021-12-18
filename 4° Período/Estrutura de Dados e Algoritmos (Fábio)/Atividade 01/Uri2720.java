package Atividade01;
import java.util.Scanner;

public class Uri2720 {
    public static void main (String []args) {
        int k, n, t;
        int i, h, w, l, volume;
        Scanner entrada = new Scanner(System.in);

        t = entrada.nextInt();
        for (int p = 0; p < t; p++) {
            n = entrada.nextInt(); //qtd de presentes do papai noel
            k = entrada.nextInt(); //nmr de presentes que bruninho vai ganhar
            int [][]matriz = new int[n][2];
            int []presentesBruninho = new int[k];

            //Lê todas as entradas
            for (int j = 0; j < n; j++) {
                i = entrada.nextInt(); //id do presente
                h = entrada.nextInt(); //altura do presente
                w = entrada.nextInt(); //largura do presente
                l = entrada.nextInt(); //comprimento do presente
                volume = h * w * l;
                matriz[j][0] = i;
                matriz[j][1] = volume;
            }

            //Verificar se há dois presentes com o mesmo volume
            boolean hasMesmoVolume = false;
            for (int g = 0; g < n - 1; g++) {
                if (matriz[g][1] == matriz[g + 1][1]) {
                    hasMesmoVolume = true;
                    break;
                }
            }
            ordenarVolumes(matriz, 0, n - 1);
            //ordenarVolumes(matriz, n);

            if (hasMesmoVolume) {
                ordenarIds(matriz, 0, n - 1);
                ordenarVolumes(matriz, 0, n - 1);

                //ordenarIds(matriz, n);
                //ordenarVolumes(matriz, n);
                adicionarPresentes(presentesBruninho, matriz, k);
            }

            else {
                adicionarPresentes(presentesBruninho, matriz, k);
            }


           //ordenarPresentes(presentesBruninho);
            System.out.println("Matriz no estado final: ");
            printarMatriz(matriz, n);
            System.out.println("\npresentes do burno: ");
            printarPresentes(presentesBruninho);
            System.out.println();
        }
    }

    public static void printarPresentes(int []array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + " ");
            }
            else {
                System.out.print(array[i]);
            }
        }

    }

    public static void printarMatriz(int [][]matrizF, int n) {
        for (int g = 0; g < n; g++) {
            System.out.println();
            for (int f = 0; f < 2; f++) {
                System.out.print(matrizF[g][f] + " ");
            }
        }
    }

    public static void ordenarIds(int[][] matriz, int esquerda, int direita) { //quick sort
        int esq = esquerda;
        int dir = direita;
        int pivo = matriz[(esq + dir) / 2][0];
        int troca, troca2;

        while (esq <= dir) {
            while (matriz[esq][0] < pivo) {
                esq = esq + 1;
            }
            while (matriz[dir][0] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = matriz[esq][0];
                troca2 = matriz[esq][1];
                matriz[esq][0] = matriz[dir][0];
                matriz[esq][1] = matriz[dir][1];
                matriz[dir][0] = troca;
                matriz[dir][1] = troca2;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda)
            ordenarVolumes(matriz, esquerda, dir);

        if (esq < direita)
            ordenarVolumes(matriz, esq, direita);

    }


    public static void ordenarVolumes(int[][] matriz, int esquerda, int direita) { //quick sort
        int esq = esquerda;
        int dir = direita;
        int pivo = matriz[(esq + dir) / 2][1];
        int troca, troca2;

        while (esq <= dir) {
            while (matriz[esq][1] < pivo) {
                esq = esq + 1;
            }
            while (matriz[dir][1] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = matriz[esq][1];
                troca2 = matriz[esq][0];
                matriz[esq][1] = matriz[dir][1];
                matriz[esq][0] = matriz[dir][0];
                matriz[dir][1] = troca;
                matriz[dir][0] = troca2;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda)
            ordenarVolumes(matriz, esquerda, dir);

        if (esq < direita)
            ordenarVolumes(matriz, esq, direita);

    }

    /*public static void ordenarVolumes(int[][] matrizF, int n) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(matrizF[j][1] < matrizF[j + 1][1]) {
                    int aux = matrizF[j][1];
                    int aux2 = matrizF[j][0];
                    matrizF[j][1] = matrizF[j + 1][1];
                    matrizF[j][0] = matrizF[j + 1][0];
                    matrizF[j + 1][1] = aux;
                    matrizF[j + 1][0] = aux2;

                }
            }
        }
    }*/

    /*public static void ordenarIds(int[][] matrizF, int n) {
        for(int s = 0; s < n - 1; s++) {
            for(int j = 0; j < n - 1; j++) {
                if(matrizF[j][0] > matrizF[j + 1][0]) {
                    int aux = matrizF[j][0];
                    int aux2 = matrizF[j][1];
                    matrizF[j][0] = matrizF[j + 1][0];
                    matrizF[j][1] = matrizF[j + 1][1];
                    matrizF[j + 1][0] = aux;
                    matrizF[j + 1][1] = aux2;

                }
            }
        }
    }*/

    public static void ordenarPresentes(int []presentes) {
        for(int i = 0; i < presentes.length - 1; i++) {
            for(int j = 0; j < presentes.length - 1 - i; j++) {
                if(presentes[j] > presentes[j + 1]) {
                    int aux = presentes[j];
                    presentes[j] = presentes[j + 1];
                    presentes[j + 1] = aux;
                }
            }
        }
    }

    public static void adicionarPresentes(int []listaPresentes, int [][]matrizF ,int k) {
        for (int i = k - 1; i >= 0; i--) {
            listaPresentes[i] = matrizF[i][0];
        }

        /*for (int z = 0; z < k; z++) { //adicionando os presentes que o bruninho quer
            listaPresentes[z] = matrizF[z][0];
        }*/

    }

}
