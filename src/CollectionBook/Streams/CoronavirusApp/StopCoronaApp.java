package CollectionBook.Streams.CoronavirusApp;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StopCoronaApp {
    private Map<String, User> userByIdMap;
    private Map<String, LocalDateTime> infectedUsersById;

    public StopCoronaApp() {
        this.userByIdMap = new HashMap<>();
        this.infectedUsersById = new HashMap<>();
    }

    public void addUser(String name, String id) throws UserAlreadyExistsException {
        if (userByIdMap.containsKey(id)) {
            throw new UserAlreadyExistsException(id);
        }
        userByIdMap.put(id, new User(id, name));
    }

    public void addLocations(String id, List<ILocation> locations) {
        userByIdMap.get(id).addLocations(locations);
    }

    public void detectNewCase(String id, LocalDateTime timestamp) {
        infectedUsersById.put(id, timestamp);
    }

    public Map<User, Integer> getDirectContacts(User u) {
        Map<User, Integer> result = new TreeMap<>(Comparator.comparing(User::getId));

        userByIdMap.values().stream()
                .filter(user -> !user.equals(u))
                .filter(user -> user.countCloseContacts(u) != 0)
                .forEach(user -> result.put(user, u.countCloseContacts(user)));

        return result;

    }

    public Collection<User> getIndirectContacts(User u) {
        Comparator<User> comparator =
                Comparator.comparing(User::getName)
                        .thenComparing(User::getId);

        Map<User, Integer> directContacts = getDirectContacts(u);

        return directContacts.keySet().stream()
                .flatMap(user -> getDirectContacts(user).keySet().stream())
                .filter(user -> !directContacts.containsKey(user) && !user.equals(u))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(comparator)
                ));

    }

    public void createReport() {
        List<Integer> countOfDirectContacts = new ArrayList<>();
        List<Integer> countOfIndirectContacts = new ArrayList<>();

        infectedUsersById.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> printInfectedUserEntry(entry,
                        countOfDirectContacts,
                        countOfIndirectContacts));

        System.out.println(String.format("Average direct contacts: %.4f",
                countOfDirectContacts.stream().mapToInt(i -> i).average().orElse(0.0)));

        System.out.println(String.format("Average indirect contacts: %.4f",
                countOfIndirectContacts.stream().mapToInt(i -> i).average().orElse(0.0)));

    }

    private void printInfectedUserEntry(Map.Entry<String, LocalDateTime> entry,
                                        List<Integer> countOfDirectContacts,
                                        List<Integer> countOfIndirectContacts) {

        User user = userByIdMap.get(entry.getKey());
        System.out.println(String.format("%s %s", user.complete(), entry.getValue()));
        System.out.println("Direct contacts:");

        Map<User, Integer> directContacts = getDirectContacts(user);

        directContacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(
                        String.format("%s %d", e.getKey().hidden(), e.getValue())));

        int countOfDirectContact =
                directContacts.values().stream().mapToInt(i -> i).sum();

        System.out.println(String.format("Count of direct contacts: %d", countOfDirectContact));
        countOfDirectContacts.add(countOfDirectContact);
        System.out.println("Indirect contacts: ");

        Collection<User> indirectContacts = getIndirectContacts(user);

        indirectContacts.forEach(u -> System.out.println(u.hidden()));

        System.out.println(String.format("Count of indirect contacts: %d", indirectContacts.size()));
        countOfIndirectContacts.add(indirectContacts.size());
    }
}
