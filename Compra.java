import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    private static int nextID = 1;
    private int id;
    private ArrayList<Producto> productos = new ArrayList<>();
    private double total;
    private LocalDate fechaDeCompra;
    private Cliente cliente;
    
    public Compra(ArrayList<Producto> productos, double total, Cliente cliente) {
        this.productos = productos;
        this.total = total;
        this.id = nextID;
        nextID++;
        this.fechaDeCompra = LocalDate.now();
        this.cliente = cliente;
    }

    public void imprimirListaDeCompras(){
        System.out.println("Compra #" + id);
        System.out.println("  * Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println(String.format("     * %s \t $%.2f", producto.getNombre(), producto.getPrecio()));
        }
    }

    public void imprimirInfoCompra(){
        System.out.println(String.format("Compra %d\t Total: $%.2f\t Cliente: %s", id, total, cliente.getNombre()));
    }

    public int getID(){
        return id;
    }

    public double getTotal() {
        return total;
    }
    
}
