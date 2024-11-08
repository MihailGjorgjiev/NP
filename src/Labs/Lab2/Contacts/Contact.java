package Labs.Lab2.Contacts;

public abstract class Contact {
    private String date;
    public Contact(String date) {
        this.date=date;
    }
    public boolean isNewerThan(Contact c){
        return this.date.compareTo(c.date)>0;
    }
    public abstract String getType();
}
