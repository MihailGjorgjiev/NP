package Labs.Lab7.Pattern;

public abstract class AbstractState implements State {
    MP3Player mp3;

    public AbstractState(MP3Player mp3) {
        this.mp3 = mp3;
    }
}
