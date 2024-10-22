package AV.AV3.PlayingCard;

import java.util.Arrays;

public class MultipleDeck {
    private Deck[] decks;

    public MultipleDeck(int n) {
        decks=new Deck[n];
        for(int i=0;i<n;i++){
            decks[i]=new Deck();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(Deck deck:decks){
            builder.append(deck);
            builder.append('\n');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MultipleDeck md=new MultipleDeck(3);
        System.out.println(md);
    }
}
