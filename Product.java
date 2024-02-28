package tarea6unidad2;

public class Product {
    private String name;
    private float price;
    private int stock;

    public Product(String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        stock = 0;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        if(name!="" && name!=null){
            this.name = name;
        }else{
            System.out.println("El nombre especificado no es valido");
        }
    }
    
    public void setPrice(float price) {
        if(price>=0){
            this.price = price;
        }
    }

    public void setStock(int stock) {
        if(stock>=0){
            this.stock = stock;
        }
    }

    public void aumentarStock(int stock) { 
        if(stock<=0){
            System.out.println("La cantidad especificada no es válida");
        }else{
            this.stock+=stock;
        }
    }

    public void reducirStock(int stock){
        if(stock>this.stock || stock==0){
            System.out.println("La cantidad especificada no es válida");
        }else{
            if(stock<=this.stock){
                this.stock-=stock;
            }
        }
    }
}
