package Labs.Lab3.PizzaOrder;

public class PizzaItem implements Item {
    private String type;
    private static final String[] VALID_TYPES = {"Standard", "Pepperoni", "Vegetarian"};

    public PizzaItem(String type) throws InvalidPizzaTypeException {
        boolean isValidType = false;

        for (String validType : VALID_TYPES) {
            if (validType.equals(type)) {
                isValidType = true;
                break;
            }
        }
        if (!isValidType) {
            throw new InvalidPizzaTypeException("InvalidPizzaTypeException");
        }
        this.type = type;
    }

    @Override
    public int getPrice() {
        if (type.equals("Standard")) {
            return 10;
        } else if (type.equals("Pepperoni")) {
            return 12;
        } else if (type.equals("Vegetarian")) {
            return 8;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return type;
    }
}
