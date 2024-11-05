package PrvKolokviumVezbi.FrontPage_17;

import java.util.Calendar;
import java.util.Date;

public class TextNewsItem extends NewsItem{
    private String text;

    public TextNewsItem(String title, Date date, Category category, String text) {
        super(title, date, category);
        this.text = text;
    }

    public String getText() {
        return text;
    }


    @Override
    public String getTeaser() {
        StringBuilder sb=new StringBuilder();
        sb.append(getTitle()).append("\n");

        Calendar calendar=Calendar.getInstance();
        int minutes=NewsItem.howManyMinutesAgo(getDate());
        sb.append(minutes).append("\n");

        if (text.length()>80){
            sb.append(text, 0, 80).append("\n");
        }else {
            sb.append(text).append("\n");
        }

        return sb.toString();
    }
}
