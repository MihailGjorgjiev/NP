package PrvKolokviumVezbi.Shopping_25;

public class PieceProduct extends Product {
    private double quantity;

    public PieceProduct(String id, String name, double price, double quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }
}

