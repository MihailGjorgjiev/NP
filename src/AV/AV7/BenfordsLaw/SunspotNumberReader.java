package AV.AV7.BenfordsLaw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SunspotNumberReader implements NumbersReader{
    @Override
    public List<Integer> read(InputStream inputStream) {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))){
            return reader.lines()
                    .filter(line->!line.isEmpty())
                    .map(line->{
                        String[] parts=line.split("\\s+");
                        return Integer.parseInt(parts[parts.length-1]);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}
