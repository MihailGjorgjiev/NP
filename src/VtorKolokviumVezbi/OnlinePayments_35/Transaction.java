package VtorKolokviumVezbi.OnlinePayments_35;

public class Transaction {
    private String index;
    private String message;
    private int price;

    public Transaction(String index, String message, int price) {
        this.index = index;
        this.message = message;
        this.price = price;
    }

    public String getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %d",message,price);
    }
}
