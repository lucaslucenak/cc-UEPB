import java.util.Scanner;

public class Questao04 {
    public static void main(String []args) {
        /*Construa uma função que receba um nome e retorne o número de vogais.*/
        String nome;
        int quantidadeVogais;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digete um nome para verificar a quantidade de vogais: ");
        nome = entrada.next().toLowerCase();
        quantidadeVogais = contarVogais(nome);
        System.out.println("O nome " + nome + "tem " + quantidadeVogais + " vogais");

    }

    public static int contarVogais(String nomeF) {
        int numVogais = 0;
        for (int i = 0; i < nomeF.length(); i++) {
            if (nomeF.charAt(i) == 'a' || nomeF.charAt(i) == 'e' || nomeF.charAt(i) == 'i' || nomeF.charAt(i) == 'o' || nomeF.charAt(i) == 'u') {
                numVogais++;
            }
        }
        return numVogais;
    }
}
