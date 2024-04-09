public class Limpieza extends Producto {

    String marca;

    public Limpieza(String nombre, int numSerie, double price, String fechaImportacion, int stock, String marca) {
        super(nombre, numSerie, price, fechaImportacion, stock);
        this.marca = marca;
    }
    
    /* Atributos:
     * Marca
     */
}
