package AV.FirstMidTermPractice.StackedCanvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Canvas {

    private List<CanvasForm> forms;

    public Canvas() {
        forms = new ArrayList<>();
    }

    public void add(String id, String color, float radius) {
        CircleForm circle = new CircleForm(id, color, radius);
        int i;
        for (i = 0; i < forms.size(); i++) {
            if(forms.get(i).weight()< circle.weight()){
                break;
            }
        }
        forms.add(i,circle);
    }

    public void add(String id, String color, float width, float height) {
        RectangleForm rectangle = new RectangleForm(id, color, width, height);
        int i;
        for (i = 0; i < forms.size(); i++) {
            if(forms.get(i).weight()< rectangle.weight()){
                break;
            }
        }
        forms.add(i,rectangle);
    }

    public void scale(String id,float scaleFactor){
        forms.stream().filter(f->f.getId().equals(id)).forEach(f->f.scale(scaleFactor));
        forms.sort((o1, o2) -> (int) (o1.weight() - o2.weight()));
    }

}
