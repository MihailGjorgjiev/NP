package Labs.Lab7.Pattern;

public class Song {
    private String title;
    private String author;

    public Song(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title=" + title +
                ", artist=" + author +
                '}';
    }
}
