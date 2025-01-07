package VtorKolokviumVezbi.PayrollSystem_7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PayrollSystem {
    private Map<String, Employee> employees;
    private Map<String, List<Employee>> employeesByLevel;
    private Map<String, Double> hourlyRateByLevel;
    private Map<String, Double> ticketRateByLevel;

    private Map<String,HourlyEmployee> hourlyEmployeeMap;
    private Map<String,FreelanceEmployee> freelanceEmployeeMap;

    public PayrollSystem() {
        this.employees = new TreeMap<>();
        this.employeesByLevel = new HashMap<>();
        this.hourlyRateByLevel = new HashMap<>();
        this.ticketRateByLevel = new HashMap<>();

        this.hourlyEmployeeMap=new HashMap<>();
        this.freelanceEmployeeMap=new HashMap<>();
    }

    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this();
        this.hourlyRateByLevel=hourlyRateByLevel;
        this.ticketRateByLevel=ticketRateByLevel;
    }

    private static boolean isValidBonus(String bonus) {
        if (bonus == null) return true;
        if (bonus.contains("%")) {
            if (Double.parseDouble(bonus.substring(0, bonus.length() - 1)) > 20) {
                return false;
            }
        }
        if (!bonus.contains("%")) {
            if (Double.parseDouble(bonus) > 1000) {
                return false;
            }
        }
        return true;
    }

    public Employee createEmployee(String line) throws BonusNotAllowedException {
        String[] split = line.trim().split("\\s+");
        String bonus = split.length == 2 ? split[1].trim() : null;
        if (!isValidBonus(bonus)) {
            throw new BonusNotAllowedException("BonusNotAllowedException");
        }
        String[] parts = split[0].trim().split(";");
        String id = parts[1];
        String level = parts[2];
        Employee employee;
        if (parts[0].equals("H")) {
            double hours = Double.parseDouble(parts[3]);
            employee = new HourlyEmployee(id, level, hourlyRateByLevel.get(level), bonus, hours);
            hourlyEmployeeMap.put(id, (HourlyEmployee) employee);

        } else {
            ArrayList<Integer> tickets = new ArrayList<>();
            for (int i = 3; i < parts.length; i++) {
                tickets.add(Integer.parseInt(parts[i]));
            }
            employee = new FreelanceEmployee(id, level, ticketRateByLevel.get(level), bonus, tickets);
            freelanceEmployeeMap.put(id, (FreelanceEmployee) employee);
        }

        employees.put(id, employee);

        employeesByLevel.putIfAbsent(level, new ArrayList<>());
        employeesByLevel.get(level).add(employee);

        return employee;
    }

    public Map<String, Set<Employee>> printEmployeesByLevels(OutputStream os, Set<String> levels) {
        PrintWriter writer = new PrintWriter(os);

        return employeesByLevel.entrySet().stream()
                .filter(entry -> levels.contains(entry.getKey()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.groupingBy(
                        Employee::getLevel,
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));
    }

    public Map<String, Double> getOvertimeSalaryForLevels() {

        return hourlyEmployeeMap.values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getLevel,
                        Collectors.summingDouble(HourlyEmployee::overtimeSalary)
                ));

    }

    public void printStatisticsForOvertimeSalary() {
        DoubleSummaryStatistics doubleSummaryStatistics =
                hourlyEmployeeMap.values().stream()
                        .mapToDouble(HourlyEmployee::overtimeSalary)
                        .summaryStatistics();
    }

    public Map<String, Integer> ticketsDoneByLevel() {
        return freelanceEmployeeMap.values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getLevel,
                        Collectors.summingInt(employee -> employee.getTickets().size())
                ));

    }

    public Collection<Employee> getFirstNEmployeesByBonus (int n){
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::bonusAmount,Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }

}
