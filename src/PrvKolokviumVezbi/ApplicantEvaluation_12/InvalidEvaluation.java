package PrvKolokviumVezbi.ApplicantEvaluation_12;

public class InvalidEvaluation extends Exception {
    public InvalidEvaluation(String message) {
        super(message);
    }
    public InvalidEvaluation() {
        super("Invalid Evaluation");
    }
}
