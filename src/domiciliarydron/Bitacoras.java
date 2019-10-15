/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domiciliarydron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author yeison aristizabal
 * 
 * 
 * La letra A corresponde a un movimiento hacia adelante.
 * La letra I corresponde a un giro de 90 grados del dron a la izquierda.
 * La letra D corresponde a un giro de 90 grados del dron a la derecha.
 * 
 * Segun este enunciado entiendo que si Leo una Letra A tengo que avanzar un paso
 * Si leo una letra I o D solamente giro pero no avanzo
 * 
 * Los datos que me da al momento de hacer una prueba de escritorio de los ejemplos dados son :
        x  y    	dir
    D=  0, 0  dir E
    D=  0, 0 dir S
    A=  0, -2 dir S
    I=  0, -2 dir E
    A=  -1, -2 dir E
    D=  -1, -2 dir S
 * 
 */
public class Bitacoras {

    /**
     * @author yeison aristizabal
     *
     * @return Entrega las rutas realizadas por el dron
     * @date 08 marzo 2018 10:46
     * @param ruta Este metodo es para leer archivos Se hace uso del codigo
     * http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     * 
     * Estos parametros se usan para identificar la direccion y el valor en el plano cartesiano
     * N = Norte 
     * S = Sur
     * E = Oriente
     * W = Occidente
     * 
     * N = y++
     * S = y--
     * E = x++
     * W = x--
     * 
     */
    public List<Dron> leerArchivoRuta(String ruta) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).

            String path = new java.io.File(".").getCanonicalPath();
            System.out.println(path);

            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            List<Dron> listaMonitoreoDron = new ArrayList<>();
            String linea;
            Dron dron = new Dron(0, 0, 'N');
            while ((linea = br.readLine()) != null) {
                char[] lineaConvertidaArray;
                lineaConvertidaArray = linea.toCharArray();
                
                for (int k = 0; k < lineaConvertidaArray.length; k++) {
                    if (lineaConvertidaArray[k] == 'A') {
                        dron = avanzar(dron);
                    } else {
                        if (lineaConvertidaArray[k] == 'I') {
                            switch (dron.getDireccion()) {
                                case 'N':
                                    dron=rotar(dron, 'W');
                                    break;
                                case 'S':
                                    dron=rotar(dron, 'E');
                                    break;
                                case 'W':
                                    dron=rotar(dron, 'S');
                                    break;
                                case 'E':
                                    dron=rotar(dron, 'N');
                                    break;
                            }
                        }else if (lineaConvertidaArray[k] == 'D') {
                            switch (dron.getDireccion()) {
                                case 'N':
                                    dron=rotar(dron, 'E');
                                    break;
                                case 'S':
                                    dron=rotar(dron, 'W');
                                    break;
                                case 'W':
                                    dron=rotar(dron, 'N');
                                    break;
                                case 'E':
                                    dron=rotar(dron, 'S');
                                    break;
                            }
                        }
                    }
                }
                System.out.println("("+dron.getPosicionX()+ ", " + dron.getPosicionY()+ ") "+ dron.getDireccion() );
                Dron lDron= new Dron(dron.getPosicionY(), dron.getPosicionX(), dron.getDireccion());
                listaMonitoreoDron.add(lDron);
            }
            return listaMonitoreoDron;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
    
    /**
     * @author yeison aristizabal
     * @param dron
     * @return Avanzar hacia la direccion correcta
     * 
     * Estos parametros se usan para identificar la direccion y el valor en el plano cartesiano
     * N = Norte 
     * S = Sur
     * E = Oriente
     * W = Occidente
     * 
     * N = y++
     * S = y--
     * E = x++
     * W = x--
     */
    public Dron avanzar(Dron dron) {
        switch (dron.getDireccion()) {
            case 'N':
                dron.setPosicionY(dron.getPosicionY() + 1);
                break;
            case 'S':
                dron.setPosicionY(dron.getPosicionY() - 1);
                break;
            case 'E':
                dron.setPosicionX(dron.getPosicionX() + 1);
                break;
            case 'W':
                dron.setPosicionX(dron.getPosicionX() - 1);
                break;
        }
        return dron;
    }
    
    /**
     * 
     * @author yeison aristizabal
     * @param dron
     * @param direccion pueden ser  N, S, E y W
     * @return Almacenar la nueva direccion que va a tener el dron
     * 
     * Estos parametros se usan para identificar la direccion y el valor en el plano cartesiano
     * N = Norte 
     * S = Sur
     * E = Oriente
     * W = Occidente
     * 
     * N = y++
     * S = y--
     * E = x++
     * W = x--
     */
    public Dron rotar(Dron dron, char direccion) {
        dron.setDireccion(direccion);
        return dron;
    }

    /**
     * yeison aristizabal
     *
     * @param lineaConvertidaArray
     *
     */
    private void almacenarBitacorasDeRutas(List<Dron> listaMonitoreoDron) {
        for (Dron lista : listaMonitoreoDron) {
            System.out.println(lista.getPosicionX() + "..." + lista.getPosicionY() + "..." + lista.getDireccion());
        }
    }
    
    public void escribirfichero(String mfichero,List<Dron> lista) throws IOException{
        String sFichero = mfichero ;
        File fichero = new File(mfichero);
        PrintWriter bw = new PrintWriter(new FileWriter(sFichero,true));
        bw.println("== Reporte de entregas =="); 

        for( int i=0; i<lista.size();i++){
            Dron mDron=lista.get(i);
            String row = "("+mDron.getPosicionX() +"," +mDron.getPosicionY() +") "+ mDron.getDireccion();
            bw.println(row);
            
        }
        bw.close();
    }
    
    /*
    private void retorno(Dron dron){
        if(dron.getPosicionY()> 0 ) {
            mover()
        
        }
    }*/
    
}
