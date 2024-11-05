package PrvKolokviumVezbi.Logger_4;

import java.util.ArrayList;

public interface LogProcessor<T extends ILog & Comparable<T>> {
    ArrayList<T> processLogs(ArrayList<T> logs);
}
