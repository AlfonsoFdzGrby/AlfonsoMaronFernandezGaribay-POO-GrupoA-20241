package Shapes;

public class Run {
    public static void main(String[] args) {
        Pentagono pentagono1 = new Pentagono(2, 5);
        pentagono1.mostrarInfo();
        pentagono1.calcularArea();
        pentagono1.calcularPerimetro();

        System.out.println("==========================================");
        
        Triangulo triangulo1 = new Triangulo(3, 2);
        triangulo1.mostrarInfo();
        triangulo1.calcularArea();
        triangulo1.calcularPerimetro();

        System.out.println("==========================================");
    
        Cuadrado cuadro1 = new Cuadrado(2);
        cuadro1.mostrarInfo();
        cuadro1.calcularArea();
        cuadro1.calcularPerimetro();

        System.out.println("==========================================");

        Circulo circulo1 = new Circulo(2);
        circulo1.mostrarInfo();
        circulo1.calcularArea();
        circulo1.calcularPerimetro();
    }
}
