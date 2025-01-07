package Labs.Lab7.XML;

import java.util.*;
import java.util.stream.Collectors;

public class XMLComposite implements XMLComponent{
    private String tagName;
    private Map<String,String> attributes;
    private List<XMLComponent> children;


    public XMLComposite(String tagName) {
        this.tagName = tagName;

        this.attributes=new LinkedHashMap<>();
        this.children=new ArrayList<>();
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key,value);
    }

    public void addComponent(XMLComponent component){
        children.add(component);
    }


    public String toString(int depth) {
        String totalDepth="\t".repeat(depth);
        StringBuilder sb=new StringBuilder();

        String attrs=attributes.entrySet().stream()
                .map(entry->String.format("%s=\"%s\"",entry.getKey(),entry.getValue()))
                .collect(Collectors.joining(" "));

        sb.append(totalDepth).append(String.format("<%s %s>",tagName,attrs));
        children.stream().forEach(child->sb.append("\n").append(child.toString(depth+1)));

        sb.append("\n").append(totalDepth).append(String.format("</%s>",tagName));

        return sb.toString();
    }
}
