package AV.FirstMidTermPractice.StackedCanvas;

import PrvKolokviumVezbi.Shapes_6.Scalable;
import PrvKolokviumVezbi.Shapes_6.Stackable;

public abstract class CanvasForm implements Scalable, Stackable {
    private String id;
    private String color;

    public CanvasForm(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%-5s %10s",id,color);
    }
}
