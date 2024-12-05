package CollectionBook.Exceptions.Custom.Pizzeria;

import java.util.List;
import java.util.Objects;

public class ExtraItem implements Item {
    private String type;


    public ExtraItem(String type) throws InvalidExtraTypeException {
        if (!isValidChoice(type)) {
            throw new InvalidExtraTypeException(String.format("%s is not a valid Extra Item", type));
        }
        this.type = type;
    }

    private static boolean isValidChoice(String type) {
        List<String> validChoices = List.of(new String[]{"Ketchup", "Coke"});

        return validChoices.contains(type);
    }

    @Override
    public int getPrice() {
        switch (type) {
            case "Ketchup":
                return 3;
            case "Coke":
                return 5;
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
        ExtraItem extraItem = (ExtraItem) o;
        return Objects.equals(type, extraItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }
}
