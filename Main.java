package tarea6unidad2;

public class Main {
    public static void main(String[] args) throws Exception {
        Product prod = new Product("Playeras", 150, 15);
        Product prod2 = new Product("Balón de futbol", 50);
        
        System.out.println(prod.getName());
        System.out.println(prod.getStock());
        System.out.println(prod.getPrice());

        prod.aumentarStock(150);
        prod.reducirStock(500);

        System.out.println(prod.getStock());

        System.out.println(prod2.getName());
        System.out.println(prod2.getStock());
        System.out.println(prod2.getPrice());

        prod2.aumentarStock(150);
        prod2.reducirStock(500);

        System.out.println(prod2.getStock());
    }   
}
