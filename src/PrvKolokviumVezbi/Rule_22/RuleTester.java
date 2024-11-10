package PrvKolokviumVezbi.Rule_22;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class RuleTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        if (testCase == 1) { //Test for String,Integer
            List<Rule<String, Integer>> rules = new ArrayList<>();

            /*
            TODO: Add a rule where if the string contains the string "NP", the result would be index of the first occurrence of the string "NP"
            * */

            Rule<String,Integer> rule1=new Rule<>(
              s->s.contains("NP"),s->s.indexOf("NP")
            );
            rules.add(rule1);
            /*
            TODO: Add a rule where if the string starts with the string "NP", the result would be length of the string
            * */
            Rule<String,Integer> rule2=new Rule<>(
                    s->s.startsWith("NP"),s->s.length()
            );
            rules.add(rule2);

            List<String> inputs = new ArrayList<>();
            while (sc.hasNext()) {
                inputs.add(sc.nextLine());
            }

            RuleProcessor.process(inputs, rules);


        } else { //Test for Student, Double
            List<Rule<Student, Double>> rules = new ArrayList<>();

            //TODO Add a rule where if the student has at least 3 grades, the result would be the max grade of the student
            Rule<Student,Double> rule1=new Rule<>(s->s.grades.size()>=3,s->s.grades.stream().max(Double::compare).orElse(0).doubleValue());
            rules.add(rule1);

            //TODO Add a rule where if the student has an ID that starts with 20, the result would be the average grade of the student
            //If the student doesn't have any grades, the average is 5.0
            Rule<Student,Double> rule2=new Rule<>(s->s.id.startsWith("20"),s->s.grades.stream().mapToDouble(Integer::doubleValue).average().orElse(5.0));
            rules.add(rule2);
            List<Student> students = new ArrayList<>();
            while (sc.hasNext()){
                students.add(Student.create(sc.nextLine()));
            }

            RuleProcessor.process(students, rules);
        }
    }
}
