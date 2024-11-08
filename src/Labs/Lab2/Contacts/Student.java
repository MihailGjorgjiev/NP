package Labs.Lab2.Contacts;

import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private int age;
    private long index;
    private Contact[] contacts;

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;

        this.contacts = new Contact[0];
    }

    public void addEmailContact(String date, String email) {
        Contact emailContact = new EmailContact(date, email);

        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = emailContact;
    }

    public void addPhoneContact(String date, String phone) {
        Contact phoneContact = new PhoneContact(date, phone);

        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = phoneContact;
    }

    public Contact[] getEmailContacts() {
        return Arrays.stream(contacts).filter(c -> c.getType().equals("Email")).toArray(Contact[]::new);
    }

    public Contact[] getPhoneContacts() {
        return Arrays.stream(contacts).filter(c -> c.getType().equals("Phone")).toArray(Contact[]::new);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getCity() {
        return city;
    }

    public long getIndex() {
        return index;
    }

    public Contact getLatestContact() {
        Contact latestContact = contacts[0];

        for (Contact contact : contacts) {
            if (contact.isNewerThan(latestContact)) {
                latestContact = contact;
            }
        }
        return latestContact;
    }

    @Override
    public String toString() {
        StringBuilder emailBuilder=new StringBuilder();
        emailBuilder.append("[");
        for(Contact contact:getEmailContacts()){
            emailBuilder.append("\"").append(((EmailContact) contact).getEmail()).append("\", ");
        }
        if(emailBuilder.length()>1){
            emailBuilder.deleteCharAt(emailBuilder.length()-1).deleteCharAt(emailBuilder.length()-1);
        }
        emailBuilder.append("]");


        StringBuilder phoneBuilder=new StringBuilder();
        phoneBuilder.append("[");
        for(Contact contact:getPhoneContacts()){
            phoneBuilder.append("\"").append(((PhoneContact) contact).getPhone()).append("\", ");
        }
        if(phoneBuilder.length()>1){
            phoneBuilder.deleteCharAt(phoneBuilder.length()-1).deleteCharAt(phoneBuilder.length()-1);
        }
        phoneBuilder.append("]");


        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(String.format("\"ime\":\"%s\", ",firstName));
        sb.append(String.format("\"prezime\":\"%s\", ",lastName));
        sb.append(String.format("\"vozrast\":%d, ",age));
        sb.append(String.format("\"grad\":\"%s\", ",city));
        sb.append(String.format("\"indeks\":%s, ",index));


        sb.append(String.format("\"telefonskiKontakti\":%s, ",phoneBuilder.toString()));
        sb.append(String.format("\"emailKontakti\":%s",emailBuilder.toString()));
        sb.append("}");

        return sb.toString();
    }
}
