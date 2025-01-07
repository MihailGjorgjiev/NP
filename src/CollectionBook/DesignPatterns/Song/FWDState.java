package CollectionBook.DesignPatterns.Song;

public class FWDState extends AbstractState{
    public FWDState(Mp3Player mp3Player) {
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
        getMp3Player().songFWD();
        getMp3Player().setState(new PauseState(getMp3Player()));
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
