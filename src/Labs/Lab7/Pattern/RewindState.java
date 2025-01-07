package Labs.Lab7.Pattern;

public class RewindState extends AbstractState{
    public RewindState(MP3Player mp3) {
        super(mp3);
    }

    @Override
    public void pressPlay() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void pressStop() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void pressForward() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void pressRewind() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void forwardCallback() {
        System.out.println("Illegal Operation");
    }

    @Override
    public void rewindCallback() {
        mp3.reward();
        mp3.setState(new PauseState(mp3));
    }
}
