package PrvKolokviumVezbi.Rule_22;

import java.util.List;
import java.util.Optional;

public class RuleProcessor {
    public static <T,R> void process(List<T> inputs, List<Rule<T, R>> rules) {
        for(T input:inputs){
            System.out.println("Input: "+input);
            for(Rule<T,R> rule:rules){
                Optional<R> result=rule.apply(input);
                if(result.isPresent()){
                    System.out.println("Result: "+result.get());
                }else {
                    System.out.println("Condition not met");
                }
            }
        }
    }
}