package VtorKolokviumVezbi.BlockContainer_16;

import java.util.*;
import java.util.stream.Collectors;

public class BlockContainer<T extends Comparable<T>>  {
    private List<Set<T>> blocks;
    private int n;
    private int totalBlocks;

    public BlockContainer(int n) {
        this.n = n;

        this.totalBlocks = 0;
        blocks = new ArrayList<>();
    }

    private void addBlock() {
//        blocks.putIfAbsent(totalBlocks, new TreeSet<>());
        blocks.add(new TreeSet<>());
    }

    public void add(T a) {
        if(blocks.isEmpty()){
            addBlock();
        }
        if (blocks.get(totalBlocks).size() == n) {
            totalBlocks++;
            addBlock();
        }
        blocks.get(totalBlocks).add(a);

    }

    public void remove(T a) {
        blocks.get(totalBlocks).remove(a);
        if (blocks.get(totalBlocks).size() == 0) {
                blocks.remove(blocks.size()-1);
                totalBlocks--;
        }
    }
    public void sort(){
        List<T> collected = blocks.stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());

        blocks.clear();
        totalBlocks=0;
        collected.stream().forEach(this::add);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (Set<T> block:blocks){
            sb.append(block).append(",");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

}
