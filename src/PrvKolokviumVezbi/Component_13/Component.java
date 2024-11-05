package PrvKolokviumVezbi.Component_13;

import java.util.*;

public class Component {
    private String color;
    private int weight;
    private List<Component> componentList;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        this.componentList=new ArrayList<>();
    }

    public void addComponent(Component component){
        componentList.add(component);
        componentList.sort((o1, o2) -> {
            int weightDiff=o1.weight-o2.weight;
            if(weightDiff<0) return -1;
            if(weightDiff>0) return 1;
            return o1.color.compareTo(o2.color);
        });
    }

    @Override
    public String toString() {
        return String.format("%d:%s",weight,color);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
