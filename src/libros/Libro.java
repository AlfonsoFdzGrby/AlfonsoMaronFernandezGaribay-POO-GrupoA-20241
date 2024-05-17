package libros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import sistema.Biblioteca;
import utils.Tools;

public class Libro {

    private static Scanner sc = new Scanner(System.in);

    private static int nextID = 1;
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String fechaPublicacion;
    private Genero genero;
    private Subgenero subgenero;
    private double precio;
    private int stock;

    public Libro(String titulo, String autor, String editorial, LocalDate fechaPublicacion, Genero genero,
            Subgenero subgenero, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion.toString();
        this.genero = genero;
        this.subgenero = subgenero;
        this.precio = precio;
        this.stock = stock;
        this.id = nextID;
        nextID++;
    }

    @Override
    public String toString() {
        return String.format("   * ID: %d\n   * Título: %s\n   * Autor: %s\n   * Editorial: %s\n   * Fecha De Publicación: %s\n   * Género: %s\n   * Subgénero: %s\n   * Precio: %.2f\n   * Stock: %d\n", id, titulo, autor, editorial, fechaPublicacion.toString(), genero.toString(), subgenero.toString(), precio, stock);
    }

    public static Libro buscarLibro(){
        Libro libro = null;
        while (true) {
            boolean found = false;
            System.out.print("Ingrese el ID del libro: ");
            int id = Tools.nextInt();
            for (ArrayList<Libro> books : Biblioteca.libros.values()) {
                for (Libro book : books) {
                    if(book.getId()==id){
                        libro = book;
                        System.out.println(libro.getTitulo() + " de " + libro.getAutor() + " ha sido encontrado!");
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            if(!found){
                System.out.println("El libro especificado no ha sido encontrado");
            }else{
                break;
            }
        }
        return libro;
    }
    
    public static void registrarLibro(){
        Tools.printHeader("REGISTRAR LIBRO");
        System.out.print("Ingrese el título: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese la editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Ingrese la fecha de publicación: ");
        LocalDate fecha = Tools.askForDate();
        Genero genero = null;
        boolean loop = true;
        while(loop){
            System.out.println("Ingrese el género:");
            System.out.println("   * 1. Acción");
            System.out.println("   * 2. Comedia");
            System.out.println("   * 3. Terror");
            System.out.print(">> ");
            int opc = Tools.nextInt();
            switch (opc) {
                case 1 -> {
                    genero = Genero.Acción;
                    loop = false;
                }

                case 2 -> {
                    genero = Genero.Comedia;
                    loop = false;
                }

                case 3 -> {
                    genero = Genero.Terror;
                    loop = false;
                }

                default -> System.out.println("Opción inválida");
            }
        }

        loop = true;
        int opc = 0;

        Subgenero subgenero = null;

        switch (genero) {
            case Acción -> {
                while(loop){
                    System.out.println("Ingrese el subgénero:");
                    System.out.println("   * 1. Thriller");
                    System.out.println("   * 2. Noire");
                    System.out.println("   * 3. Ciencia Ficción");
                    System.out.print(">> ");
                    opc = Tools.nextInt();
                    switch (opc) {
                        case 1 -> {
                            subgenero = Subgenero.Thriller;
                            loop = false;
                        }

                        case 2 -> {
                            subgenero = Subgenero.Noire;
                            loop = false;
                        }

                        case 3 -> {
                            subgenero = Subgenero.CienciaFicción;
                            loop = false;
                        }

                        default -> System.out.println("Opción inválida");
                    }
                }
            }

            case Comedia -> {
                while(loop){
                    System.out.println("Ingrese el subgénero:");
                    System.out.println("   * 1. Sátira");
                    System.out.println("   * 2. Tragicomedia");
                    System.out.println("   * 3. Romántica");
                    System.out.print(">> ");
                    opc = Tools.nextInt();
                    switch (opc) {
                        case 1 -> {
                            subgenero = Subgenero.Sátira;
                            loop = false;
                        }

                        case 2 -> {
                            subgenero = Subgenero.Tragicomedia;
                            loop = false;
                        }

                        case 3 -> {
                            subgenero = Subgenero.Romántica;
                            loop = false;
                        }

                        default -> System.out.println("Opción inválida");
                    }
                }
            }

            case Terror -> {
                while(loop){
                    System.out.println("Ingrese el subgénero:");
                    System.out.println("   * 1. Psicológico");
                    System.out.println("   * 2. Gótico");
                    System.out.println("   * 3. Sobrenatural");
                    System.out.print(">> ");
                    opc = Tools.nextInt();
                    switch (opc) {
                        case 1 -> {
                            subgenero = Subgenero.Psicológico;
                            loop = false;
                        }

                        case 2 -> {
                            subgenero = Subgenero.Gótico;
                            loop = false;
                        }

                        case 3 -> {
                            subgenero = Subgenero.Sobrenatural;
                            loop = false;
                        }

                        default -> System.out.println("Opción inválida");
                    }
                }
            }
        }
        
        System.out.print("Ingrese el precio: ");
        double precio = Tools.nextDouble();
        int stock = 0;
        while(true){
            System.out.print("Ingrese el stock: ");
            stock = Tools.nextInt();
            if(stock<0){
                System.out.println("Inválido");
            }else{
                break;
            }
        }
        
        Libro libro = new Libro(titulo, autor, editorial, fecha, genero, subgenero, precio, stock);
        Biblioteca.libros.get(genero).add(libro);
        System.out.println(libro.getInfoBasica() + " ha sido registrado exitosamente!");
        System.out.println("El ID del libro es " + libro.getId());
        Tools.next();
    }

    public static void eliminarLibro(){
        Libro libro = Libro.buscarLibro();
        System.out.println("¿Está seguro de que quiere eliminar este libro? (s/n)");
        char opc = sc.nextLine().charAt(0);
        if(Tools.AskForYesOrNo(opc)){
            Biblioteca.libros.get(libro.getGenero()).remove(libro);
            System.out.println("El libro ha sido eliminado");
        }else{
            System.out.println("El libro no ha sido eliminado");
        }
        Tools.next();
    }


    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getInfoBasica(){
        return titulo + " de " + autor;
    }

    public int getStock() {
        return stock;
    }

    public Subgenero getSubgenero() {
        return subgenero;
    }
}
