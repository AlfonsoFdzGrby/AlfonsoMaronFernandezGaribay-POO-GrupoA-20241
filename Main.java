import java.util.*;

public class Main {
    public static User user;
    public static Book book;
    public static Library library = new Library();
    public static Scanner sc = new Scanner(System.in);


    public static void printHeader(String header) {
        System.out.println("=======================================================");
        System.out.println(header);
        System.out.println("=======================================================");
    }
    public static void main(String[] args) {
        User baseUser = new User("User1", 25);
        baseUser.setId(1234);
        library.appendToBookList(new Book("1984", "George Orwell"));
        library.appendToBookList(new Book("Cosmos", "Carl Sagan"));
        library.appendToBookList(new Book("The Heart of a Man", "Erich Fromm"));
        library.appendToBookList(new Book("Hamlet", "William Shakespeare"));
        library.appendToUserList(baseUser);

        while(true){
            printHeader("L I B R A R Y");

            System.out.println("1. Register User");
            System.out.println("2. Register Book");
            System.out.println("3. Rent Book");
            System.out.println("4. Buy Book");
            System.out.println("5. List all rented books");
            System.out.println("6. List Unrented Books");
            System.out.println("7. List Rented Books by a user");
            System.out.println("8. List Users who have bought Books");
            System.out.println("9. List Registered Users");
            System.out.println("10. List Registered Books");
            System.out.println("11. Exit Library Assistant");
            System.out.print(">> ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerBook();
                    break;
                case 3:
                    rentBook();
                    break;
                case 4:
                    buyBook();
                    break;
                case 5:
                    listRentedBooksLibrary();
                    break;
                case 6:
                    listUnrentedBooks();
                    break;
                case 7:
                    listRentedBooksUser();
                    break;
                case 8:
                    listHaveBought();
                    break;
                case 9:
                    listRegisteredUsers();
                    break;
                case 10:
                    listRegisteredBooks();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void registerUser() {
        printHeader("REGISTER USER");
            int age;
            System.out.println("Please enter your name:");
            System.out.print(">> ");
            String username = sc.nextLine();
            while(true){
                System.out.println("Please enter your age:");
                System.out.print(">> ");
                age = sc.nextInt();
                sc.nextLine();
                if(age<18){
                    System.out.println("User must be at least 18 years old");
                }else{
                    break;
                }
            }
            user = new User(username, age);
            library.appendToUserList(user);
            System.out.println("\nThe user " + user.getName() + " has been registered successfully!");
            System.out.println("Your user ID is " + user.getId());
            System.out.println("WARNING: You will need your user ID in order to rent books, so write it down!");
            System.out.println("Press enter to return to the main menu...");
            sc.nextLine();
    }

    public static void registerBook() {
        printHeader("REGISTER BOOK");
        System.out.println("Please enter the title of the book:");
        System.out.print(">> ");
        String title = sc.nextLine();
        System.out.println("Please enter the author of the book:");
        System.out.print(">> ");
        String author = sc.nextLine();
        book = new Book(title, author);
        library.appendToBookList(book);
        System.out.printf("\n'%s' by %s has been registered successfully!\n", book.getTitle(), book.getAuthor());
        System.out.println("The book ID is " + book.getId());
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

    public static void rentBook() {
        printHeader("BOOK RENTAL");
        while(true){
            System.out.println("Please enter your user ID:");
            System.out.print(">> ");
            int id = sc.nextInt();
            sc.nextLine();
            User tempUser = library.searchUserByID(id);
            if(tempUser==null){
                System.out.println("The user was not found");
            }else{
                user = tempUser;
                break;
            }
        }

        while(true){
            System.out.println("Please enter the name of the book:");
            System.out.print(">> ");
            String name = sc.nextLine();
            System.out.println("Please enter the author of the book:");
            System.out.print(">> ");
            String author = sc.nextLine();
            Book tempBook = library.searchBook(name, author);
            if(tempBook==null){
                System.out.println("The book was not found");
            }else{
                book = tempBook;
                if(book.isRented()){
                    System.out.println("The book is already rented");
                    System.out.println("Press enter to return to main menu...");
                    sc.nextLine();
                    break;
                }else{
                    book.setRented(true);
                    user.addRentedBook(book);
                    System.out.printf("'%s' by %s has been rented to user %s\n", book.getTitle(), book.getAuthor(), user.getName());
                    System.out.println("Press enter to return to main menu...");
                    sc.nextLine();
                    break;
                }
            }
        }
    }

    public static void listRentedBooksUser() {
        printHeader("RENTED BOOKS (USER)");
        while(true){
            System.out.println("Please enter your user ID:");
            System.out.print(">> ");
            int id = sc.nextInt();
            sc.nextLine();
            User tempUser = library.searchUserByID(id);
            if(tempUser==null){
                System.out.println("The user was not found");
            }else{
                user = tempUser;
                break;
            }
        }
        System.out.println(user.getName()+"'s rented books:");
        user.printRentedBooks();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

    public static void listRentedBooksLibrary() {
        printHeader("RENTED BOOKS (LIBRARY)");
        library.listRentedBooks();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

    public static void listRegisteredUsers() {
        printHeader("REGISTERED USERS");
        library.listUsers();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

    public static void listRegisteredBooks() {
        printHeader("REGISTERED BOOKS");
        library.listBooks();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }
    
    public static void buyBook() {
        printHeader("BUY BOOK");
        while(true){
            System.out.println("Please enter your user ID:");
            System.out.print(">> ");
            int id = sc.nextInt();
            sc.nextLine();
            User tempUser = library.searchUserByID(id);
            if(tempUser==null){
                System.out.println("The user was not found");
            }else{
                user = tempUser;
                break;
            }
        }
        while(true){
            System.out.println("Please enter the name of the book:");
            System.out.print(">> ");
            String name = sc.nextLine();
            System.out.println("Please enter the author of the book:");
            System.out.print(">> ");
            String author = sc.nextLine();
            Book tempBook = library.searchBook(name, author);
            if(tempBook==null){
                System.out.println("The book was not found");
            }else{
                book = tempBook;
                user.addBoughtBook(book);
                user.setHasBought(true);
                System.out.printf("You have successfully purchased a copy of '%s' by %s\n", book.getTitle(), book.getAuthor());
                System.out.println("Enjoy your book!");
                System.out.println("Press enter to return to main menu...");
                sc.nextLine();
                break;
            }
        }
    }

    public static void listHaveBought() {
        printHeader("USERS WHO'VE BOUGHT BOOKS");
        library.listHaveBought();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

    public static void listUnrentedBooks() {
        printHeader("UNRENTED BOOKS");
        library.listUnentedBooks();
        System.out.println("Press enter to return to main menu...");
        sc.nextLine();
    }

}