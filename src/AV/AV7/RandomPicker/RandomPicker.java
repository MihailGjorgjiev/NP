package AV.AV7.RandomPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPicker {
    private final int numCompetitors;

    public RandomPicker(int numCompetitors) {
        this.numCompetitors = numCompetitors;
    }

    public List<Integer> pick(int numWinners){
        List<Integer> winners=new ArrayList<>();
        Random random=new Random();
        while (winners.size() != numWinners){
            int possibleWinner= random.nextInt(numWinners)+1;
            if(!winners.contains(possibleWinner)){
                winners.add(possibleWinner);
            }
        }
        return winners;
    }

    public static void main(String[] args) {
        RandomPicker picker=new RandomPicker(30);
        System.out.println(picker.pick(3));
    }
}
