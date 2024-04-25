package ShapesInterface;

public class Circulo implements Shape {
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
        System.out.println("Área del círculo: " + Math.PI*Math.pow(radio, 2));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del círculo: " + Math.PI*(radio*2));
    }
}
