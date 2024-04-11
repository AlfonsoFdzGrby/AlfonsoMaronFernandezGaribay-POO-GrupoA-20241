import java.util.*;

public class Cliente extends Persona {
    int numCompras = 0;
    long numTarjeta;
    private ArrayList<Producto> productosComprados = new ArrayList<>();
    private ArrayList<Compra> compras = new ArrayList<>();

    public Cliente(String nombre, String cURP, String fechaNacimiento, long numTarjeta) {
        super(nombre, cURP, fechaNacimiento);
        this.numTarjeta = numTarjeta;
    }

    public void AgregarCompra(Compra compra){
        if(compra!=null){
            this.compras.add(compra);
        }
        numCompras++;
    }

    public void imprimirListaDeCompras(){
        double total = 0;
        for (int i = 0; i < compras.size(); i++) {
            Compra compra = compras.get(i);
            System.out.println(String.format("ID: %d\tTotal: $%.2f", compra.getID(), compra.getTotal()));
            total+=compra.getTotal();
        }
        System.out.printf("TOTAL DE TODAS LAS COMPRAS DE %s: $%.2f\n", getNombre().toUpperCase(), total);
    }

}