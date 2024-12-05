package CollectionBook.ReadWrite.Scanner.Subtitles;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subtitles {
    List<SubtitleObject> subtitles;
    public Subtitles() {
        subtitles=new ArrayList<>();
    }

    public int loadSubtitles(InputStream inputStream){
        Scanner scanner=new Scanner(inputStream);

        while (scanner.hasNextLine()){
            int id=Integer.parseInt(scanner.nextLine());
            String timestamp= scanner.nextLine();
            StringBuilder content= new StringBuilder();
            String line;
            while (!(line= scanner.nextLine()).isBlank()){
                content.append(line);
                content.append("\n");
            }
            subtitles.add(new SubtitleObject(id,timestamp, content.toString()));
        }
        return subtitles.size();
    }

    public void print(){
        for(SubtitleObject subtitleObject:subtitles){
            System.out.println(subtitleObject);
        }
    }

    public void shift(int ms){
        for(SubtitleObject subtitleObject:subtitles){
            subtitleObject.shift(ms);
        }
    }

    public static void main(String[] args) {
        Subtitles subtitles1=new Subtitles();
        int n=subtitles1.loadSubtitles(System.in);
        System.out.println(n);
        subtitles1.print();
        subtitles1.shift(222);
        subtitles1.print();
    }


}
