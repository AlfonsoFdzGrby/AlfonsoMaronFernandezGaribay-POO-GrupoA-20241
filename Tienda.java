import java.util.*;

public class Tienda {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<>();
    private ArrayList<Maquillaje> productosMaquillaje = new ArrayList<>();
    private ArrayList<Electrodomestico> productosElectrodomesticos = new ArrayList<>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();


    // MÉTODOS PÚBLICOS

    public void registrarProducto(){
        printHeader("REGISTRAR PRODUCTO");
        int opc = seleccionDeProducto();

        switch (opc) {
            case 1:
                registrarProductoLimpieza();
                break;

            case 2:
                registrarProductoAlimento();
                break;

            case 3:
                registrarProductoElectrodomestico();
                break;

            case 4:
                registrarProductoMaquillaje();
                break;
        
            default:
                break;
        }
    }

    public void eliminarProducto(){
        printHeader("ELIMINAR PRODUCTO");
        int opc = seleccionDeProducto();

        switch (opc) {
            case 1:
                eliminarProductoLimpieza();
                break;

            case 2:
                eliminarProductoAlimento();
                break;

            case 3:
                eliminarProductoElectrodomestico();
                break;

            case 4:
                eliminarProductoMaquillaje();
                break;
        
            default:
                break;
        }
    }

    // Registro de personas

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

    public void eliminarCliente(){
        printHeader("ELIMINAR CLIENTE");

        Cliente cliente = buscarCliente();

        System.out.println("¿Está seguro de que quiere eliminar a este cliente? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        boolean respuesta = decidirSiONo(opc);

        if(respuesta){
            clientes.remove(cliente);
            System.out.println("El cliente ha sido eliminado exitosamente");
        }else{
            System.out.println("El cliente no ha sido eliminado");
        }
        returnToMainMenu();
    }

    public void añadirStock(){
        printHeader("AÑADIR STOCK");
        int opc = seleccionDeProducto();
        switch (opc) {
            case 1:
                añadirStockLimpieza();
                break;
        
            case 2:
                añadirStockAlimento();
                break;
        
            case 3:
                añadirStockElectrodomestico();
                break;
        
            case 4:
                añadirStockMaquillaje();
                break;
        
            default:
                break;
        }
    }

    // MÉTODOS PRIVADOS

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

    private int seleccionDeProducto(){
        System.out.println("Seleccione el tipo producto:");
        System.out.println("1. Limpieza");
        System.out.println("2. Alimento");
        System.out.println("3. Electrodoméstico");
        System.out.println("4. Maquillaje");
        System.out.println("5. Volver al menú principal");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();
        return opc;
    }

    private boolean decidirSiONo(char opc){
        boolean respuesta = false;

        switch (Character.toLowerCase(opc)) {
            case 'y':
            case 's':
                respuesta = true;
                break;
        
            default:
                break;
        }

        return respuesta;
    }

    private Limpieza buscarProductoLimpieza(boolean modificar){
        int id;
        Limpieza producto = null;
        while(true){
            System.out.println("Por favor ingrese el ID del producto");
            System.out.print(">> ");
            id = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < productosLimpieza.size(); i++) {
                if(productosLimpieza.get(i).getID() == id){
                    producto = productosLimpieza.get(i);
                    System.out.println("¡El producto " + producto.getNombre() + " ha sido encontrado!");
                    if(modificar){
                        productosLimpieza.remove(i);
                    }
                    break;
                }
            }
            if(producto==null){
                System.out.println("El producto no fue encontrado. Por favor ingrese un ID correcto");
            }else{
                break;
            }
        }
        return producto;
    }

