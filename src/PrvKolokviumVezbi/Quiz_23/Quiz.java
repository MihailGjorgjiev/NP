package PrvKolokviumVezbi.Quiz_23;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(String questionData) throws InvalidOperationException {
        String[] parts=questionData.split(";");
        int pts=Integer.parseInt(parts[2]);
        if(parts[0].equals("MC")){
            questions.add(new MCQuestion(parts[1],pts,parts[3].charAt(0)));
        }else {
            boolean answer= parts[3].equals("true");
            questions.add(new TFQuestion(parts[1],pts,answer));
        }
    }

    public void printQuiz(OutputStream os) throws IOException {
        try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os))){
            for (Question q:questions.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())){
                writer.write(q.toString());
                writer.newLine();
            }
            writer.flush();
        }
    }


    public void answerQuiz(List<String> answers, OutputStream os) throws IOException, InvalidOperationException {
        if(answers.size()!= questions.size()){
            throw new InvalidOperationException("Answers and questions must be of same length!");
        }
        try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os))){
            double totalPoints=0;
            for (int i = 0; i < questions.size(); i++) {
                double pts=0;
                if(answers.get(i).equals(questions.get(i).getAnswer())){
                    pts=questions.get(i).getPoints();
                }else {
                    if(questions.get(i) instanceof MCQuestion){
                        pts=-questions.get(i).getPoints()*0.2;
                    }
                }
                writer.write(String.format("%d. %.2f",i+1,pts));
                writer.newLine();

                totalPoints+=pts;
            }
            writer.write(String.format("Total points: %.2f",totalPoints));
            writer.flush();
        }

    }
}
