package Labs.Lab7.Pattern;

public class PlayState extends AbstractState{
    public PlayState(MP3Player mp3) {
        super(mp3);
    }

    @Override
    public void pressPlay() {
        System.out.println("Song is already playing");
    }

    @Override
    public void pressStop() {
        System.out.println(String.format("Song %d is paused", mp3.getCurrentSong()));
        mp3.setState(new PauseState(mp3));
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
