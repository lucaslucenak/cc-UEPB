package SextoRoteiro;

import java.io.*;
import java.util.*;

public class Huxley2295 {
    public Object[] Pilha1,Pilha2;
    public static int posicaoPilha1;
    public static int posicaoPilha2;
    public static int  o;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String option;
        Huxley2295 p = new Huxley2295();

        int input = sc.nextInt();
        String side;

        if(( 0 < input) && (input < 16)) {
            for(int i = 0; i < input; i++){
                option = sc.next();

                if (option.equals("E")){
                    side = sc.next();
                    p.stack(side, sc.nextInt());}

                if (option.equals("D")){
                    side = sc.next();
                    System.out.print((p.unstack(side)) + "\n");
                }
            }
        }
    }

    public Huxley2295() {
        posicaoPilha1 = -1;
        posicaoPilha2 = -1;

        this.Pilha1 = new Object[1000];
        this.Pilha2 = new Object[1000];
    }

    public boolean emptyStack(String lado) {
        if(lado.equals("e")){
            return posicaoPilha1 == -1;
        }

        if(lado.equals("d")){
            return posicaoPilha2 == -1;
        }
        return false;
    }

    public Object unstack(String side) {
        if(side.equals("e")) {

            if (emptyStack(side)) {
                return null;
            }
            return this.Pilha1[posicaoPilha1--];
        }
        if(side.equals("d")) {

            if (emptyStack(side)) {
                return null;
            }
            return this.Pilha2[posicaoPilha2--];
        }
        return 0;
    }

    public void stack(String side, Object valor) {
        if(side.equals("e")) {
            if (posicaoPilha1 < this.Pilha1.length - 1) {
                this.Pilha1[++posicaoPilha1] = valor;
            }
        }

        if(side.equals("d")) {
            if (posicaoPilha2 < this.Pilha2.length - 1) {
                this.Pilha2[++posicaoPilha2] = valor;
            }
        }
    }
}