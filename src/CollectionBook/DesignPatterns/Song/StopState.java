package CollectionBook.DesignPatterns.Song;

public class StopState extends AbstractState {
    public StopState(Mp3Player mp3Player) {
        super(mp3Player);
    }

    @Override
    public void pressPlay() {
        System.out.println("Song " + getMp3Player().getCurrentSongIndex() +
                " is playing");
        getMp3Player().setState(new PlayState(getMp3Player()));
    }

    @Override
    public void pressStop() {
        System.out.println("Songs are already stopped");
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
