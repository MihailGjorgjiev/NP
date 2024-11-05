package PrvKolokviumVezbi.Quiz_23;

public abstract class Question implements Comparable<Question>{
    private final String question;
    private final int points;

    public Question(String question, int points) {
        this.question = question;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public int getPoints() {
        return points;
    }
    public abstract String getAnswer();

    @Override
    public int compareTo(Question o) {
        return points-o.getPoints();
    }
}
