package CollectionBook.OOP.Inheritance.Canvas;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    List<Form> forms;

    public Canvas() {
        forms=new ArrayList<>();
    }

    public void add(String id, Color color, float radius){
        CircleForm circle=new CircleForm(id,color,radius);
        int i;
        for(i=0;i<forms.size();i++){
            if(forms.get(i).weight()< circle.weight()){
                break;
            }
        }

        forms.add(i,circle);
    }

    public void add(String id, Color color, float width, float height){
        RectangleForm rectangle=new RectangleForm(id,color,width,height);
        int i;
        for(i=0;i<forms.size();i++){
            if(forms.get(i).weight()< rectangle.weight()){
                break;
            }
        }
        forms.add(i,rectangle);
    }

    public void scale(String id, float scaleFactor){
        int i;
        for(i=0;i<forms.size();i++){
            if(forms.get(i).getId().equals(id)){
                break;
            }
        }
    }
}
