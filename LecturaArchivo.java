/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subversion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Juan Pablo Cahueque 15396
 * @author Enma Lopez 15122
 */
public class LecturaArchivo {
    public static Vector mostrarContenido(String archivo) throws FileNotFoundException, IOException {
        Vector parrafo = new Vector(20,5);
        String linea;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((linea = b.readLine())!=null) {
            parrafo.addElement(linea);
        }
        b.close();
        return parrafo;
    }

}
