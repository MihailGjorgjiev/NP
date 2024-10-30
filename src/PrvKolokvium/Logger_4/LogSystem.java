package PrvKolokvium.Logger_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LogSystem<T extends ILog & Comparable<T>> {
    //TODO add instance variable(s)
    private ArrayList<T> logsList;
    //TODO constructor
    public LogSystem(ArrayList<T> logs){
        this.logsList=logs;
    }
    void printResults() {

        //TODO define concrete log processors with lambda expressions
        LogProcessor<T> firstLogProcessor = x->x.stream().filter(log->log.getType().equals("INFO")).collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> secondLogProcessor = x -> x.stream().filter(log->log.getMessage().length()<100).collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> thirdLogProcessor = x-> x.stream().sorted().collect(Collectors.toCollection(ArrayList::new));

        System.out.println("RESULTS FROM THE FIRST LOG PROCESSOR");
        firstLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE SECOND LOG PROCESSOR");
        secondLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE THIRD LOG PROCESSOR");
        thirdLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));
    }
}
