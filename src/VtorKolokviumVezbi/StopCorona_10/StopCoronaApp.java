package VtorKolokviumVezbi.StopCorona_10;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StopCoronaApp {
    private Map<String, User> users;

    public StopCoronaApp() {
        this.users = new HashMap<>();
    }

    public void addUser(String name, String id) throws UserAlreadyExistException {
        if (users.containsKey(id)) {
            throw new UserAlreadyExistException("UserAlreadyExistException");
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
        return users.values().stream()
                .filter(user -> !user.getId().equals(u.getId()))
                .map(user -> Map.entry(user, user.totalDirectContacts(u)))
                .filter(userIntegerEntry -> userIntegerEntry.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public Collection<User> getIndirectContacts(User u) {
        Set<User> directContacts = getDirectContacts(u).keySet();
        return directContacts.stream()
                .map(user -> getDirectContacts(user).keySet())
                .flatMap(Collection::stream)
                .filter(user -> !directContacts.contains(user))
                .filter(user -> !user.getId().equals(u.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }


    public void createReport() {
        int sumDirect = 0;
        int sumIndirect = 0;

        users.values().stream()
                .filter(User::isInfected)
                .forEach(user -> {
                    System.out.println(user);
                    System.out.println("Direct contacts:");
                    getDirectContacts(user).entrySet().stream()
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

        System.out.println(String.format("Average direct contacts: %.4f",(double)directSum/ users.size()));
        System.out.println(String.format("Average indirect contacts: %.4f",(double)indirectSum/ users.size()));

    }
}
