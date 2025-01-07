package VtorKolokviumVezbi.StopCorona_10;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StopCoronaApp {
    private Map<String, User> users;

    public StopCoronaApp() {
        this.users = new TreeMap<>();
    }

    public void addUser(String name, String id) throws UserAlreadyExistException {
        if (users.containsKey(id)) {
            throw new UserAlreadyExistException(String.format("User with id %s already exists",id));
        }
        users.put(id, new User(id, name));
    }

    public void addLocations(String id, List<ILocation> iLocations) {
        users.get(id).addLocations(iLocations);
    }

    public void detectNewCase(String id, LocalDateTime timestamp) {
        users.get(id).infect(timestamp);
    }

    public Map<User, Integer> getDirectContacts(User u) {
        Map<User, Integer> result = new TreeMap<>(Comparator.comparing(User::getId));

        users.values().stream()
                .filter(user -> !user.equals(u))
                .filter(user -> user.totalDirectContacts(u) != 0)
                .forEach(user -> result.put(user, u.totalDirectContacts(user)));

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
        int sumDirect = 0;
        int sumIndirect = 0;
        int totalInfected= (int) users.values().stream().filter(User::isInfected).count();
        users.values().stream()
                .filter(User::isInfected)
                .sorted(Comparator.comparing(User::getTimeInfected))
                .forEach(user -> {
                    System.out.println(user);
                    System.out.println("Direct contacts:");
                    getDirectContacts(user).entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(entry -> {
                                String contactName = entry.getKey().getName();
                                String contactId = entry.getKey().getId().substring(0, 4) + "***";
                                int total = entry.getValue();
                                String line = String.format("%s %s %d", contactName, contactId, total);
                                System.out.println(line);
                            });
                    int totalDirect = getDirectContacts(user).values()
                            .stream().mapToInt(i -> i).sum();

                    System.out.println(String.format("Count of direct contacts: %d", totalDirect));
                    System.out.println("Indirect contacts:");
                    getIndirectContacts(user).stream()
                            .forEach(indirect -> {
                                String contactName = indirect.getName();
                                String contactId = indirect.getId().substring(0, 4) + "***";
                                String line = String.format("%s %s", contactName, contactId);
                                System.out.println(line);
                            });
                    int totalIndirect = getIndirectContacts(user).size();
                    System.out.println("Count of indirect contacts: " + totalIndirect);
                });

        int directSum = users.values().stream()
                .filter(User::isInfected)
                .mapToInt(u -> getDirectContacts(u).values().stream()
                        .mapToInt(i -> i).sum()).sum();

        int indirectSum=users.values().stream()
                .filter(User::isInfected)
                .mapToInt(u -> getIndirectContacts(u).size()).sum();

        System.out.println(String.format("Average direct contacts: %.4f",(double)directSum/ totalInfected));
        System.out.println(String.format("Average indirect contacts: %.4f",(double)indirectSum/ totalInfected));

    }
}
