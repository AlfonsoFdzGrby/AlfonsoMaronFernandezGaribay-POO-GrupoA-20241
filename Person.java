public class Person {
    String name;
    int age;
    int id;
    boolean gender; //False = Male , True = Female

    Person(String n, int a, boolean g, int id) {
        name = n;
        age = a;
        gender = g;
        this.id = id;
    }

    public void showData() {
        System.out.println("--------------------------------");
        System.out.println("Person #" + id + "'s data is:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if(gender){
            System.out.println("Gender: Female");
        }else{
            System.out.println("Gender: Male");
        }
    }
}
