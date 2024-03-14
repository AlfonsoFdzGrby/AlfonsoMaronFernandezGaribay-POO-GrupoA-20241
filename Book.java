import java.util.*;

public class Book {
    private String title;
    private String author;
    private int id;
    private boolean rented = false;
    public Random ran = new Random();

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.id = ran.nextInt(1,1000);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
