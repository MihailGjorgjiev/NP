package Labs.Lab3.PizzaOrder;

public class ExtraItem implements Item{
    private static final String[] VALID_TYPES={ "Coke", "Ketchup" };
    private String type;

    public ExtraItem(String type) throws InvalidExtraTypeException {
        boolean isValidType=false;
        for(String validType:VALID_TYPES){
            if(validType.equals(type)){
                isValidType=true;
                break;
            }
        }
        if(!isValidType){
            throw new InvalidExtraTypeException("InvalidExtraTypeException");
        }
        this.type = type;
    }

    @Override
    public int getPrice() {
        if(type.equals("Ketchup")){
            return 3;
        } else if (type.equals("Coke")) {
            return 5;
        }
        return 0;
    }

    @Override
    public String toString() {
        return type;
    }
}
