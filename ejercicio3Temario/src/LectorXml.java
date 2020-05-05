import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorXml {

    private Document abrirFicheroXml(String nombreFichero) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        Document doc = null;
        try {
            File inputFile = new File(dir + File.separator + "src" + File.separator + nombreFichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
		/*
		    Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
		*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    //tiene que devolver algo
    public HashMap<Componente, Integer> parsearInventario(String nombreFichero) {
        HashMap<Componente, Integer> inventario = new HashMap<>();

        Document doc = abrirFicheroXml(nombreFichero);
        NodeList raiz = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < raiz.getLength(); i++) {
            Node nodo = raiz.item(i);
            if (raiz.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) raiz.item(i);
                if (elemento.getNodeName().contains("componente")) {
                    String id = elemento.getAttribute("id");
                    Integer existencias = Integer.parseInt(elemento.getAttribute("existencias"));

                    Componente nuevoComponente = new Componente(id);
                    inventario.put(nuevoComponente, existencias);
                }
            }
        }

        return inventario;
    }

    public ArrayList<Producto> parsearProductos(String nombreFichero) {
        ArrayList<Producto> productos = new ArrayList<>();
        Document doc = abrirFicheroXml(nombreFichero);
        NodeList raiz = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < raiz.getLength(); i++) {
            if (raiz.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) raiz.item(i);
                if (elemento.getNodeName().contains("producto")) {
                    String id_producto = elemento.getAttribute("id_producto");
                   NodeList componentes = elemento.getChildNodes();
                    HashMap<Componente, Integer> componentesProducto = new HashMap<>();
                    for (int j = 0; j < componentes.getLength(); j++) {
                        if (componentes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element nodoComponente = (Element) componentes.item(j);
                            if (nodoComponente.getNodeName().contains("componente")) {
                                String id = nodoComponente.getAttribute("id");
                                Integer cantidad = Integer.parseInt(nodoComponente.getAttribute("cantidad"));
                                Componente nuevoComponente = new Componente(id);
                                componentesProducto.put(nuevoComponente, cantidad);
                            }
                        }
                    }

                    Producto nuevoProducto=new Producto(id_producto,componentesProducto);
                    productos.add(nuevoProducto);

                }
            }

        }
        return productos;
    }
}
