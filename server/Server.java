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
            Cart serve = new Cart();

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

			/* Product Laptop = new Product(321321,"Laptop","Lenovo", 10000.00, 100.00, 10);
			Product MobilePhone = new Product(12223,"Mobile Phone","iPhone", 441.72,22,13);
			Product Charger = new Product(1233,"Charger","Lenovo Charger", 841.55,12.1,12);
			Product powerBank = new Product(3232,"PowerBank","Panasonic", 44.12,120,15);
			Product tablet = new Product(23123,"tablet", "asus", 440.12,45,6); */
			

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

                    // Create Product object using the appropriate constructor
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

			/* ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
			ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
			ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
			ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(powerBank, 0);
			ProductInterface stub_tablet = (ProductInterface) UnicastRemoteObject.exportObject(tablet, 0); */

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
