package Shapes;

public class Pentagono extends Shape {
    int lado;
    int apotema;

    public Pentagono(int lado, int apotema){
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("PENTÁGONO");
        System.out.println("Lado del pentágono: " + lado);
        System.out.println("Perímetro: " + lado*5);
        System.out.println("Apotema: " + apotema);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del pentágono: " + ((lado*5)*(apotema))/2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del pentágono: " + lado*5);
    }
}
