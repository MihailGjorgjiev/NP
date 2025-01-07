package CollectionBook.DesignPatterns.Song;

public interface State {
    void pressPlay();
    void pressStop();
    void pressFwd();
    void pressRew();

    void forward();
    void reward();

}
