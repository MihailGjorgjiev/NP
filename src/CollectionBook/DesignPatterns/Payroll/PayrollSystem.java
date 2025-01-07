package CollectionBook.DesignPatterns.Payroll;

import java.util.*;
import java.util.stream.Collectors;

public class PayrollSystem {
    private Map<String, Double> hourlyRate;
    private Map<String, Double> ticketRate;
    private List<Employee> employees;

    public PayrollSystem(Map<String, Double> hourlyRate, Map<String, Double> ticketRate) {
        this.hourlyRate = hourlyRate;
        this.ticketRate = ticketRate;
        this.employees=new ArrayList<>();
    }

    public Employee createEmployee(String line) throws BonusNotAllowedException {
        Employee e=EmployeeFactory.createEmployee(line,hourlyRate,ticketRate);
        employees.add(e);

        return e;
    }

    public Map<String,Double> getOvertimeSalaryForLevels(){
        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getLevel,
                        Collectors.summingDouble(Employee::getOvertime)
                ));

        List<String> keysWithZeroes = result.keySet().stream()
                .filter(key -> result.get(key) == -1)
                .collect(Collectors.toList());

        keysWithZeroes.stream().forEach(result::remove);

        return result;
    }

    public void printStatisticsForOvertimeSalary(){
        DoubleSummaryStatistics dss = employees.stream()
                .filter(e -> e.getOvertime() != -1)
                .mapToDouble(Employee::getOvertime)
                .summaryStatistics();

        System.out.println(String.format("Statistics for overtime salary: Min: %.2f " +
                        "Average: %.2f Max: %.2f Sum: %.2f",
                dss.getMin(), dss.getAverage(), dss.getMax(), dss.getSum()));
    }

    public Map<String,Integer> ticketsDoneByLevel(){
        return employees.stream()
                .filter(e -> e.getTicketsCount() != -1)
                .collect(Collectors.groupingBy(
                        Employee::getLevel,
                        Collectors.summingInt(Employee::getTicketsCount)
                ));
    }

    public Collection<Employee> getFirstNEmployeesByBonus(int n){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getBonus,Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }
}
