package Labs.Lab7.TriviaGame;

import java.util.ArrayList;

public class TriviaData {

    private ArrayList<TriviaQuestion> data;

    public TriviaData() {
        data = new ArrayList<TriviaQuestion>();
    }

    public void addQuestion(String q, String a, int v) {
        TriviaQuestion question;
        if(a.equals("T") || a.equals("F")){
            question=new TriviaTFQuestion(q,a,v);
        }else {
            question=new TriviaFFQuestion(q,a,v);
        }
        data.add(question);
    }

    public void showQuestion(int index) {
        TriviaQuestion q = data.get(index);
        System.out.println("Question " + (index + 1) + ".  " + q.getValue() + " points.");
            System.out.println(q.getQuestion());
        if (q instanceof TriviaTFQuestion) {
            System.out.println("Enter 'T' for true or 'F' for false.");
        }
    }

    public int numQuestions() {
        return data.size();
    }

    public TriviaQuestion getQuestion(int index) {
        return data.get(index);
    }
}