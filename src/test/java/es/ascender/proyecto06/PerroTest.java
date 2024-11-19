package es.ascender.proyecto06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Test;

public class PerroTest {
    @Test
    void testComer() throws OperationNotSupportedException {
        Perro perro = new Perro(45.5);
        perro.comer(27.2);
        assertEquals(72.7, perro.getPeso(),0.0001);
    }
    @Test
    void mismoPerroTest(){
        Perro caniche = new Perro("1", 3.5);
        Perro doberman = new Perro("2",14);

        assertFalse(caniche == doberman);
        assertTrue(Objects.equals(caniche, doberman));
        assertTrue(caniche.equals(doberman));
    }
}
