package entities;

public class Warehouse {

    public Warehouse() {
    }

    public String getInventory() {
        return "Suposto estoque da universidade";
    }

    public StringBuilder requestPurchaseOrder(String product) {
        StringBuilder purchaseOrder = new StringBuilder("Solicitando um pedido de compra para o produto ");
        return purchaseOrder.append(product);
    }

    public StringBuilder confirmPurchaseOrder(String product) {
        StringBuilder purchaseOrder = new StringBuilder("Pedido de compra confirmado para o produto ");
        return purchaseOrder.append(product);
    }
}
