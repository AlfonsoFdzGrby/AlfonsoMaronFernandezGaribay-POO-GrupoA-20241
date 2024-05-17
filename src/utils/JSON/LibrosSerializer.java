package utils.JSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import libros.Genero;
import sistema.Biblioteca;
import utils.JSON.models.LibrosModel;

public class LibrosSerializer {

    public static void writeToJSON(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(Biblioteca.libros, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void readFromJSON(){
        try {
            //Reader or READ file (file that has been read)
            BufferedReader reader = new BufferedReader(new FileReader("libros.json"));
            Gson json = new Gson();
            LibrosModel model = json.fromJson(reader, LibrosModel.class);
            Biblioteca.libros.get(Genero.Acción).addAll(model.getAcción());
            Biblioteca.libros.get(Genero.Comedia).addAll(model.getComedia());
            Biblioteca.libros.get(Genero.Terror).addAll(model.getTerror());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
