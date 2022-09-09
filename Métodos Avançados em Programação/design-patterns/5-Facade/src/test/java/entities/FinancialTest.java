package entities;

import exceptions.DiscountsGreaterThanGrossAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FinancialTest {
    Financial financial;

    @BeforeEach
    void setUp() {
        financial = new Financial();
    }

    @Test
    void shouldGetAccountBalance() {
        List<Bill> accountBalance = new ArrayList<>();
        accountBalance.add(new Bill("Agua", 75.68));
        accountBalance.add(new Bill("Energia", 30.68));

        StringBuilder expected = new StringBuilder("Componentes do balanço de contas:\n" +
                "Nome: Agua | Value: 75.68\n" +
                "Nome: Energia | Value: 30.68\n");
        Assertions.assertEquals(expected.toString(), financial.getAccountBalance(accountBalance).toString());

    }

    @Test
    public void shouldGetPayroll() {
        StringBuilder expected = new StringBuilder("Título: Folha de pagamento de lucas\n" +
                "Valor Bruto: 1000.0\n" +
                "Discontos: 100.0\n" +
                "Valor Líquido: 900.0");

        Assertions.assertEquals(expected.toString(), financial.getPayRoll("Folha de pagamento de lucas",
                100.0, 1000.0).toString());
    }

    @Test
    public void shouldCalculateLiquidValue() {
        Assertions.assertEquals(900.0, financial.calculateLiquidValue(1000.0, 100.0));
    }

    @Test
    public void shouldThrowDiscountsGreaterThanGrossAmountException() {
        Assertions.assertThrows(DiscountsGreaterThanGrossAmountException.class, () -> {
            financial.calculateLiquidValue(1000.0, 1100.0);
        });
    }
}
