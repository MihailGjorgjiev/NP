package CollectionBook.ReadWrite.Scanner.Subtitles;

import java.time.LocalTime;

public class SubtitleObject {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;

    private String content;

    public SubtitleObject(int id,String timestamp,String content){
        this.id=id;
        this.content=content;

        String[] times=timestamp.split(" --> ");
        startTime=LocalTime.parse(times[0].replace(',','.'));
        endTime=LocalTime.parse(times[1].replace(',','.'));
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void shift(int ms){
        startTime=startTime.plusNanos((long) (ms*1e6));
        endTime=endTime.plusNanos((long) (ms*1e6));
    }

    public String getTimestamp(){
        return startTime.toString().replace('.',',')+" --> "+endTime.toString().replace('.',',');
    }

    @Override
    public String toString() {

        return id + "\n" +
                getTimestamp() + "\n" +
                content;
    }
}
