package es.ascender.proyecto06;

import java.util.List;
import java.util.Objects;

public class ComparaLista {

    public boolean comparar(List<Perro> lista1, List<Perro> lista2) {
        if (lista1 == null && lista2 == null) {
            return true;

        }
        if (lista1 == null || lista2 == null) {
            return false;
        }

        if (lista1.size() != lista2.size()) {
            return false;
        }
        for (int i = 0; i < lista1.size(); i++) {
            //Esto evita que si algun indice tiene valor null salte un NullPointerException
            if (!Objects.equals(lista1.get(i), lista2.get(i))) {
                return false;
            }
        }
        return true;
    }

}
