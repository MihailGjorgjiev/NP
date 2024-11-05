package PrvKolokviumVezbi.ApplicantEvaluation_12;

public class EvaluatorBuilder {
    private static final Evaluator noCriminalRecordAndMoreExperience = applicant -> !applicant.hasCriminalRecord() && applicant.getEmploymentYears() >= 10;
    private static final Evaluator noCriminalRecord = applicant -> !applicant.hasCriminalRecord();
    private static final Evaluator moreExperience = applicant -> applicant.getEmploymentYears() >= 10;
    private static final Evaluator moreCreditScore = applicant -> applicant.getCreditScore() >= 500;
    private static final Evaluator noCriminalRecordAndMoreCreditScore = applicant -> !applicant.hasCriminalRecord() && applicant.getCreditScore() >= 500;
    private static final Evaluator moreExperienceAndMoreCreditScore = applicant -> applicant.getEmploymentYears() >= 10 && applicant.getCreditScore() >= 500;

    public static Evaluator build(Evaluator.TYPE type) throws InvalidEvaluation {

        switch (type) {
            case NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE:
                return noCriminalRecordAndMoreExperience;
            case NO_CRIMINAL_RECORD:
                return noCriminalRecord;
            case MORE_EXPERIENCE:
                return moreExperience;
            case MORE_CREDIT_SCORE:
                return moreCreditScore;
            case MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE:
                return moreExperienceAndMoreCreditScore;
            case NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE:
                return noCriminalRecordAndMoreCreditScore;
            default:
                throw new InvalidEvaluation();

        }
    }
}

