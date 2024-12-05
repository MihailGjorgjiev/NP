package VtorKolokviumVezbi.Audition_1;

public class Candidate {
    private String code;
    private String name;
    private int age;

    public Candidate(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d",code,name,age);
    }
}
