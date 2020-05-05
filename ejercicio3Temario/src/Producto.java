import java.util.HashMap;

public class Producto {
    private String nombre;
    private HashMap<Componente,Integer> componentesCantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<Componente, Integer> getComponentesCantidad() {
        return componentesCantidad;
    }

    public void setComponentesCantidad(HashMap<Componente, Integer> componentesCantidad) {
        this.componentesCantidad = componentesCantidad;
    }

    public Producto(String nombre, HashMap<Componente, Integer> componentesCantidad) {
        this.nombre = nombre;
        this.componentesCantidad = componentesCantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", componentesCantidad=" + componentesCantidad +
                '}' + "\n";
    }
}
