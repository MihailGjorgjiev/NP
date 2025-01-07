package VtorKolokviumVezbi.PayrollSystem_7;

public abstract class Employee implements Comparable<Employee> {
    private String id;
    private String level;
    private double rate;
    private String bonus;

    public Employee(String id, String level, double rate,String bonus) {
        this.id = id;
        this.level = level;
        this.rate = rate;
        this.bonus=bonus;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public double bonusAmount() {
        String bonus = getBonus();
        if (bonus == null) return 0;
        if (bonus.contains("%")) return salary() * (Double.parseDouble(bonus.substring(0, bonus.length() - 1)) / 100);
        if (!bonus.contains("%")) return Double.parseDouble(bonus);
        return 0;
    }

    public abstract double salary();
public double salaryWithBonusAmount(){
    return salary()+bonusAmount();
}
    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f", id, level, salaryWithBonusAmount());
    }

    @Override
    public int compareTo(Employee o) {
        int cmp = Double.compare(o.salary(), salary());
        if (cmp != 0) return cmp;
        return o.level.compareTo(level);
    }

}
