import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Get the references of exported objects from the RMI Registry...
            ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
            ProductInterface p5 = (ProductInterface) registry.lookup("keyboard");

            CartInterface item1 = (CartInterface) registry.lookup("addingItem1");

            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("\n1. View Products");
                System.out.println("2. Add Product");
                System.out.println("3. View All Products in Cart");  
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                //switch case revise this code IMPORTANT
                switch (choice) {
                    case 1:
                        // View Products
                        System.out.println("\nThe product name is: " + p1.getName() + ", The price is: " + p1.getRetailPrice());
                        System.out.println("The product name is: " + p2.getName() + ", The price is: " + p2.getRetailPrice());
                        System.out.println("The product name is: " + p3.getName() + ", The price is: " + p3.getRetailPrice());
                        System.out.println("The product name is: " + p4.getName() + ", The price is: " + p4.getRetailPrice());
                        System.out.println("The product name is: " + p5.getName() + ", The price is: " + p5.getRetailPrice());
                        break;

                    case 2:
                    System.out.println("Available devices: Laptop, MobilePhone, Charger, PowerBank, Tablet.");
                    System.out.println("Limit items 2 only");
                    System.out.print("Enter the product name to add: ");
                    String productName = scanner.next();
                                                        //number 11 direa mahitabo ang pag add sa product gkan sa user
                    switch (productName.toLowerCase()) {
                        case "laptop":
                        case "mobilephone":
                        case "charger":
                        case "powerbank":
                        case "tablet":
                            item1.addProduct(productName); //number 12 duha ra ang ma add kay mao ra akoa gebutang
                            break;
                        default:
                            System.out.println("Invalid input. Available devices: Laptop, Mobile Phone, Charger, PowerBank, Tablet.");
                            break;
                    }
                    break;
                    case 3:
                        // View All Products in Cart
                        System.out.println("\n"+ item1.viewAllProductsinCart()); //number 13
                        break;

                    case 4:
                        // Exit
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 4);

            scanner.close();

        } catch (RemoteException re) {
            System.out.println("RMI communication error: " + re);
        } catch (NotBoundException nbe) {
            System.out.println("Object not bound in RMI Registry: " + nbe);
        } catch (Exception e) {
            System.out.println("Client side error: " + e);
        }
    }
}
