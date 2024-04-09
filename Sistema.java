import java.util.*;

public class Sistema {
    Scanner sc = new Scanner(System.in);
    private final String contraseña = "Psw/8.";
    Tienda tienda = new Tienda();

    private void printHeader(String header){
        System.out.println("===================================================");
        System.out.println(header);
        System.out.println("===================================================");
    }

    public void ejecutarPrograma(){
        printHeader("BIENVENIDO");
        while(true){
            System.out.println("Por favor ingrese la contraseña: ");
            System.out.print(">> ");
            String intento = sc.nextLine();
            if(intento.equals(contraseña)){
                System.out.println("¡Contraseña correcta!");
                System.out.println("Presione enter para continuar...");
                sc.nextLine();
                ejecutarSistema();
                break;
            }else{
                System.out.println("Contraseña incorrecta");
            }
        }   
    }

    private void ejecutarSistema(){
        int opc = 0, subopc = 0;

        while(opc<11){
            printHeader("SISTEMA");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Mostrar clientes");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Añadir a Stock");
            System.out.println("8. Eliminar del Stock");
            System.out.println("9. Realizar una compra");
            System.out.println("10. Ver compras");
            System.out.println("11. Salir");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    printHeader("REGISTRAR PRODUCTO");
                    System.out.println("Seleccione el producto a registrar:");
                    System.out.println("1. Limpieza");
                    System.out.println("2. Alimento");
                    System.out.println("3. Electrodoméstico");
                    System.out.println("4. Maquillaje");
                    System.out.println("5. Volver al menú principal");
                    System.out.print(">> ");
                    subopc = sc.nextInt();
                    sc.nextLine();

                    switch (subopc) {
                        case 1:
                            tienda.registrarProductoLimpieza();
                            break;

                        case 2:
                            tienda.registrarProductoAlimento();
                            break;

                        case 3:
                            tienda.registrarProductoElectrodomestico();
                            break;

                        case 4:
                            tienda.registrarProductoMaquillaje();
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                case 2:
                    tienda.registrarCliente();
                    break;
            
                case 3:
                    tienda.mostrarProductos();
                    break;
            
                case 4:
                    tienda.mostrarClientes();
                    break;
            
                case 5:
                    //tienda.eliminarProducto();
                    break;
            
                case 6:
                    //tienda.eliminarCliente();
                    break;
            
                case 7:
                    //tienda.añadirStock();
                    break;
            
                case 8:
                    //tienda.quitarStock();
                    break;
            
                case 9:
                    //tienda.realizarCompra();
                    break;
            
                case 10:
                    //tienda.verCompras();
                    break;
            
                default:
                    break;
            }
        }

    }
}