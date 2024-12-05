package VtorKolokviumVezbi.Books_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection {
    private List<Book> books;

    public BookCollection() {
        books=new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void printByCategory(String category){
        List<Book> filteredBooksByCategory=books.stream().filter(book->book.getCategory().equals(category)).collect(Collectors.toList());
        Collections.sort(filteredBooksByCategory, Comparator.comparing(Book::getTitle,String::compareToIgnoreCase).thenComparingDouble(Book::getPrice));
        for(Book book:filteredBooksByCategory){
            System.out.println(book);
        }
    }

    public List<Book> getCheapestN(int n){
        List<Book> sortedBooksByPrice=books.stream().sorted(Comparator.comparingDouble(Book::getPrice).thenComparing(Book::getTitle)).collect(Collectors.toList());
        if(sortedBooksByPrice.size()>n){
            return sortedBooksByPrice.subList(0,n);
        }else {
            return sortedBooksByPrice;
        }
    }
}
