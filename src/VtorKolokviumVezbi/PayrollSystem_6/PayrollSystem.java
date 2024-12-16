package VtorKolokviumVezbi.PayrollSystem_6;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class PayrollSystem {
    private Map<String, Set<Employee>> employees;
    private Map<String, Double> hourlyRateByLevel;
    private Map<String, Double> ticketRateByLevel;

    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.hourlyRateByLevel = hourlyRateByLevel;
        this.ticketRateByLevel = ticketRateByLevel;
        this.employees = new TreeMap<>();
    }

    public void readEmployees(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        reader.lines()
                .forEach(line -> {
                    String[] employeeData = line.trim().split(";");
                    String id = employeeData[1];
                    String level = employeeData[2];
                    employees.putIfAbsent(level, new TreeSet<>(Comparator.reverseOrder()));
                    if (employeeData[0].equals("H")) {
                        double hours = Double.parseDouble(employeeData[3]);
                        employees.get(level).add(new HourlyEmployee(id, level, hours, hourlyRateByLevel.get(level)));
                    } else {
                        int[] tickets = IntStream.range(3, employeeData.length)
                                .map(i -> Integer.parseInt(employeeData[i]))
                                .toArray();
                        employees.get(level).add(new FreelanceEmployee(id, level, tickets, ticketRateByLevel.get(level)));
                    }
                });
    }

    public Map<String, Set<Employee>> printEmployeesByLevels(OutputStream os, Set<String> levels) {
        Map<String, Set<Employee>> filteredEmployeed = new TreeMap<>();
        levels.stream()
                .forEach(level -> {
                    if (employees.containsKey(level)) {
                        filteredEmployeed.put(level, employees.get(level));
                    }
                });
        return filteredEmployeed;
    }
}
