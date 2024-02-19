public class Tarea3U2 {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------");
        System.out.println(" P E O P L E   D A T A ");
        /*
        * Exercise 1: Persons 
        * Creating instances:
        */
        Person person1 = new Person("Bob",13,false,1);
        Person person2 = new Person("Mary",18,true,2);
        Person person3 = new Person("Jack",25,false,3);
        Person person4 = new Person("Margaret",20,true,4);

        //Showing data:
        person1.showData();
        person2.showData();
        person3.showData();
        person4.showData();

        System.out.println("--------------------------------");
        System.out.println(" B O O K   D A T A ");

        /*
         * Exercise 2: Books
         * Creating instances:
         */
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();

        //Modifying attributes:
        book2.author = "Erich Fromm";
        book2.title = "The Heart of a Man";
        book2.year = 1964;

        book3.author = "Carl Sagan";
        book3.title = "The Dragons Of Eden";
        book3.year = 1977;

        book4.author = "George Orwell";
        book4.title = "1984";
        book4.year = 1949;

        //Showing data:
        book1.ShowData(1);
        book2.ShowData(2);
        book3.ShowData(3);
        book4.ShowData(4);

        System.out.println("--------------------------------");
        System.out.println(" R E C T A N G L E   D A T A ");

        /*
         * Exercise 3: Rectangles
         * Creating instances:
         */
        
        Rectangle rect1 = new Rectangle(5, 2,1);
        Rectangle rect2 = new Rectangle(10, 5,2);
        Rectangle rect3 = new Rectangle(30, 2,3);
        Rectangle rect4 = new Rectangle(8, 15,4);

        //Showing data:
        rect1.ShowArea();
        rect1.ShowPerimeter();
        rect2.ShowArea();
        rect2.ShowPerimeter();
        rect3.ShowArea();
        rect3.ShowPerimeter();
        rect4.ShowArea();
        rect4.ShowPerimeter();
    }
}