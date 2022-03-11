package SextoRoteiro;

import java.io.*;
import java.util.*;

public class Huxley2085 {


    static int[] oldManRow;
    static int[] comumRow;
    static int[] oldManIdRow;
    static int[] comumIdRow;
    static int oldManIdIndex;
    static int oldManIdRem = 0;
    static int comumIdIndex;
    static int comumIdRem = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;
        String[] inputSplit;
        
        oldManRow = new int[10];
        comumRow = new int[10];
        oldManIdRow = new int[10];
        comumIdRow = new int[10];
        int prioridade = sc.nextInt();
        int copia = prioridade;
        String option;
        
        do {
            option = sc.next();

            if (oldManIdIndex == oldManRow.length-1) {
                oldManRow = increaseArray(oldManRow);
                oldManIdRow = increaseArray(oldManIdRow);
            }

            if (comumIdIndex == comumRow.length-1) {
                comumRow = increaseArray(comumRow);
                comumIdRow = increaseArray(comumIdRow);
            }

            if((option.equals("i"))) {
                print();

            } 
            
            else if((option.equals("r"))) {

                if(copia > 0 && !(empty(oldManRow))) {
                    oldManRow[oldManIdRem] = 0;
                    oldManIdRem ++;
                    copia --;
                }
                else {

                    if(! empty(comumRow)) {
                        comumRow[comumIdRem] = 0;
                        comumIdRem ++;
                        copia = prioridade;}

                }

            } 
            else if (option.equalsIgnoreCase("a")) {
                sc.nextLine();
                input = sc.nextLine();
                inputSplit = input.split(" ");
                int id = Integer.parseInt(inputSplit[0]);
                int idade = Integer.parseInt(inputSplit[1]);
                if (idade>60) {
                    oldManRow[oldManIdIndex] = idade;
                    oldManIdRow[oldManIdIndex] = id;
                    oldManIdIndex ++;

                } 
                else {
                    comumRow[comumIdIndex] = idade;
                    comumIdRow[comumIdIndex] = id;
                    comumIdIndex ++;
                }
            }


        } while (! option.equals("f"));

    }

    public static int[] increaseArray(int[] vetor) {

        int[] novo = new int[vetor.length];
        System.arraycopy(vetor, 0, novo, 0, vetor.length);

        return novo;
    }

    public static void print() {
        System.out.println("fila de idosos:");
        if(empty(oldManRow)) {
            System.out.println("fila vazia!");
        }

        for (int i = 0; i < oldManRow.length; i++) {
            if(oldManRow[i] !=0) {
                System.out.println("ID: " + oldManIdRow[i] + " IDADE: " +  oldManRow[i]);}

        }
        System.out.println("fila de nao-idosos:");

        if(empty(comumRow)) {
            System.out.println("fila vazia!");
        }

        for (int i = 0; i < comumRow.length; i++) {
            if(comumRow[i] !=0) {
                System.out.println("ID: " + comumIdRow[i] + " IDADE: " +  comumRow[i]);}

        } System.out.println("----------");
        System.out.println();
    }

    public static boolean empty(int[] vetor) {
        for (int j : vetor) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}