package utils.JSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sistema.Biblioteca;
import usuarios.utils.Rol;
import utils.JSON.models.UsusariosModel;

public class UsuariosSerializer {
    public static void writeToJSON(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(Biblioteca.usuarios, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void readFromJSON(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson json = new Gson();
            UsusariosModel model = json.fromJson(reader, UsusariosModel.class);
            Biblioteca.usuarios.get(Rol.CLIENTE).addAll(model.getClientes());
            Biblioteca.usuarios.get(Rol.TRABAJADOR).addAll(model.getTrabajadores());
            Biblioteca.usuarios.get(Rol.GERENTE).addAll(model.getGerentes());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
