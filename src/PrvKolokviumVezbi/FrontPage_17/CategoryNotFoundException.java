package PrvKolokviumVezbi.FrontPage_17;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(String.format("Category %s was not found",message));
    }
}
