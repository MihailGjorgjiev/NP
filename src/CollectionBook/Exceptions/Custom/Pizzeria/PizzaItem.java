package CollectionBook.Exceptions.Custom.Pizzeria;

import java.util.List;
import java.util.Objects;

public class PizzaItem implements Item {
    private String type;


    public PizzaItem(String type) throws InvalidPizzaTypeException {
        if (!isValidChoice(type)) {
            throw new InvalidPizzaTypeException(String.format("%s is not a valid Pizza Item", type));
        }
        this.type = type;
    }

    private static boolean isValidChoice(String type) {
        List<String> validChoices = List.of(new String[]{"Standard", "Pepperoni", "Vegetarian"});

        return validChoices.contains(type);
    }

    @Override
    public int getPrice() {
        switch (type) {
            case "Standard":
                return 10;
            case "Pepperoni":
                return 12;
            case "Vegetarian":
                return 8;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaItem pizzaItem = (PizzaItem) o;
        return Objects.equals(type, pizzaItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }
}
