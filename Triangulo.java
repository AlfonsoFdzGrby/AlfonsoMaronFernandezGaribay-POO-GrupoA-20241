package ShapesInterface;

public class Triangulo implements Shape {
    int base, altura;
    
    public Triangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("TRIÁNGULO EQUILATERO");
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del triángulo: " + (base*altura)/2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del triángulo: " + base*3);
    }

}
