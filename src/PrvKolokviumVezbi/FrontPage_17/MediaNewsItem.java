package PrvKolokviumVezbi.FrontPage_17;

import java.util.Calendar;
import java.util.Date;

public class MediaNewsItem extends NewsItem {
    private String url;
    private int views;

    public MediaNewsItem(String title, Date date, Category category, String url, int views) {
        super(title, date, category);
        this.url = url;
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public int getViews() {
        return views;
    }

    @Override
    public String getTeaser() {
        StringBuilder sb=new StringBuilder();
        sb.append(getTitle()).append("\n");

        Calendar calendar=Calendar.getInstance();
        int minutes=NewsItem.howManyMinutesAgo(getDate());
        sb.append(minutes).append("\n");

        sb.append(url).append("\n");

        sb.append(views).append("\n");

        return sb.toString();
    }
}
