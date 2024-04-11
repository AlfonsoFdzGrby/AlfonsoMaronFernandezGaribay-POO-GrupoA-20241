public class Producto {
    private static int nextID = 0;
    int id;
    int stock;
    String nombre;
    int numSerie;
    double precio;
    String fechaImportacion;

    public Producto(String nombre, int numSerie, double price, String fechaImportacion, int stock) {
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.precio = price;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.id = nextID;
        nextID++;
    }

    protected int getID(){
        return id;
    }

    protected String getNombre(){
        return nombre;
    }

    protected boolean agregarStock(int stock){
        boolean agregado = false;
        if(stock>0){
            this.stock+=stock;
            agregado = true;
        }
        return agregado;
    }

    protected boolean quitarStock(int stock){
        boolean quitado = false;
        if(!(stock<0 || stock>this.stock)){
            this.stock-=stock;
            quitado = true;
        }
        return quitado;
    }

    protected int getStock(){
        return stock;
    }

    public double getPrecio(){
        return precio;
    }

}
