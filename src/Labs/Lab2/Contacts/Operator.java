package Labs.Lab2.Contacts;

public class Operator {
    private String name;

    public Operator(String phone) {
        int digit=Integer.parseInt(String.valueOf(phone.charAt(2)));

        switch (digit){
            case 0:
            case 1:
            case 2:
                this.name="TMOBILE";
                break;
            case 5:
            case 6:
                this.name="ONE";
                break;
            case 7:
            case 8:
                this.name="VIP";
                break;
            default:
                this.name="NONE";
                break;
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
