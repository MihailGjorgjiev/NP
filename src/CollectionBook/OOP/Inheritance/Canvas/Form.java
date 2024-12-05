package CollectionBook.OOP.Inheritance.Canvas;

import PrvKolokviumVezbi.Shapes_6.Scalable;
import PrvKolokviumVezbi.Shapes_6.Stackable;

public abstract class Form implements Scalable, Stackable {
    private String id;
    private Color color;

    public Form(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
