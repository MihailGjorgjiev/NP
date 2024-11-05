package PrvKolokviumVezbi.Subtitles_19;

import java.io.IOException;

public class SubtitlesTest {
    public static void main(String[] args) {
        Subtitles subtitles = new Subtitles();
        int n = 0;
        try {
            n = subtitles.loadSubtitles(System.in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+++++ ORIGINIAL SUBTITLES +++++");
        try {
            subtitles.print();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int shift = n * 37;
        shift = (shift % 2 == 1) ? -shift : shift;
        System.out.println(String.format("SHIFT FOR %d ms", shift));
        subtitles.shift(shift);
        System.out.println("+++++ SHIFTED SUBTITLES +++++");
        try {
            subtitles.print();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
