package VtorKolokviumVezbi.Course_31;

public class Student {
    private String index;
    private String name;
    private int firstTerm;
    private int secondTerm;
    private int labs;

    public Student() {
        this.firstTerm = 0;
        this.secondTerm = 0;
        this.labs = 0;
    }

    public Student(String index, String name) {
        this();
        this.index = index;
        this.name = name;

    }

    public String getIndex() {
        return index;
    }


    public String getName() {
        return name;
    }


    public int getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(int firstTerm) {
        this.firstTerm = firstTerm;
    }

    public int getSecondTerm() {
        return secondTerm;
    }

    public void setSecondTerm(int secondTerm) {
        this.secondTerm = secondTerm;
    }

    public int getLabs() {
        return labs;
    }

    public void setLabs(int labs) {
        this.labs = labs;
    }

    public double getSummaryPoints() {
        return (firstTerm + secondTerm) * 0.45 + labs;
    }

    public int getGrade() {
        double points = getSummaryPoints();
        if (points >= 90) return 10;
        if (points >= 80) return 9;
        if (points >= 70) return 8;
        if (points >= 60) return 7;
        if (points >= 50) return 6;
        return 5;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s First midterm: %d Second midterm %d Labs: %d Summary points: %.2f Grade: %d", index, name, firstTerm, secondTerm, labs, getSummaryPoints(), getGrade());
    }

    public void update(String activity, int points) throws Exception {
        switch (activity) {
            case "midterm1":
                int mid1 = getFirstTerm();
                int sum1 = mid1 + points;
                if (sum1 > 100) {
                    throw new Exception("Exception");
                }
                setFirstTerm(sum1);
                break;
            case "midterm2":
                int mid2 = getSecondTerm();
                int sum2 = mid2 + points;
                if (sum2 > 100) {
                    throw new Exception("Exception");
                }
                setSecondTerm(sum2);
                break;
            case "labs":
                int midl = getLabs();
                int suml = midl + points;
                if (suml > 10) {
                    throw new Exception("Exception");
                }
                setLabs(suml);
                break;

        }
    }
}