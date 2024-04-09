import java.util.*;

public class Tienda {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<>();
    private ArrayList<Electrodomestico> productosElectrodomesticos = new ArrayList<>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Métodos PRIVADOS

    private void printHeader(String header){
        System.out.println("===================================================");
        System.out.println(header);
        System.out.println("===================================================");
    }

    private void returnToMainMenu(){
        System.out.print("Presione enter para volver al menú principal...");
        sc.nextLine();
    }

    private String[] registrarDatosComunesProducto(){
        String[] datos = new String[5];
        System.out.println("Ingrese el nombre del producto");
        System.out.print(">> ");
        datos[0] = sc.nextLine();
        System.out.println("Ingrese el número de serie");
        System.out.print(">> ");
        datos[1] = sc.nextLine();
        System.out.println("Ingrese el precio");
        System.out.print(">> ");
        datos[2] = sc.nextLine();
        System.out.println("Ingrese la fecha de importación (dd/mm/aa)");
        System.out.print(">> ");
        datos[3] = sc.nextLine();
        System.out.println("Ingrese el stock del producto");
        System.out.print(">> ");
        datos[4] = sc.nextLine();
        return datos;
    }

    private String[] registrarDatosComunesPersona(){
        String[] datos = new String[3];
        System.out.println("Ingrese su nombre completo");
        System.out.print(">> ");
        datos[0] = sc.nextLine();
        System.out.println("Ingrese su CURP");
        System.out.print(">> ");
        datos[1] = sc.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (dd/mm/aa)");
        datos[2] = sc.nextLine();
        return datos;
    }

    // Registro de PRODUCTOS

    public void registrarProductoLimpieza(){
        printHeader("REGISTRAR PRODUCTO LIMPIEZA");
        String[] datos = registrarDatosComunesProducto();
        String nombre = datos[0];
        int numSerie = Integer.parseInt(datos[1]);
        double precio = Double.parseDouble(datos[2]);
        String fechaImp = datos[3];
        int stock = Integer.parseInt(datos[4]);

        System.out.println("Ingrese la marca del producto");
        System.out.print(">> ");
        String marca = sc.nextLine();

        productosLimpieza.add(new Limpieza(nombre, numSerie, precio, fechaImp, stock, marca));
        System.out.println("¡El producto ha sido registrado exitosamente!");
        returnToMainMenu();
    }

    public void registrarProductoAlimento(){
        printHeader("REGISTRAR PRODUCTO ALIMENTO");
        String[] datos = registrarDatosComunesProducto();
        String nombre = datos[0];
        int numSerie = Integer.parseInt(datos[1]);
        double precio = Double.parseDouble(datos[2]);
        String fechaImp = datos[3];
        int stock = Integer.parseInt(datos[4]);

        System.out.println("Ingrese la fecha de caducidad del producto");
        System.out.print(">> ");
        String fechaCad = sc.nextLine();

        productosAlimento.add(new Alimento(nombre, numSerie, precio, fechaImp, stock, fechaCad));
        System.out.println("¡El producto ha sido registrado exitosamente!");
        returnToMainMenu();
    }

    public void registrarProductoElectrodomestico(){
        printHeader("REGISTRAR PRODUCTO ELECTRODOMESTICO");
        String[] datos = registrarDatosComunesProducto();
        String nombre = datos[0];
        int numSerie = Integer.parseInt(datos[1]);
        double precio = Double.parseDouble(datos[2]);
        String fechaImp = datos[3];
        int stock = Integer.parseInt(datos[4]);

        System.out.println("Ingrese el tipo de alimentación que requiere (Baterías, enchufe, etc.)");
        System.out.print(">> ");
        String tipoAlimentacion = sc.nextLine();

        productosElectrodomesticos.add(new Electrodomestico(nombre, numSerie, precio, fechaImp, stock, tipoAlimentacion));
        System.out.println("¡El producto ha sido registrado correctamente!");
        returnToMainMenu();
    }

    public void registrarProductoMaquillaje(){
        printHeader("REGISTRAR PRODUCTO DE MAQUILLAJE");
        String[] datos = registrarDatosComunesProducto();
        String nombre = datos[0];
        int numSerie = Integer.parseInt(datos[1]);
        double precio = Double.parseDouble(datos[2]);
        String fechaImp = datos[3];
        int stock = Integer.parseInt(datos[4]);

        System.out.println("Ingrese el tipo de maquillaje");
        System.out.print(">> ");
        String tipo = sc.nextLine();

        System.out.println("Ingrese el pigmeto del maquillaje");
        System.out.println(">> ");
        String pigmento = sc.nextLine();

        productosMaquillaje.add(new Maquillaje(nombre, numSerie, precio, fechaImp, stock, tipo, pigmento));
        System.out.println("¡El producto ha sido registrado correctamente!");
        returnToMainMenu();
    }

    // Registro de USUARIOS

    public void registrarEmpleado(){
        printHeader("REGISTRAR EMPLEADO");
        String[] datos = registrarDatosComunesPersona();
        String nombre = datos[0];
        String CURP = datos[1];
        String fechaNac = datos[2];

        System.out.println("Ingrese el salario del empleado");
        System.out.print(">> ");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingrese el RFC del empleado");
        System.out.print(">> ");
        int RFC = sc.nextInt();
        sc.nextLine();

        empleados.add(new Empleado(nombre, CURP, fechaNac, salario, RFC));
        System.out.println("¡El empleado ha sido registrado exitosamente!");
        returnToMainMenu();
    }

    public void registrarCliente(){
        printHeader("REGISTRAR CLIENTE");
        String[] datos = registrarDatosComunesPersona();
        String nombre = datos[0];
        String CURP = datos[1];
        String fechaNac = datos[2];

        System.out.println("Ingrese el número de tarjeta bancaria del cliente");
        System.out.print(">> ");
        long numTarjeta = sc.nextLong();
        sc.nextLine();
        
        clientes.add(new Cliente(nombre, CURP, fechaNac, numTarjeta));
        System.out.println("¡El cliente ha sido registrado exitosamente!");
        returnToMainMenu();
    }

    // Muestra de datos

    public void mostrarProductos(){
        printHeader("MOSTRAR PRODUCTOS");

        System.out.println(" * Productos de Limpieza:");
        System.out.println("ID:\tDescripción:");
        for (int i = 0; i < productosLimpieza.size(); i++) {
            System.out.println(productosLimpieza.get(i).getID() + "\t" + productosLimpieza.get(i).getNombre());
        }
        System.out.println();

        System.out.println(" * Alimentos:");
        System.out.println("ID:\tDescripción:");
        for (int i = 0; i < productosAlimento.size(); i++) {
            System.out.println(productosAlimento.get(i).getID() + "\t" + productosAlimento.get(i).getNombre());
        }
        System.out.println();
        
        System.out.println(" * Electrodomesticos:");
        System.out.println("ID:\tDescripción:");
        for (int i = 0; i < productosElectrodomesticos.size(); i++) {
            System.out.println(productosElectrodomesticos.get(i).getID() + "\t" + productosElectrodomesticos.get(i).getNombre());
        }
        System.out.println();

        System.out.println(" * Productos de Maquillaje:");
        System.out.println("ID:\tDescripción:");
        for (int i = 0; i < productosMaquillaje.size(); i++) {
            System.out.println(productosMaquillaje.get(i).getID() + "\t" + productosMaquillaje.get(i).getNombre());
        }
        System.out.println();

        returnToMainMenu();
    }

    public void mostrarClientes(){
        printHeader("MOSTRAR CLIENTES");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("   * " + clientes.get(i).getNombre());
        }
        returnToMainMenu();
    }

    
}
