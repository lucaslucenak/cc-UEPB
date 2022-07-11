package entities;

import exceptions.DiscountsGreaterThanGrossAmountException;

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

    public StringBuilder getPayRoll(String title, Double discounts, Double grossAmount) {
        StringBuilder payroll = new StringBuilder("Título: ");
        return payroll.append(title).append("\nValor Bruto: ").append(grossAmount).append("\nDiscontos: ")
                .append(discounts).append("\nValor Líquido: ").append(calculateLiquidValue(grossAmount, discounts));
    }

    public Double calculateLiquidValue(Double grossAmount, Double discounts) {
        if (discounts > grossAmount) {
            throw new DiscountsGreaterThanGrossAmountException("Descontos maiores que o valor bruto");
        }
        return grossAmount - discounts;
    }
}
