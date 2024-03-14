import java.util.*;

public class Library {

    /* 
    Una variable estática pertenece 
    a la clase, no al objeto o instancia de clase, es decir
    mientras se ejecuta el programa, la variable está trabajando
    sólo en la clase, no en el objeto

    Una variable estática no pertenece a la instancia
    de la clase (objeto)
     */

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    public void appendToUserList(User user){
        userList.add(user);
    }

    public void appendToBookList(Book book){
        bookList.add(book);
    }

    public User searchUserByID(int id){
        User user = null;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId()==id){
                user = userList.get(i);
                System.out.println("User " + user.getName() + " found");
                break;
            }
        }
        return user;
    }

    public Book searchBook(String name, String author){
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if(name.equalsIgnoreCase(bookList.get(i).getTitle()) && author.equalsIgnoreCase(bookList.get(i).getAuthor())){
                book = bookList.get(i);
                System.out.printf("'%s' by %s found\n", book.getTitle(), book.getAuthor());
                System.out.println("Book ID: " + book.getId());
                break;
            }
        }
        return book;
    }

    public void listRentedBooks(){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if(book.isRented()){
                System.out.printf("  * '%s' by %s\n", book.getTitle(), book.getAuthor());
            }
        }
    }

    public void listUnentedBooks(){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if(!book.isRented()){
                System.out.printf("  * '%s' by %s\n", book.getTitle(), book.getAuthor());
            }
        }
    }

    public void listUsers(){
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            System.out.printf("User #%d\n  * Name: %s\n  * ID: %s\n\n",i,user.getName(),user.getId());
        }
    }

    public void listBooks(){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            System.out.printf("Book #%d\n  * Title: %s\n  * Author: %s\n\n",i, book.getTitle(), book.getAuthor());
        }
    }

    public void listHaveBought(){
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getHasBought()){
                System.out.println("  * " + user.getName());
            }
        }
    }

}
