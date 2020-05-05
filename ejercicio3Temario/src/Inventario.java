import java.util.HashMap;
import java.util.Iterator;

public class Inventario {
    private HashMap<Componente, Integer> inventario;

    public Inventario(HashMap<Componente, Integer> inventario) {
        this.inventario = inventario;
    }

    public HashMap<Componente, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(HashMap<Componente, Integer> inventario) {
        this.inventario = inventario;
    }

    /*
        50, 40, 6, 1

        c12 --> 10
        c20 --> 20
        c11 --> 30
        c50 --> 6
      */
    private boolean sePuedeFabricar(Producto producto) {
        boolean sePuedeFabricar = true;
        Iterator<Componente> it = producto.getComponentesCantidad().keySet().iterator();

        while (it.hasNext() && sePuedeFabricar == true) {
            Componente claveComponente = it.next();
            Integer cantidadNecesaria = producto.getComponentesCantidad().get(claveComponente);
            Integer cantidadDisponible = inventario.get(claveComponente);

            if (cantidadNecesaria > cantidadDisponible) {
                sePuedeFabricar = false;
            }
        }
        return sePuedeFabricar;
    }
    private void stockBajo(Producto producto){
        for(Componente claveComponente : producto.getComponentesCantidad().keySet()){
            Integer cantidadNecesaria = producto.getComponentesCantidad().get(claveComponente);
            Integer cantidadDisponible = inventario.get(claveComponente);

            if ((cantidadNecesaria*10)> cantidadDisponible) {
                System.out.println("hace falta stockaje de "+ claveComponente );

            }

        }

    }

    public void fabricarProducto(Producto producto) {
        if (sePuedeFabricar(producto) == true) {
            for (Componente claveComponente : producto.getComponentesCantidad().keySet()) {
                Integer cantidadNecesaria = producto.getComponentesCantidad().get(claveComponente);
                Integer cantidadDisponible = inventario.get(claveComponente);

                if (cantidadNecesaria <= cantidadDisponible) {
                    Integer nuevaCantidad = cantidadDisponible - cantidadNecesaria;
                    inventario.put(claveComponente, nuevaCantidad);
                }

            }
            stockBajo(producto);
        }
    }
}
