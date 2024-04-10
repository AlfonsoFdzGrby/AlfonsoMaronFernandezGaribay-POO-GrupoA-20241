package src;

import src.usuarios.Cliente;
import src.usuarios.Gerente;
import src.usuarios.Trabajador;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gerardo", "Nuñez");
        Gerente gerente = new Gerente("Javier", "Torres", "Administrador", 53000, 123456789);
        Trabajador trabajador = new Trabajador("Eduardo", "Martínez", 134679731, 15000);

        System.out.println("\n"+cliente.toString()+"\n");
        System.out.println(gerente.toString()+"\n");
        System.out.println(trabajador.toString()+"\n");
    }
}