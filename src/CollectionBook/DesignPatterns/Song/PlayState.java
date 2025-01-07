package CollectionBook.DesignPatterns.Song;

public class PlayState extends AbstractState{
    public PlayState(Mp3Player mp3Player) {
        super(mp3Player);
    }

    @Override
    public void pressPlay() {
        System.out.println("Song is already playing");
    }

    @Override
    public void pressStop() {
        System.out.println("Song "+getMp3Player().getCurrentSongIndex()+" is paused");
        getMp3Player().setState(new PauseState(getMp3Player()));
    }

    @Override
    public void pressFwd() {
        System.out.println("Forward...");
        getMp3Player().setState(new FWDState(getMp3Player()));
    }

    @Override
    public void pressRew() {
        System.out.println("Reward...");
        getMp3Player().setState(new REWState(getMp3Player()));
    }

    @Override
    public void forward() {
        System.out.println("Illegal action");
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