    private Alimento buscarProductoAlimento(boolean modificar){
        int id;
        Alimento producto = null;
        while(true){
            System.out.println("Por favor ingrese el ID del producto");
            System.out.print(">> ");
            id = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < productosAlimento.size(); i++) {
                if(productosAlimento.get(i).getID() == id){
                    producto = productosAlimento.get(i);
                    System.out.println("¡El producto " + producto.getNombre() + " ha sido encontrado!");
                    if(modificar){
                        productosAlimento.remove(i);
                    }
                    break;
                }
            }
            if(producto==null){
                System.out.println("El producto no fue encontrado. Por favor ingrese un ID correcto");
            }else{
                break;
            }
        }
        return producto;
    }

    private Electrodomestico buscarProductoElectrodomestico(boolean modificar){
        int id;
        Electrodomestico producto = null;
        while(true){
            System.out.println("Por favor ingrese el ID del producto");
            System.out.print(">> ");
            id = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < productosElectrodomesticos.size(); i++) {
                if(productosElectrodomesticos.get(i).getID() == id){
                    producto = productosElectrodomesticos.get(i);
                    System.out.println("¡El producto " + producto.getNombre() + " ha sido encontrado!");
                    if(modificar){
                        productosElectrodomesticos.remove(i);
                    }
                    break;
                }
            }
            if(producto==null){
                System.out.println("El producto no fue encontrado. Por favor ingrese un ID correcto");
            }else{
                break;
            }
        }
        return producto;
    }

    private Maquillaje buscarProductoMaquillaje(boolean modificar){
        int id;
        Maquillaje producto = null;
        while(true){
            System.out.println("Por favor ingrese el ID del producto");
            System.out.print(">> ");
            id = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < productosMaquillaje.size(); i++) {
                if(productosMaquillaje.get(i).getID() == id){
                    producto = productosMaquillaje.get(i);
                    System.out.println("¡El producto " + producto.getNombre() + " ha sido encontrado!");
                    if(modificar){
                        productosMaquillaje.remove(i);
                    }
                    break;
                }
            }
            if(producto==null){
                System.out.println("El producto no fue encontrado. Por favor ingrese un ID correcto");
            }else{
                break;
            }
        }
        return producto;
    }

    private Cliente buscarCliente(){
        Cliente cliente = null;
        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del cliente");
            System.out.print(">> ");
            nombre = sc.nextLine();
            for (int i = 0; i < clientes.size(); i++) {
                if(nombre.equalsIgnoreCase(clientes.get(i).getNombre())){
                    cliente = clientes.get(i);
                    System.out.println("¡El cliente ha sido encontrado!");
                    break;
                }
            }
            if(cliente == null){
                System.out.println("El cliente no ha sido encontrado. Por favor ingrese un nombre válido");
            }else{
                break;
            }
        }

        return cliente;
    }

    // Registro de PRODUCTOS

    private void registrarProductoLimpieza(){
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

    private void registrarProductoAlimento(){
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

    private void registrarProductoElectrodomestico(){
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

    private void registrarProductoMaquillaje(){
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

    private void añadirStockLimpieza(){
        Limpieza producto = buscarProductoLimpieza(true);
        System.out.println("STOCK DE " + producto.getNombre() + ": " + producto.getStock());
        while (true) {
            System.out.println("Ingrese la cantidad de stock a añadir");
            System.out.print(">> ");
            int stock = sc.nextInt();
            sc.nextLine();
            boolean agregarStock = producto.agregarStock(stock);
            if(!agregarStock){
                System.out.println("El stock ingresado no es válido. Ingrese una cantidad válida");
            }else{
                System.out.println("¡" + stock + " unidades de " + producto.getNombre() + " han sido agregadas exitosamente!");
                break;
            }
        }
        productosLimpieza.add(producto);
        returnToMainMenu();
    }

    private void añadirStockAlimento(){
        Alimento producto = buscarProductoAlimento(true);
        System.out.println("STOCK DE " + producto.getNombre() + ": " + producto.getStock());
        while (true) {
            System.out.println("Ingrese la cantidad de stock a añadir");
            System.out.print(">> ");
            int stock = sc.nextInt();
            sc.nextLine();
            boolean agregarStock = producto.agregarStock(stock);
            if(!agregarStock){
                System.out.println("El stock ingresado no es válido. Ingrese una cantidad válida");
            }else{
                System.out.println("¡" + stock + " unidades de " + producto.getNombre() + " han sido agregadas exitosamente!");
                break;
            }
        }
        productosAlimento.add(producto);
        returnToMainMenu();
    }

    private void añadirStockElectrodomestico(){
        Electrodomestico producto = buscarProductoElectrodomestico(true);
        System.out.println("STOCK DE " + producto.getNombre() + ": " + producto.getStock());
        while (true) {
            System.out.println("Ingrese la cantidad de stock a añadir");
            System.out.print(">> ");
            int stock = sc.nextInt();
            sc.nextLine();
            boolean agregarStock = producto.agregarStock(stock);
            if(!agregarStock){
                System.out.println("El stock ingresado no es válido. Ingrese una cantidad válida");
            }else{
                System.out.println("¡" + stock + " unidades de " + producto.getNombre() + " han sido agregadas exitosamente!");
                break;
            }
        }
        productosElectrodomesticos.add(producto);
        returnToMainMenu();
    }

    private void añadirStockMaquillaje(){
        Maquillaje producto = buscarProductoMaquillaje(true);
        System.out.println("STOCK DE " + producto.getNombre() + ": " + producto.getStock());
        while (true) {
            System.out.println("Ingrese la cantidad de stock a añadir");
            System.out.print(">> ");
            int stock = sc.nextInt();
            sc.nextLine();
            boolean agregarStock = producto.agregarStock(stock);
            if(!agregarStock){
                System.out.println("El stock ingresado no es válido. Ingrese una cantidad válida");
            }else{
                System.out.println("¡" + stock + " unidades de " + producto.getNombre() + " han sido agregadas exitosamente!");
                break;
            }
        }
        returnToMainMenu();
        productosMaquillaje.add(producto);
    }

    // Eliminación de PRODUCTOS

    
    private void eliminarProductoLimpieza(){
        printHeader("ELIMINAR PRODUCTO DE LIMPIEZA");

        Limpieza producto = buscarProductoLimpieza(false);

        System.out.println("¿Está seguro de que quiere eliminar este producto? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        boolean respuesta = decidirSiONo(opc);

        if(respuesta){
            productosLimpieza.remove(producto);
            System.out.println("El producto ha sido eliminado exitosamente");
        }else{
            System.out.println("El producto no ha sido eliminado");
        }
        returnToMainMenu();
    }

    private void eliminarProductoAlimento(){
        printHeader("ELIMINAR ALIMENTO");
        
        Alimento producto = buscarProductoAlimento(false);

        System.out.println("¿Está seguro de que quiere eliminar este producto? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        boolean respuesta = decidirSiONo(opc);

        if(respuesta){
            productosAlimento.remove(producto);
            System.out.println("El producto ha sido eliminado exitosamente");
        }else{
            System.out.println("El producto no ha sido eliminado");
        }

        returnToMainMenu();
    }

    private void eliminarProductoElectrodomestico(){
        printHeader("ELIMINAR PRODUCTO ELECTRODOMÉSTICO");

        Electrodomestico producto = buscarProductoElectrodomestico(false);

        System.out.println("¿Está seguro de que quiere eliminar este producto? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        boolean respuesta = decidirSiONo(opc);

        if(respuesta){
            productosElectrodomesticos.remove(producto);
            System.out.println("El producto ha sido eliminado exitosamente");
        }else{
            System.out.println("El producto no ha sido eliminado");
        }

        returnToMainMenu();
    }

    private void eliminarProductoMaquillaje(){
        printHeader("ELIMINAR PRODUCTO DE MAQUILLAJE");

        Maquillaje producto = buscarProductoMaquillaje(false);

        System.out.println("¿Está seguro de que quiere eliminar este producto? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        boolean respuesta = decidirSiONo(opc);

        if(respuesta){
            productosMaquillaje.remove(producto);
            System.out.println("El producto ha sido eliminado exitosamente");
        }else{
            System.out.println("El producto no ha sido eliminado");
        }

        returnToMainMenu();
    }

}