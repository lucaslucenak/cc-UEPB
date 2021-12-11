import java.util.*;
public class PasseioDoCavalo {

    static int [][]matrizLogica = new int[8][8]; //Tabuleiro
    static int posAtualX; //Posição inicial do Cavalo
    static int posAtualY; //Posição inicial do Cavalo
    static int counterMovimentos; //Conta a quantidade de movimentos realizados

    //Variáveis de controle para verificar se o cavalo se encontra "trancado"
    static boolean cantMove0 = false;
    static boolean cantMove1 = false;
    static boolean cantMove2 = false;
    static boolean cantMove3 = false;
    static boolean cantMove4 = false;
    static boolean cantMove5 = false;
    static boolean cantMove6 = false;
    static boolean cantMove7 = false;

    //MAIN
    public static void main(String []args) {
        Scanner entrada = new Scanner(System.in);
        int [][]tentativas = new int[1000][2]; //Armazena o numero de movimentos da 1000 tentativas
        int proxMovimento;

        //Passeio válido:
        posAtualX = 0; //Posição inicial do Cavalo
        posAtualY = 0; //Posição inicial do Cavalo
        counterMovimentos = 1;
        setMatrizes(); //Setando as matrizes com 0 em todas as posições
        matrizLogica[posAtualX][posAtualY] = counterMovimentos; // Inicialização do cavalo

        //Realiza o respectivo movimento selecionado
        movimento2();movimento1();movimento2();movimento3();
        movimento4();movimento3();movimento6();movimento1();
        movimento4();movimento6();movimento5();movimento6();
        movimento0();movimento7();movimento0();movimento2();
        movimento1();movimento2();movimento4();movimento6();
        movimento7();movimento5();movimento4();movimento1();
        movimento6();movimento1();movimento4();movimento4();
        movimento1();movimento4();movimento4();movimento1();
        movimento0();movimento6();movimento4();movimento3();
        movimento0();movimento3();movimento6();movimento1();
        movimento3();movimento1();movimento7();movimento6();
        movimento0();movimento1();movimento4();movimento4();
        movimento4();movimento2();movimento1();movimento6();
        movimento1();movimento7();movimento0();movimento5();
        movimento2();movimento4();movimento6();movimento5();
        movimento0();movimento2();movimento4();

        imprimirMatriz(matrizLogica); //Mostra o resultado do passeio
        System.out.println();

        System.out.print("Passeio concluído! Para cobntinuar para as 1000 execuções aleatórias digite qualquer tecla: ");
        String continuar = entrada.next();

        //1000 Execuções aleatórias
        for (int i = 0; i < 1000; i++) {
            posAtualX = gerarNumero(0, 7); //Posição inicial do Cavalo
            posAtualY = gerarNumero(0, 7); //Posição inicial do Cavalo

            counterMovimentos = 1;
            setMatrizes(); //Setando as matrizes com 0 em todas as posições
            matrizLogica[posAtualX][posAtualY] = counterMovimentos; // Inicialização do cavalo

            //Inicio do passeio
            System.out.println("Passeio n° " + (i + 1));
            for (;;) {
                proxMovimento = gerarNumero(0, 7); //Decide aleatoriamente qual movimento fazer

                //Realiza o respectivo movimento selecionado
                switch (proxMovimento) {
                    case 0 -> movimento0();
                    case 1 -> movimento1();
                    case 2 -> movimento2();
                    case 3 -> movimento3();
                    case 4 -> movimento4();
                    case 5 -> movimento5();
                    case 6 -> movimento6();
                    case 7 -> movimento7();
                }

                //Após cada movimento do cavalo, é verificado se todos já foram tentados e nenhum foi realizado
                if (cantMove0 && cantMove1 && cantMove2 && cantMove3 && cantMove4 && cantMove5 && cantMove6 && cantMove7) {
                    break;
                }

                imprimirMatriz(matrizLogica); //Exibe a rota que está sendo realizada
                System.out.println();
            }
            //Com o decorrer que o cavalo vai terminando os passeios, a quantidade de movimentos da tentativa é salva
            tentativas[i][0] = (i + 1);
            tentativas[i][1] = counterMovimentos;
        }

        //Aqui é exibido a quantidade de movimentos realizada para cada tentativa
        for (int i = 0; i < 30; i++){
            System.out.print("-");
        }
        System.out.println("\nTENTATIVA  MOVIMENTOS");
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("  " + tentativas[i][j] + "         ");
            }
            System.out.println();
        }
    }

    //---------------------------------------------------FUNÇÕES---------------------------------------------------

    //Setar as matrizes com 0 em todas as posições
    public static void setMatrizes() {
        //Setando a matriz Lógica como 0 em todas as posições
        for (int i = 0; i < matrizLogica.length; i++) {
            for (int j = 0; j < matrizLogica.length; j++) {
                matrizLogica[i][j] = 0;
            }
        }
    }

    //Imprime a matriz
    public static void imprimirMatriz(int [][]matriz) {
        // exibir números da coluna
        for (int k = 0; k < 8; k++)
            System.out.printf("\t%d", k);

        System.out.print("\n\n");

        for (int linha = 0; linha < matriz.length; linha++)
        {
            System.out.print (linha);

            for (int coluna = 0; coluna < matriz[linha].length; coluna++)
                System.out.printf("\t%d", matriz[linha][coluna]);

            System.out.println();
        }
    }


    //Gera um número inteiro aleatório
    public static int gerarNumero(int minimo, int maximo) {
        int valor = (int) Math.round(Math.random() * (maximo - minimo));
        return minimo + valor;
    }

    //----------------------------------------Movimentos----------------------------------------

    //Função que tem como intuito resetar todos os booleanos caso o movimento escolhido seja válido
    public static void resetarBooleanos() {
        cantMove0 = false;
        cantMove1 = false;
        cantMove2 = false;
        cantMove3 = false;
        cantMove4 = false;
        cantMove5 = false;
        cantMove6 = false;
        cantMove7 = false;
    }

    //Movimento 0
    public static void movimento0() {
        //Faz a alteração da proxima posição do cavalo
        posAtualX -= 2;
        posAtualY += 1;

        //Caso ela não vá para fora dos limites da matriz entra no if abaixo
        if ((posAtualX <= 7 && posAtualX >= 0) && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        //Caso ela vá para fora fos limites da matriz, desfaz a operação para não quebrar o programa
        else {
            posAtualX += 2;
            posAtualY -= 1;
            cantMove0 = true;
        }
    }

    //Movimento 1
    public static void movimento1() {
        posAtualX -= 1;
        posAtualY += 2;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX += 1;
            posAtualY -= 2;
            cantMove1 = true;
        }
    }

    //Movimento 2
    public static void movimento2() {
        posAtualX += 1;
        posAtualY += 2;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX -= 1;
            posAtualY -= 2;
            cantMove2 = true;
        }
    }

    //Movimento 3
    public static void movimento3() {
        posAtualX += 2;
        posAtualY += 1;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX -= 2;
            posAtualY -= 1;
            cantMove3 = true;
        }
    }

    //Movimento 4
    public static void movimento4() {
        posAtualX += 2;
        posAtualY -= 1;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX -= 2;
            posAtualY += 1;
            cantMove4 = true;
        }
    }

    //Movimento 5
    public static void movimento5() {
        posAtualX += 1;
        posAtualY -= 2;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX -= 1;
            posAtualY += 2;
            cantMove5 = true;
        }
    }

    //Movimento 6
    public static void movimento6() {
        posAtualX -= 1;
        posAtualY -= 2;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX += 1;
            posAtualY += 2;
            cantMove6 = true;
        }
    }

    //Movimento 7
    public static void movimento7() {
        posAtualX -= 2;
        posAtualY -= 1;
        if (posAtualX <= 7 && posAtualX >= 0 && posAtualY <= 7 && posAtualY >= 0 && (matrizLogica[posAtualX][posAtualY] == 0)) {
            counterMovimentos++;
            matrizLogica[posAtualX][posAtualY] = counterMovimentos;
            resetarBooleanos();
        }
        else {
            posAtualX += 2;
            posAtualY += 1;
            cantMove7 = true;
        }
    }
}