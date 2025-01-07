package Labs.Lab7.TriviaGame;

public abstract class TriviaQuestion {
    private String question;		// Actual question
    private String answer;		// Answer to question
    private int value;			// Point value of question


    public TriviaQuestion() {
        this.question = "";
        this.answer = "";
        this.value = 0;

    }
    public TriviaQuestion(String q, String a, int v) {
        question = q;
        answer = a;
        value = v;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getValue() {
        return value;
    }
}