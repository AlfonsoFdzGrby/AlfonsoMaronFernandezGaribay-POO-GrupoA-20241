public class Maquillaje extends Producto {
    String tipo;
    String pigmento;

    public Maquillaje(String nombre, int numSerie, double price, String fechaImportacion, int stock, String tipo,
            String pigmento) {
        super(nombre, numSerie, price, fechaImportacion, stock);
        this.tipo = tipo;
        this.pigmento = pigmento;
    }
    
    
}
