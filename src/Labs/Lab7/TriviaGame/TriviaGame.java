package Labs.Lab7.TriviaGame;

import java.util.Scanner;

public class TriviaGame {

    public TriviaData questions;	// Questions

    public TriviaGame() {
        // Load questions
        questions = new TriviaData();
        questions.addQuestion("The possession of more than two sets of chromosomes is termed?",
                "polyploidy", 3);
        questions.addQuestion("Erling Kagge skiied into the north pole alone on January 7, 1993.",
                "F", 1);
        questions.addQuestion("1997 British band that produced 'Tub Thumper'",
                "Chumbawumba", 2);
        questions.addQuestion("I am the geometric figure most like a lost parrot",
                "polygon", 2);
        questions.addQuestion("Generics were introducted to Java starting at version 5.0.",
                "T", 1);
    }
    // Main game loop

    public static void main(String[] args) {
        int score = 0;			// Overall score
        int questionNum = 0;	// Which question we're asking
        TriviaGame game = new TriviaGame();
        Scanner keyboard = new Scanner(System.in);
        // Ask a question as long as we haven't asked them all
        while (questionNum < game.questions.numQuestions()) {
            // Show question
            game.questions.showQuestion(questionNum);
            // Get answer
            String answer = keyboard.nextLine();
            // Validate answer
            TriviaQuestion q = game.questions.getQuestion(questionNum);
            if(answer.trim().toLowerCase().equals(q.getAnswer().trim().toLowerCase())){
                System.out.println("That is correct!  You get " + q.getValue() + " points.");
                score += q.getValue();
            }else {
                System.out.println("Wrong, the correct answer is " + q.getAnswer());
            }

            System.out.println("Your score is " + score);
            questionNum++;
        }
        System.out.println("Game over!  Thanks for playing!");
    }
}