package CollectionBook.DesignPatterns.Song;

public abstract class AbstractState implements State{
    private Mp3Player mp3Player;

    public AbstractState(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    public Mp3Player getMp3Player() {
        return mp3Player;
    }

    public void setMp3Player(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }


}
