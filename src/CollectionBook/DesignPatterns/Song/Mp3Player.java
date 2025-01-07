package CollectionBook.DesignPatterns.Song;

import java.util.List;

public class Mp3Player {
    private List<Song> songList;
    private int currentSong;

    private State state;


    public Mp3Player(List<Song> songList) {
        this.songList = songList;
        this.currentSong = 0;

        this.state = new StopState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Song getCurrentSong() {
        return songList.get(currentSong);
    }

    public void setCurrentSongIndex(int currentSong) {
        this.currentSong = currentSong;
    }

    public int getCurrentSongIndex() {
        return currentSong;
    }

    public void songFWD() {
        currentSong = (currentSong + 1) % songList.size();
    }

    public void songREW() {
        currentSong = (currentSong + songList.size() - 1) % songList.size();
    }

    public void pressPlay() {
        state.pressPlay();
    }

    public void pressStop() {
        state.pressStop();
    }

    public void pressFWD() {
        state.pressFwd();
        state.forward();
    }

    public void pressREW() {
        state.pressRew();
        state.reward();
    }

    @Override
    public String toString() {
        return "Mp3Player{" +
                "currentSong = " + currentSong +
                ", songList = " + songList +
                '}';
    }
    public void printCurrentSong(){
        System.out.println(getCurrentSong());
    }
}
