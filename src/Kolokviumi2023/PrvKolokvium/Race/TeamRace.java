package Kolokviumi2023.PrvKolokvium.Race;

import java.io.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamRace {
    public static void findBestTeam(InputStream in, PrintStream out) throws IOException {
        List<Integer> ids=new ArrayList<>();
        List<LocalTime> startTimes=new ArrayList<>();
        List<LocalTime> endTimes=new ArrayList<>();
        List<Long> betweenTimes=new ArrayList<>();

        List<Integer> fastestFourRunners=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(in))){
            String line;
            while ((line=reader.readLine())!= null){
                String[] parts=line.split("\\s+");

                int id=Integer.parseInt(parts[0]);
                LocalTime startTime=LocalTime.parse(parts[1]);
                LocalTime endTime=LocalTime.parse(parts[2]);

                ids.add(id);
                startTimes.add(startTime);
                endTimes.add(endTime);
                betweenTimes.add(startTime.until(endTime, ChronoUnit.SECONDS));
            }

        }
        List<Long> clonedBetweenTimes = new ArrayList<>(betweenTimes);

        Collections.sort(clonedBetweenTimes);


        for(int i=0;i<4;i++){
            fastestFourRunners.add(betweenTimes.indexOf(clonedBetweenTimes.get(i)));
        }


        try (BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out))){
            long totalTime=0L;
            for(Integer inx:  fastestFourRunners){
                String line=String.format("%d %s",ids.get(inx),LocalTime.ofSecondOfDay(betweenTimes.get(inx)));
                writer.write(line);
                writer.newLine();
                totalTime+= betweenTimes.get(inx);
            }
            writer.write(String.valueOf(LocalTime.ofSecondOfDay(totalTime)));

        }
    }
}
