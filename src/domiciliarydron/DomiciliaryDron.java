/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domiciliarydron;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMER 104
 */
public class DomiciliaryDron {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String path = new File(".").getCanonicalPath();
        Bitacoras bitacora = new Bitacoras();
        List<Dron> listaDron = bitacora.leerArchivoRuta(path +"\\src\\documents\\ruta.txt");
        bitacora.escribirfichero(path+"\\src\\documents\\in.txt",listaDron);
    }
}
