public class Book {
    public String title = "A Brief History Of Time";
    public String author = "Stephen Hawking";
    public int year = 1988;

    public void ShowData(int n) {
        System.out.println("--------------------------------");
        System.out.println("BOOK #" + n + "'s data is:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Published: " + year);
    }

}
