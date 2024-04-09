public class Electrodomestico extends Producto {
    String tipoDeAlimentacion;

    public Electrodomestico(String nombre, int numSerie, double price, String fechaImportacion, int stock,
            String tipoDeAlimentacion) {
        super(nombre, numSerie, price, fechaImportacion, stock);
        this.tipoDeAlimentacion = tipoDeAlimentacion;
    }
    
}
