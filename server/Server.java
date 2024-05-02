import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("Products.xml");

            document.getDocumentElement().normalize();

            NodeList productList = document.getElementsByTagName("Product");
            for (int i = 0; i < productList.getLength(); i++) {
                Node productNode = productList.item(i);

                if (productNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element productElement = (Element) productNode;
                    int productCode = Integer.parseInt(productElement.getAttribute("productCode"));
                    String name = productElement.getAttribute("name");
                    String description = productElement.getAttribute("description");
                    double retailPrice = Double.parseDouble(productElement.getAttribute("retailPrice"));
                    double storePrice = Double.parseDouble(productElement.getAttribute("storePrice"));
                    int quantity = Integer.parseInt(productElement.getAttribute("quantity"));

                   
                    Product product = new Product(productCode, name, description, retailPrice, storePrice, quantity);
                    ProductInterface stub_product = (ProductInterface) UnicastRemoteObject.exportObject(product, 0);
                    Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
                    registry.rebind(name, stub_product);

                    System.out.println(name + " Details:");
                    System.out.println("Product Code: " + productCode);
                    System.out.println("Description: " + description);
                    System.out.println("Retail Price: " + retailPrice);
                    System.out.println("Store Price: " + storePrice);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("-----------------------");
                }
            }

            Cart serve = new Cart();
            CartInterface cart = (CartInterface) UnicastRemoteObject.exportObject(serve, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("cart", cart);

            System.out.println("Exporting and binding of Objects has been completed...");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}
