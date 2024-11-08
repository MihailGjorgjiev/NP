package Labs.Lab2.Contacts;

public class PhoneContact extends Contact {
    private String phone;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getType() {
        return "Phone";
    }


    public Operator getOperator(){
        return new Operator(phone);
    }
}
