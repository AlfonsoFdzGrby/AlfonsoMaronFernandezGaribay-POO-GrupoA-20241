public class Alimento extends Producto {
    /* Atributos
     * Fecha de caducidad
     */

    String fechaCad;

    public Alimento(String nombre, int numSerie, double price, String fechaImportacion, int stock, String fechaCad) {
        super(nombre, numSerie, price, fechaImportacion, stock);
        this.fechaCad = fechaCad;
    }

}
