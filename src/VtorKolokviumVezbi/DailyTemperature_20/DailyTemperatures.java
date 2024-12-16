package VtorKolokviumVezbi.DailyTemperature_20;

import java.io.*;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;

public class DailyTemperatures {

    private Map<Integer, DailyMeasurements> dailyMeasurementsMap;
    public DailyTemperatures() {
        dailyMeasurementsMap=new TreeMap<>();
    }

    public void readTemperatures(InputStream inputStream){
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

        reader.lines()
                .forEach(line->{
                    String[] split = line.trim().split("\\s+");
                    int day=Integer.parseInt(split[0]);
                    dailyMeasurementsMap.put(day,new DailyMeasurements(Arrays.copyOfRange(split,1,split.length)));
                });
    }
    public void writeDailyStats(OutputStream outputStream, char scale){
        PrintWriter writer=new PrintWriter(outputStream);
        dailyMeasurementsMap.entrySet().stream()
                .forEach(entry->{

                    DoubleSummaryStatistics doubleSummaryStatistics;
                    if(scale == 'C'){
                        doubleSummaryStatistics = entry.getValue().toCelsius().stream().mapToDouble(i -> i).summaryStatistics();
                    }else {
                        doubleSummaryStatistics = entry.getValue().toFahrenheit().stream().mapToDouble(i -> i).summaryStatistics();
                    }
                    int day=entry.getKey();
                    int count= (int) doubleSummaryStatistics.getCount();
                    double min=doubleSummaryStatistics.getMin();
                    double max=doubleSummaryStatistics.getMax();
                    double avg=doubleSummaryStatistics.getAverage();

                    String output=String.format("%3d: Count: %3d Min: %6.2f%c Max: %6.2f%c Avg: %6.2f%c",day,count,min,scale,max,scale,avg,scale);
                    writer.println(output);
                });
        writer.flush();
    }


}
