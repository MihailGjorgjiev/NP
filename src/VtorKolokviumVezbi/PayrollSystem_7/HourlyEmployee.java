package VtorKolokviumVezbi.PayrollSystem_7;

public class HourlyEmployee extends Employee {
    private double totalHours;

    public HourlyEmployee(String id, String level, double rate,String bonus, double totalHours) {
        super(id, level, rate,bonus);
        this.totalHours = totalHours;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double overtimeHours() {
        return totalHours > 40 ? totalHours - 40 : 0;
    }

    public double regularHours() {
        return totalHours > 40 ? 40 : totalHours;
    }

    @Override
    public double salary() {
        return getRate() * regularHours()+overtimeSalary();
    }

    public double overtimeSalary() {
        return 1.5*getRate()*overtimeHours();
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        return baseString + String.format(" Regular hours: %.2f Overtime hours: %.2f Bonus: %.2f",regularHours(),overtimeHours(),bonusAmount());
    }
}
