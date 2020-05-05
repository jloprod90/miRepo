import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LectorXml lector=new LectorXml();

        HashMap<Componente, Integer> componentesInventario = lector.parsearInventario("inventario.xml");
        Inventario inventario = new Inventario(componentesInventario);

        ArrayList<Producto> productos=lector.parsearProductos("productos.xml");
        System.out.println("los productos son:"+productos);

        System.out.println("el primer producto es "+ productos.get(0));

    }
}
