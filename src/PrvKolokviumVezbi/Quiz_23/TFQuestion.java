package PrvKolokviumVezbi.Quiz_23;

public class TFQuestion extends Question{
    private boolean answer;

    public TFQuestion(String question, int points, boolean answer) {
        super(question, points);
        this.answer = answer;
    }

    public String getAnswer() {
        return String.valueOf(answer);
    }

    @Override
    public String toString() {
        return String.format("True/False Question: %s Points: %d Answer: %s",getQuestion(),getPoints(),getAnswer());
    }
}
