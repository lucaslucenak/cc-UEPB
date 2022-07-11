package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Writer;

public class WarehouseTest {
    Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
    }

    @Test
    public void shouldGetInventory() {
        Assertions.assertEquals("Suposto estoque da universidade", warehouse.getInventory());


    }

    @Test
    public void shouldRequestPurchaseOrder() {
        StringBuilder expected = new StringBuilder("Solicitando um pedido de compra para o produto Cloro");
        Assertions.assertEquals(expected.toString(), warehouse.requestPurchaseOrder("Cloro").toString());
    }

    @Test
    public void shouldConfirmPurchaseOrder() {
        StringBuilder expected = new StringBuilder("Pedido de compra confirmado para o produto Cloro");
        Assertions.assertEquals(expected.toString(), warehouse.confirmPurchaseOrder("Cloro").toString());
    }
}
