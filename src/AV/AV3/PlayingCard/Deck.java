package AV.AV3.PlayingCard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    private PlayingCard[] deck;
    private boolean[] picked;
    private int total;

    public Deck() {
        deck = new PlayingCard[52];
        picked = new boolean[52];
        total = 0;

        for (int suit = 0; suit < PlayingCard.TYPE.values().length; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                deck[rank + suit * 13] = new PlayingCard(PlayingCard.TYPE.values()[suit], rank+1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (PlayingCard card : deck) {
            builder.append(card + ", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck1 = (Deck) o;
        return Objects.deepEquals(deck, deck1.deck);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(deck);
    }

    public PlayingCard dealCard() {
        if (total == 52) {
            return null;
        }
        int[] choices=IntStream.range(0,picked.length).filter(i->!picked[i]).toArray();
        int card= (int) (choices.length*Math.random());
        picked[card]=true;
        total++;
        return deck[card];
    }

    public void shuffle(){
        List<Integer> indices=IntStream.range(0,deck.length).mapToObj(Integer::valueOf).collect(Collectors.toList());
        Collections.shuffle(indices);

        for(int i=0;i<52;i++){
            PlayingCard tempCard=deck[i];
            boolean tempPicked=picked[i];

            deck[i]=deck[indices.get(i)];
            picked[i]=picked[indices.get(i)];

            deck[indices.get(i)]=tempCard;
            picked[indices.get(i)]=tempPicked;

        }


    }

    public static void main(String[] args) {
        Deck deck=new Deck();
        PlayingCard card;
        while ((card=deck.dealCard()) != null){
            System.out.println(card);
        }
        deck=new Deck();
        System.out.println(deck);
        deck.shuffle();;
        System.out.println(deck);
    }
}
