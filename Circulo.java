package Shapes;

public class Circulo extends Shape {
    int radio;
    
    public Circulo(int radio){
        this.radio = radio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("CÍRCULO");
        System.out.println("Radio: " + radio);
        System.out.println("Diámetro: " + radio*2);   
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del círculo: " + 3.14159*(radio*radio));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del círculo: " + 3.14159*(radio*2));
    }
}
