package VtorKolokviumVezbi.PayrollSystem_6;

public abstract class Employee implements Comparable<Employee>{
    private String id;
    private String level;

    public Employee(String id, String level) {
        this.id = id;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }
    public abstract double getPayment();

    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f",id,level,getPayment());
    }
}
