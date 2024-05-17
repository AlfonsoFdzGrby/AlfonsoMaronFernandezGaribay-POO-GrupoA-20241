package utils.JSON.models;

import java.util.ArrayList;

import libros.Libro;

public class LibrosModel {
    private ArrayList<Libro> Acción;
    private ArrayList<Libro> Comedia;
    private ArrayList<Libro> Terror;

    public ArrayList<Libro> getAcción() {
        return Acción;
    }
    public ArrayList<Libro> getComedia() {
        return Comedia;
    }
    public ArrayList<Libro> getTerror() {
        return Terror;
    }
}