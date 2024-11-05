package PrvKolokviumVezbi.FrontPage_17;

import java.util.Calendar;
import java.util.Date;

public class NewsItem {
    private String title;
    private Date date;
    private Category category;

    public NewsItem(String title, Date date, Category category) {
        this.title = title;
        this.date = date;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public String getTeaser(){
        return title;
    }

    public static int howManyMinutesAgo(Date date){
        Calendar calendar=Calendar.getInstance();
        Date currentDate=calendar.getTime();
        long milliSeconds=currentDate.getTime()-date.getTime();
        return (int) (milliSeconds/(1000*60));
    }
}
