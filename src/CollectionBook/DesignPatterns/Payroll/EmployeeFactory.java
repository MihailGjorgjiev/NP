package CollectionBook.DesignPatterns.Payroll;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFactory {
    public static Employee createEmployee(String line,
                                          Map<String, Double> hourlyRate,
                                          Map<String, Double> ticketRate) throws BonusNotAllowedException {
        String[] parts = line.split("\\s+");

        Employee e =createSimpleEmployee(parts[0],hourlyRate,ticketRate);

        if(parts.length>1){
            if(parts[1].contains("%")){
                double percentage=Double.parseDouble(parts[1].substring(0, parts[1].length()-1));
                if(percentage>20){
                    throw new BonusNotAllowedException(parts[1]);
                }
                e=new PercentageBonusDecorator(e,percentage);
            }else {
                double bonusAmount=Double.parseDouble(parts[1]);
                if(bonusAmount>1000){
                    throw new BonusNotAllowedException(parts[1]+"$");
                }
                e=new FixedBonusDecorator(e,bonusAmount);
            }
        }
        return e;
    }

    private static Employee createSimpleEmployee(String subLine,
                                                 Map<String, Double> hourlyRate,
                                                 Map<String, Double> ticketRate) {
        String[] parts = subLine.split(";");
        String id=parts[1];
        String level=parts[2];
        if(parts[0].equals("H")){
            double hours=Double.parseDouble(parts[3]);
            return new HourlyEmployee(id,level,hourlyRate.get(level),hours);
        }else {
            List<Integer> ticketPoints= Arrays.stream(parts)
                    .skip(3)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new FreelanceEmployee(id,level, ticketRate.get(level),ticketPoints);
        }
    }
}
