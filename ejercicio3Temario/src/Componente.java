public class Componente {
    private String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
