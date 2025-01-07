package Labs.Lab7.Pattern;

public class PauseState extends AbstractState{
    public PauseState(MP3Player mp3) {
        super(mp3);
    }

    @Override
    public void pressPlay() {
        System.out.println(String.format("Song %d is playing", mp3.getCurrentSong()));
        mp3.setState(new PlayState(mp3));
    }

    @Override
    public void pressStop() {
        System.out.println("Songs are stopped");
        mp3.setCurrentSong(0);
        mp3.setState(new StopState(mp3));
    }

    @Override
    public void pressForward() {
        System.out.println("Forward...");
        mp3.setState(new ForwardState(mp3));
    }

    @Override
    public void pressRewind() {
        System.out.println("Reward...");
        mp3.setState(new RewindState(mp3));
    }

    @Override
    public void forwardCallback() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void rewindCallback() {
        System.out.println("Illegal Operation");
    }
}
