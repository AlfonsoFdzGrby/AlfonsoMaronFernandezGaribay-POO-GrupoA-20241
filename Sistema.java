import java.util.*;

public class Sistema {
    Scanner sc = new Scanner(System.in);
    private final String contraseña = "Psw/8.";
    Tienda tienda = new Tienda();

    public void ejecutarPrograma(){
        printHeader("BIENVENIDO");
        while(true){
            System.out.println("Por favor ingrese la contraseña: ");
            System.out.print(">> ");
            String intento = sc.nextLine();
            if(intento.equals(contraseña)){
                System.out.println("¡Contraseña correcta!");
                System.out.print("Presione enter para continuar...");
                sc.nextLine();
                ejecutarSistema();
                break;
            }else{
                System.out.println("Contraseña incorrecta");
            }
        }   
    }

    private void ejecutarSistema(){
        tienda.addCliente(new Cliente("Jorge", "CURP" , "25/03/03" , 123456789));
        tienda.addLimp(new Limpieza("Lysol", 1534, 15.32, "25/03/23", 15, "Lysol"));
        int opc = 0;

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
                    tienda.registrarProducto();
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
                    tienda.eliminarProducto();
                    break;
            
                case 6:
                    tienda.eliminarCliente();
                    break;
            
                case 7:
                    tienda.añadirStock();
                    break;
            
                case 8:
                    tienda.quitarStock();
                    break;
            
                case 9:
                    tienda.realizarCompra();
                    break;
            
                case 10:
                    tienda.verCompras();
                    break;
            
                default:
                    break;
            }
        }
    }
    
    private void printHeader(String header){
        System.out.println("===================================================");
        System.out.println(header);
        System.out.println("===================================================");
    }
}