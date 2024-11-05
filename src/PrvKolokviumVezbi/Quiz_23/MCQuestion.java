package PrvKolokviumVezbi.Quiz_23;

public class MCQuestion extends Question{
    private final char answer;

    public MCQuestion(String question, int points, char answer) throws  InvalidOperationException {
        super(question, points);
        if(!"ABCDE".contains(String.valueOf(answer))){
            throw new InvalidOperationException(answer+" is not allowed option for this question");
        }
        this.answer = answer;
    }

    public String getAnswer() {
        return String.valueOf(answer);
    }

    @Override
    public String toString() {
        return String.format("Multiple Choice Question: %s Points %d Answer: %s",getQuestion(),getPoints(),getAnswer());
    }
}
