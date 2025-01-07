package Labs.Lab7.Pattern;

public class ForwardState extends AbstractState{
    public ForwardState(MP3Player mp3) {
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
        mp3.forward();;
        mp3.setState(new PauseState(mp3));
    }

    @Override
    public void rewindCallback() {
        System.out.println("Illegal Operation");
    }
}
