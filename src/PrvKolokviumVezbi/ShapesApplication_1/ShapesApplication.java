package PrvKolokviumVezbi.ShapesApplication_1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShapesApplication {
    private HashMap<String, List<Integer>> canvases;
    public ShapesApplication(){
        canvases=new HashMap<>();
    }
    public int readCanvases(InputStream inputStream) throws IOException {
        String line;
        int totalSquares=0;
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))){
            while (!Objects.equals(line = reader.readLine(), null)){
                String[] parts=line.split("\\s+");
                String id=parts[0];
                List<Integer> squares=Arrays.stream(Arrays.copyOfRange(parts,1,parts.length)).map(Integer::parseInt).collect(Collectors.toList());
                totalSquares+=squares.size();
                canvases.put(id,squares);
            }
        }

        return totalSquares;
    }
    public void printLargestCanvasTo(OutputStream outputStream) throws IOException {
        try (BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream))){
            int biggestPerimetar=0;
            int totalSquares=0;
            String id="";
            for(String sqId: canvases.keySet()){
                int sum=canvases.get(sqId).stream().mapToInt(Integer::valueOf).sum();
                if (biggestPerimetar< sum*4){
                    biggestPerimetar=sum*4;
                    totalSquares=canvases.get(sqId).size();
                    id=sqId;
                }
            }
            String output=String.format("%s %d %d",id,totalSquares,biggestPerimetar);
            writer.write(output);
            writer.newLine();

        }
    }
}
