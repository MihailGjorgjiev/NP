package Labs.Lab6.ChatSystem;

import java.util.Set;
import java.util.TreeSet;

public class ChatRoom {
    private String name;
    private Set<String> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new TreeSet<>();
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    @Override
    public String toString() {
        String newLine = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(newLine);
        if (users.isEmpty()) {
            sb.append("EMPTY").append(newLine);
            return sb.toString();
        }
        users.stream().forEach(user -> sb.append(user).append(newLine));
        return sb.toString();
    }

    public boolean hasUser(String username) {
        return users.contains(username);
    }
    public int numUsers(){
        return users.size();
    }

    public String getName() {
        return name;
    }
}
