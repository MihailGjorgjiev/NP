package CollectionBook.DesignPatterns.Song;

public class REWState extends AbstractState{
    public REWState(Mp3Player mp3Player) {
        super(mp3Player);
    }

    @Override
    public void pressPlay() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressStop() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressFwd() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressRew() {
        System.out.println("Illegal action");
    }

    @Override
    public void forward() {
        System.out.println("Illegal action");
    }

    @Override
    public void reward() {
        getMp3Player().songREW();
        getMp3Player().setState(new PauseState(getMp3Player()));
    }
}
