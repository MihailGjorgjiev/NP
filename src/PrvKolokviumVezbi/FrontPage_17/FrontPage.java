package PrvKolokviumVezbi.FrontPage_17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FrontPage {
    private Category[] categories;
    private List<NewsItem> newsItems;

    public FrontPage(Category[] categories) {
        this.categories = categories;
        this.newsItems = new ArrayList<>();
    }

    public Category[] getCategories() {
        return categories;
    }

    public void addNewsItem(NewsItem newsItem) {
        newsItems.add(newsItem);
    }

    public List<NewsItem> listByCategory(Category category) {
        return newsItems.stream().filter(ni -> ni.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        boolean categoryExists = false;
        for (Category c : categories) {
            if (c.getName().equals(category)) {
                categoryExists = true;
                break;
            }
        }
        if (!categoryExists) {
            throw new CategoryNotFoundException(category);
        }
        return newsItems.stream().filter(ni -> ni.getCategory().getName().equals(category)).toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NewsItem item : newsItems) {
            sb.append(item.getTeaser());
        }
        return sb.toString();
    }
}
