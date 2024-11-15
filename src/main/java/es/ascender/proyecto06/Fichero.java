package es.ascender.proyecto06;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fichero {

    public byte [] leer (String nombreFichero) throws IOException{
        int valor;
        //fis me permite leer el fichero byte a byte
        try (FileInputStream fis = new FileInputStream(nombreFichero)) {
            //escribir en memoria byte a byte
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            //fis.read() me lee los bytes del fichero hasta (con el while) que no 
                //hay mas que leer y devuelve un -1
            while ((valor = fis.read()) != -1) {
                //con baos escribo en memoria 
                baos.write(valor);
            }

            return baos.toByteArray();
        }
    }

    //Version diferente
    public byte [] leerEnBloques (String nombreFichero) throws IOException{
        int cuantos;
        byte [] valores = new byte[4096];
        try (FileInputStream fis = new FileInputStream(nombreFichero)) {
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            //fis.read(valores) lee en bloques de una cantidad de bytes. 
            //En este caso hemos elegido hasta 4096 pq es una medida comun de tamaño de sector en disco
            //si son menos tb los lee
            while ((cuantos = fis.read(valores)) != -1) {
                //con baos escribo en memoria 
                baos.write(valores, 0, cuantos);;
            }

            return baos.toByteArray();
        }
    }

    public void escribirFichero (String nombreFichero, byte [] datos) throws IOException{
        FileOutputStream fos = new FileOutputStream(nombreFichero);
        fos.write(datos);
        fos.close();
    }

}
