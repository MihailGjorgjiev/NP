package VtorKolokviumVezbi.PhoneBook_21;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> contacts;

    public PhoneBook() {
        contacts=new TreeMap<>();
    }
    public void addContact(String name, String number) throws DuplicateNumberException {
        contacts.putIfAbsent(name,new TreeSet<>());
        if(contacts.get(name).contains(number)){
            throw new DuplicateNumberException("DuplicateNumberException");
        }
        contacts.get(name).add(number);
    }

    public void contactsByNumber(String number){
        TreeMap<String,String> numberName=new TreeMap<>();
        contacts.entrySet().stream()
                .forEach(entry->{

                    String name=entry.getKey();
                    entry.getValue().stream().filter(s->s.contains(number))
                            .forEach(num->numberName.put(num,name));
//                            .forEach(num-> System.out.println(name+" "+num));
                });
        if (numberName.isEmpty()){
            System.out.println("NOT FOUND");
        }else {
            numberName.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(entry->{
                System.out.println(entry.getValue()+" "+entry.getKey());
            });
        }
    }

    public void contactsByName(String name){
        Set<String> numbers = contacts.getOrDefault(name, new TreeSet<>());
        if(numbers.isEmpty()){
            System.out.println("NOT FOUND");
        }else {
        numbers.stream().sorted().forEach(num->System.out.println(name+" "+num));

        }
    }
}
