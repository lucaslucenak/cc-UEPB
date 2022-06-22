package entities;

import java.util.List;

public class Financial {

    public Financial() {
    }

    public StringBuilder getAccountBalance(List<Bill> bills) {
        StringBuilder accountBalance = new StringBuilder("Componentes do balanço de contas:\n");
        for (Bill i : bills) {
            accountBalance.append("Nome: ").append(i.getName()).append(" | Value: ").append(i.getValue());
            accountBalance.append("\n");
        }
        return accountBalance;
    }

    public StringBuilder getPayRoll(String title, Double discounts, Double bruteValue) {
        StringBuilder payroll = new StringBuilder("Título: ");
        return payroll.append(title).append("\nValor Bruto: ").append(bruteValue).append("\nDiscontos: ")
                .append(discounts).append("\nValor Líquido: ").append(calculateLiquidValue(bruteValue, discounts));
    }

    public Double calculateLiquidValue(Double bruteValue, Double discounts) {
        return bruteValue - discounts;
    }
}
