package VtorKolokviumVezbi.DeliveryApp_36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String id;
    private String name;
    private Map<String,Address> addresses;

    public User(){
        this.addresses=new HashMap<>();
    }
    public User(String id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name;
    }

    public void addAddress(Address address){
        addresses.put(address.getName(), address);
    }

    public Map<String,Address> getAddresses() {
        return addresses;
    }

    public Address getAddress(String addressName){
        return addresses.get(addressName);
    }
}
