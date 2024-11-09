package PrvKolokviumVezbi.Component_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Window {
    private String name;
    private HashMap<Integer, Component> componentHashMap;

    public Window(String name) {
        this.name = name;
        this.componentHashMap = new HashMap<>();
    }

    void addComponent(int position, Component component) throws InvalidPositionException {
        if (componentHashMap.containsKey(position)) {
            throw new InvalidPositionException(String.format("Invalid position %d, alredy taken!", position));
        }
        componentHashMap.put(position, component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WINDOW "+name).append("\n");
        for (Integer k : componentHashMap.keySet().stream().mapToInt(Integer::intValue).sorted().toArray()) {
            sb.append(String.format("%d:",k)).append(componentHashMap.get(k).depthToString(0)).append("\n");
        }
        return sb.toString();
    }

    private static void componentChangeColor(Component component, int weight, String color) {
        if (component.getWeight() < weight) {
            component.setColor(color);
        }
        for (Component c : component.getComponentList()) {
            componentChangeColor(c, weight, color);
        }
    }

    public void changeColor(int weight, String color) {
        for (Integer k : componentHashMap.keySet()) {
            componentChangeColor(componentHashMap.get(k), weight, color);
        }
    }

    public void swichComponents(int pos1, int pos2) {
        Component comp1 = componentHashMap.get(pos1);
        Component comp2 = componentHashMap.get(pos2);

        componentHashMap.put(pos1, comp2);
        componentHashMap.put(pos2, comp1);
    }
}