package ShapesInterface;

public class Pentagono implements Shape {
    int lado, apotema;

    public Pentagono(int lado, int apotema){
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("PENTÁGONO");
        System.out.println("Lado: " + lado);
        System.out.println("Apotema: " + apotema);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del pentágono: " + ((lado*5)*apotema)/2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del pentágono: " + lado*5);
    }
}
