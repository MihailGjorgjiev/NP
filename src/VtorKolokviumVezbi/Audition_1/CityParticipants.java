package VtorKolokviumVezbi.Audition_1;

import java.util.HashMap;

public class CityParticipants {
    private HashMap<String,Candidate> candidates;

    public CityParticipants() {
        candidates=new HashMap<>();
    }

    public void addCandidate(Candidate candidate){
        if(!candidates.containsKey(candidate.getCode())){
            candidates.put(candidate.getCode(), candidate);
        }
    }

    public HashMap<String, Candidate> getCandidates() {
        return candidates;
    }

}
