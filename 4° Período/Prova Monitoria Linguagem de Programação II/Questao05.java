import java.util.Scanner;

public class Questao05 {
    public static void main(String[] args) {
        /*Elabore um programa que receba o valor da cotação do dólar, o valor em reais e
        apresente o valor em dólares*/
        Scanner entrada = new Scanner(System.in);
        double cotacao, valorReais, valorDolar;
        System.out.print("Digite a cotação do dólar: ");
        cotacao = entrada.nextDouble();
        System.out.print("Digite o valor em real para ser convertido para dólar: ");
        valorReais = entrada.nextDouble();

        valorDolar = dolarHoje(cotacao, valorReais);
        System.out.printf("O valor de R$%.2f em Dólar é: $%.2f", valorReais, valorDolar);
    }

    public static double dolarHoje(double cotacao, double valorReais) {
        double valorDolar = valorReais /cotacao;
        return valorDolar;
    }
}
