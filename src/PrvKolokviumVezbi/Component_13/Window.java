package PrvKolokviumVezbi.Component_13;

import java.util.ArrayList;
import java.util.List;

public class Window {
    private String name;
    private List<Component> componentList;

    public Window(String name) {
        this.name = name;
        componentList=new ArrayList<>();
    }
    public void addComponent(int position, Component component) throws InvalidPositionException {
        if(position>componentList.size()){
            throw new InvalidPositionException(String.format("Invalid position %d, alredy taken!",position));
        }
        componentList.add(position, component);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(name).append("\n");
        for(Component component:componentList){
            sb.append(component).append("\n");
        }
        return sb.toString();
    }

    public void changeColor(int weight, String color){
        for(Component component: componentList){
            if(component.getWeight()<weight){
                component.setColor(color);
            }
        }
    }

    public void swichComponents(int pos1, int pos2){
        Component temp=componentList.get(pos1);
        componentList.add(pos1,componentList.get(pos2));
        componentList.add(pos2,temp);
    }
}
