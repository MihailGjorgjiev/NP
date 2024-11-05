package PrvKolokviumVezbi.F1_21;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class F1Race {
    List<String> racers;
    List<String> firstLap;
    List<String> secondLap;
    List<String> thirdLap;

    public F1Race() {
        racers = new ArrayList<>();
        firstLap = new ArrayList<>();
        secondLap = new ArrayList<>();
        thirdLap = new ArrayList<>();
    }

    public void readResults(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                racers.add(parts[0]);
                firstLap.add(parts[1]);
                secondLap.add(parts[2]);
                thirdLap.add(parts[3]);
            }
        }
    }

    public void printSorted(OutputStream outputStream) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            List<String> bestTime = new ArrayList<>();
            for (int i = 0; i < racers.size(); i++) {
                String time = firstLap.get(i);
                if (time.compareTo(secondLap.get(i))>0) {
                    time = secondLap.get(i);
                }
                if (time.compareTo(thirdLap.get(i))>0) {
                    time = thirdLap.get(i);
                }
                bestTime.add(time);
            }
            List<Integer> indicesOfSortedPlayers= IntStream.range(0, racers.size()).boxed().collect(Collectors.toList());
            indicesOfSortedPlayers.sort(Comparator.comparing(bestTime::get));

            for(Integer inx:indicesOfSortedPlayers){
                writer.write(String.format("%d. %-10s%10s\n",indicesOfSortedPlayers.indexOf(inx)+1,racers.get(inx),bestTime.get(inx)));
            }
        }
    }


}
