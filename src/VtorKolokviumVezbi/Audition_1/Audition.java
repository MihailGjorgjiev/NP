package VtorKolokviumVezbi.Audition_1;

import java.util.*;
import java.util.stream.Collectors;

public class Audition {
    private HashMap<String, CityParticipants> cityParticipants;

    public Audition() {
        cityParticipants=new HashMap<>();
    }

    public void addParticpant(String city, String code, String name, int age){
        if(!cityParticipants.containsKey(city)){
            cityParticipants.put(city,new CityParticipants());
        }
        CityParticipants cityParticipants1 = cityParticipants.get(city);
        cityParticipants1.addCandidate(new Candidate(code,name,age));
    }

    public void listByCity(String city){
        List<Candidate> values = new ArrayList<>(cityParticipants.get(city).getCandidates().values());
        Collections.sort(values,Comparator.comparing(Candidate::getName).thenComparingInt(Candidate::getAge));

        for(Candidate candidate:values){
            System.out.println(candidate.toString());
        }
    }
}
