package VtorKolokviumVezbi.Car_14;

import java.util.*;
import java.util.stream.Collectors;

public class CarCollection {
    private Collection<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            cars = cars.stream().sorted(Comparator.comparing(Car::getPrice).thenComparing(Car::getPower)).collect(Collectors.toCollection(ArrayList::new));
        } else {
            cars = cars.stream().sorted(Comparator.comparing(Car::getPrice, Comparator.reverseOrder()).thenComparing(Car::getPower,Comparator.reverseOrder())).collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public List<Car> filterByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public List<Car> getList(){
        return new ArrayList<>(cars);
    }
}
