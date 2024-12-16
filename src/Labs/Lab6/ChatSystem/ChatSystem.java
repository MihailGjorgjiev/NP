package Labs.Lab6.ChatSystem;

import java.util.*;

public class ChatSystem {
    private Map<String,ChatRoom> rooms;
    private Set<String> registeredUsers;

    public ChatSystem() {
        rooms=new TreeMap<>();
        registeredUsers=new HashSet<>();
    }

    public void addRoom(String roomName){
        rooms.put(roomName,new ChatRoom(roomName));
    }
    public void removeRoom(String roomName){
        rooms.remove(roomName);
    }
    public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        }
        return rooms.get(roomName);
    }

    public void register(String username){
        registeredUsers.add(username);

        Optional<ChatRoom> first = rooms.values().stream().sorted(Comparator.comparing(ChatRoom::numUsers).thenComparing(ChatRoom::getName)).findFirst();
        if(first.isPresent()){
            first.get().addUser(username);
        }
    }
    public void registerAndJoin(String userName, String roomName){
        registeredUsers.add(userName);

        rooms.get(roomName).addUser(userName);
    }
    public void joinRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        }
        if(!registeredUsers.contains(userName)){
            throw new NoSuchUserException(userName);
        }
        rooms.get(roomName).addUser(userName);
    }
    public void leaveRoom(String username, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        }
        if(!registeredUsers.contains(username)){
            throw new NoSuchUserException(username);
        }
        rooms.get(roomName).removeUser(username);
    }
    public void followFriend(String username, String friend_username) throws NoSuchUserException {
        if(!registeredUsers.contains(username)){
            throw new NoSuchUserException(username);
        }
        if(!registeredUsers.contains(friend_username)){
            throw new NoSuchUserException(friend_username);
        }
        rooms.values().stream()
                .filter(chatRoom -> chatRoom.hasUser(friend_username))
                .forEach(chatRoom -> chatRoom.addUser(username));
    }
}
