import java.util.*;

public class Cliente extends Persona {
    int numCompras = 0;
    long numTarjeta;
    private ArrayList<Producto> productosComprados = new ArrayList<>();

    public Cliente(String nombre, String cURP, String fechaNacimiento, long numTarjeta) {
        super(nombre, cURP, fechaNacimiento);
        this.numTarjeta = numTarjeta;
    }

    public void AgregarCompra(Producto producto){
        productosComprados.add(producto);
        numCompras++;
    }

}