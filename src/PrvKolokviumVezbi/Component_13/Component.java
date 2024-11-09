package PrvKolokviumVezbi.Component_13;

import java.util.ArrayList;
import java.util.List;

public class Component {
    private String color;
    private int weight;
    List<Component> componentList;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        this.componentList = new ArrayList<>();
    }

    public void addComponent(Component component) {
        if (componentList.size() == 0) {
            componentList.add(component);
            return;
        }
        int i;
        for (i = 0; i < componentList.size(); i++) {
            if(component.weight<componentList.get(i).weight){
                break;
            }
            if(component.weight == componentList.get(i).weight){
                if (component.color.compareTo(componentList.get(i).color)<0){
                    break;
                }
            }
        }
        componentList.add(i,component);

    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public String depthToString(int depth){
        String beginning="---".repeat(depth);
        StringBuilder componentBuilder=new StringBuilder();

        componentBuilder.append(beginning).append(String.format("%d:%s",weight,color));
        for (Component component : componentList) {
            componentBuilder.append("\n").append(component.depthToString(depth+1));

        }
        return componentBuilder.toString();
    }
    @Override
    public String toString() {
        StringBuilder componentBuilder = new StringBuilder();
        componentBuilder.append(String.format("%d:%s",weight,color));
        for (Component component : componentList) {
            componentBuilder.append("\n").append(component.toString());

        }
        return componentBuilder.toString();

    }
}