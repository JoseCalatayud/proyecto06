package es.ascender.proyecto06;

public class Perro {

    private double peso;
    private String id;

    public Perro(double peso) {
        this.peso = peso;
    }
    

    public Perro(String id, double peso) {
        this.id = id;
        this.peso = peso;
    }


    public void comer(double pesoComida) {
        this.peso += pesoComida;

    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Perro other = (Perro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Perro [peso=" + peso + ", id=" + id + "]";
    }
    

}
