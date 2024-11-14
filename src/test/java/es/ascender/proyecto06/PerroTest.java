package es.ascender.proyecto06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Test;

public class PerroTest {
    @Test
    void testComer() throws OperationNotSupportedException {
        Perro perro = new Perro(45.5);
        perro.comer(27.2);
        assertEquals(72.7, perro.getPeso(),0.0001);
    }
}
