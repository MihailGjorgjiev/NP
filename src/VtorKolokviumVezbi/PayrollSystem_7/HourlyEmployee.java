package VtorKolokviumVezbi.PayrollSystem_7;

public class HourlyEmployee extends Employee {
    private double hours;
    private double payment;
    public HourlyEmployee(String id,String level,double hours,double hourlyRate) {
        super(id,level);
        this.hours = hours;
        setPayment(hourlyRate);
    }

    private void setPayment(double hourlyRate){
        double tempHours=hours;
        double total=0;

        if(tempHours>=40){
            total+=hourlyRate*40*(int)(tempHours/40);
            tempHours=tempHours%40;
        }
        total+=hours>40?hourlyRate*tempHours*1.5:hourlyRate*tempHours;

        payment=total;
    }
    public double getHours() {
        return hours;
    }


    @Override
    public double getPayment() {
        return payment;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(getPayment(),o.getPayment());
    }

    @Override
    public String toString() {
        String result=super.toString();
        double worktime=hours>40?40:hours;
        double overtime=hours>40?hours%40:0;
        result+=String.format(" Regular hours: %.2f Overtime hours: %.2f",worktime,overtime);

        return result;
    }
}
