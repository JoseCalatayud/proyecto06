package es.ascender.proyecto06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FicheroJuanTest {
    FicheroJuan cut = new FicheroParaTesting();
    @BeforeAll  //inicializacion que se hace antes de comenzar los test. Pero solo se realiza una vez al principio
    //es raro su uso. El metodo de inicializacion que lo acompaña debe ser estatico. Habitualmente se utiliza el @BeforeEach que es que se realiza la inicializacion antes de cada test.
    //@BeforeEach
    public static void setUp(){
        System.out.println("eSTOY EN EL @BeforeAll");
    }
    /*@BeforeEach
    public void setup(){
        System.out.println("Ahora estoy en el @BeforeEach");
        cut = new FicheroParaTesting();

        //ejemplo de clase interna creada mas abajo
        FicheroJuan noHagoNada = new FicheroParaTestingDos();

        //Crear una clase sin nombre. Actualmente se sustituye por las LAMBDAS
        FicheroJuan niNombre = new FicheroJuan() {

            @Override
            public void hacerElLunes() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'hacerElLunes'");
            }
            
        };

    }*/

    @Test
    void testEscribir() {
        System.out.println("Test escribir");
        try {

            //Preparar
            File ficheroTemporalACrear = File.createTempFile("Hola", ".juan");
            String ruta = ficheroTemporalACrear.getAbsolutePath();
            ficheroTemporalACrear.delete();
            byte[] datosAEscribir =new byte[4096];
            assertFalse(ficheroTemporalACrear.exists(), "El fichero existe");

            //Ejecutar
            cut.escribir(ruta, datosAEscribir);

            //Verificar
            assertTrue (ficheroTemporalACrear.length()== 4096);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    void testLeer() {
        System.out.println("Estoy en el testLeer");
    }

    @Test
    void testLeerEnBloques() throws IOException {
        byte [] leido = cut.leerEnBloques("./src/test/resources/jose.txt");
        assertArrayEquals("adios".getBytes(), leido);
    }
    @Test
    void testEncoding (){
        String cadena1 = "Hola";
        String cadena2 = "Hola";
        
        byte [] bytes1 = "hola".getBytes(Charset.forName("UTF-8"));
        byte [] bytes2 = "hola".getBytes(Charset.forName("ISO-8859-1"));

        assertArrayEquals(bytes1, bytes2);


    }


    //Ejemplo de clase interna (Clase dentro de otra clase)
    public class FicheroParaTestingDos extends FicheroJuan {

        @Override
        public void hacerElLunes() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hacerElLunes'");
        }

    }
}
