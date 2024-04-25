package ShapesInterface;

public class Run {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado(5);
        Triangulo triangulo = new Triangulo(5, 3);
        Pentagono pentagono = new Pentagono(5, 3);
        Circulo circulo = new Circulo(5);

        cuadrado.mostrarInfo();
        cuadrado.calcularArea();
        cuadrado.calcularPerimetro();

        System.out.println("========================================");

        triangulo.mostrarInfo();
        triangulo.calcularArea();
        triangulo.calcularPerimetro();

        System.out.println("========================================");

        pentagono.mostrarInfo();
        pentagono.calcularArea();
        pentagono.calcularPerimetro();

        System.out.println("========================================");

        circulo.mostrarInfo();
        circulo.calcularArea();
        circulo.calcularPerimetro();
    }
}
