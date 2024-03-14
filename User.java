import java.util.*;

public class User {
    private String name;
    private int age;
    private int id;
    public ArrayList<Book> rentedBookList = new ArrayList<>();
    public ArrayList<Book> boughtBookList = new ArrayList<>();
    public Random ran = new Random();
    private boolean hasBought = false;

    User(String name, int age){
        this.name = name;
        this.age = age;
        this.id = ran.nextInt(1,10000);
    }

    public void addRentedBook(Book book) {
        rentedBookList.add(book);
    }

    public void addBoughtBook(Book book) {
        boughtBookList.add(book);
    }

    public void printRentedBooks(){
        for (int i = 0; i < rentedBookList.size(); i++) {
            System.out.printf("   * '%s' by %s\n", rentedBookList.get(i).getTitle(), rentedBookList.get(i).getAuthor());
        }
    }

    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }

    public boolean getHasBought(){
        return hasBought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBoughtBookList() {
        return boughtBookList;
    }

    public ArrayList<Book> getRentedBookList() {
        return rentedBookList;
    }
}