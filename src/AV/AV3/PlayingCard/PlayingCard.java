package AV.AV3.PlayingCard;

import java.util.Objects;

public class PlayingCard {
    public enum TYPE {
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    }
    private TYPE suit;
    private int rank;

    public PlayingCard(TYPE suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("%d %s",rank,suit.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard card = (PlayingCard) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
