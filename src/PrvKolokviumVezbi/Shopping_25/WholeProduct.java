package PrvKolokviumVezbi.Shopping_25;

public class WholeProduct extends Product{
    private int quantity;

    public WholeProduct(String id, String name, double price, int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }
}
