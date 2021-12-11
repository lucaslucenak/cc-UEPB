import java.util.Scanner;

public class Questao01 {
    public static void main (String [] args) {
        /*Crie um programa para receber dois números e verificar se eles são iguais ou se um é
        maior que o outro. Imprima uma mensagem indicando se os números são iguais ou, no
        caso deles serem diferentes, imprima o maior valor digitado.*/

        double num1, num2;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o primeiro número: ");
        num1 = entrada.nextDouble();
        System.out.print("Informe o segundo número: ");
        num2 = entrada.nextDouble();

        if (num1 == num2) {
            System.out.println("Os números inseridos são iguais!");
        }

        else if (num1 > num2) {
            System.out.println("O primeiro número informado (" + num1 + ") é maior que o segundo (" + num2 + ")");
            System.out.println("Logo o maior número informado é: " + num1);
        }

        else {
            System.out.println("O segundo número informado (" + num2 + ") é maior que o primeiro (" + num1 + ")");
            System.out.println("Logo o maior número informado é: " + num2);
        }
    }
}
