package Labs.Lab7.XML;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class XMLLeaf implements XMLComponent{
    private Map<String,String> attributes;

    private String tagName;
    private String innerText;

    public XMLLeaf(String tagName,String innerText) {
        this.tagName=tagName;
        this.innerText=innerText;

        this.attributes=new LinkedHashMap<>();
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key,value);
    }


    public String toString(int depth) {
        String totalDepth="\t".repeat(depth);
        StringBuilder sb=new StringBuilder();

        String attrs=attributes.entrySet().stream()
                        .map(entry->String.format("%s=\"%s\"",entry.getKey(),entry.getValue()))
                                .collect(Collectors.joining(" "));

        sb.append(totalDepth).append(String.format("<%s%s>",tagName,attrs.isEmpty()?attrs:" "+attrs));


        sb.append(innerText).append(String.format("</%s>",tagName));

        return sb.toString();
    }
}
