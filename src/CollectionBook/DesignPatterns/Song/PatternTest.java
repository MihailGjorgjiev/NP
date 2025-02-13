package CollectionBook.DesignPatterns.Song;


import java.util.*;

public class PatternTest {
    public static void main(String[] args) {
        List<Song> listSongs = new ArrayList<Song>();
        listSongs.add(new Song(" first - title ", " first - artist "));
        listSongs.add(new Song(" second - title ", " second - artist "));
        listSongs.add(new Song(" third - title ", " third - artist "));
        listSongs.add(new Song(" fourth - title ", " fourth - artist "));
        listSongs.add(new Song(" fifth - title ", " fifth - artist "));
        Mp3Player player = new Mp3Player(listSongs);

        System.out.println(player.toString());
        System.out.println(" First test ");


        player.pressPlay();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
        System.out.println(" Second test ");


        player.pressStop();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressStop();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressStop();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
        System.out.println(" Third test ");


        player.pressFWD();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
    }
}