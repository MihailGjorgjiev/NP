package VtorKolokviumVezbi.DeliveryApp_36;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DeliveryApp {
    private String name;
    private Map<String, Worker> workers;
    private Map<String, Restaurant> restaurants;
    private Map<String, User> users;

    public DeliveryApp() {
        this.workers = new HashMap<>();
        this.restaurants = new HashMap<>();
        this.users = new HashMap<>();
    }

    public DeliveryApp(String name) {
        this();
        this.name = name;
    }

    public void registerDeliveryPerson(String id, String name, Location currentLocation) {
        Worker worker = new Worker(id, name, currentLocation);
        workers.putIfAbsent(worker.getId(), worker);
    }

    public void addRestaurant(String id, String name, Location location) {
        Restaurant restaurant = new Restaurant(id, name, location);
        restaurants.put(restaurant.getId(), restaurant);
    }
    public void addUser(String id,String name){
        User user=new User(id,name);
        users.put(user.getId(), user);
    }
    public void addAddress (String id, String addressName, Location location){
        Address address=new Address(addressName,location);
        users.get(id).addAddress(address);
    }
    public void orderFood(String userId, String userAddressName, String restaurantId, float cost){
        User user=users.get(userId);
        Address address=user.getAddress(userAddressName);
        Restaurant restaurant=restaurants.get(restaurantId);

//        workers.values().stream()
//                .sorted(Comparator.comparing((Worker worker) -> worker.getLocation().distance(address.getLocation()))
//                        .thenComparing(worker -> {
//
//                        }))

    }



}
