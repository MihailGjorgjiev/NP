package Labs.Lab7.Pattern;

import java.util.ArrayList;
import java.util.List;

public class MP3Player {
    private List<Song> songs;
    private State state;
    private int currentSong;

    public MP3Player() {
        this.songs = new ArrayList<>();
        this.state = new StopState(this);
        this.currentSong = 0;
    }

    public MP3Player(List<Song> songs) {
        this();
        this.songs = songs;

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(int currentSong) {
        this.currentSong = currentSong;
    }

    public void forward() {
        currentSong = (currentSong + 1) % songs.size();
    }
    public void reward(){
        currentSong--;
        if(currentSong<0){
            currentSong=songs.size()-1;
        }
    }

    public void pressPlay(){
        state.pressPlay();
    }
    public void pressStop(){
        state.pressStop();
    }

    public void pressFWD(){
        state.pressForward();;
        state.forwardCallback();
    }

    public void pressREW(){
        state.pressRewind();
        state.rewindCallback();
    }

    public void printCurrentSong(){
        System.out.println(songs.get(currentSong));
    }

    @Override
    public String toString() {
        return "MP3Player{" +
                "currentSong = " + currentSong +
                ", songList = " + songs +'}';
    }
}
