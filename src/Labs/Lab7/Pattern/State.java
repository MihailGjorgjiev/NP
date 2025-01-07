package Labs.Lab7.Pattern;

public interface State {
    void pressPlay();
    void pressStop();
    void pressForward();
    void pressRewind();
    void forwardCallback();
    void rewindCallback();
}
