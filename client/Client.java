import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{
	public static void main(String[] args){
		try{
			// Get the references of exported object from RMI Registry...

			//locate the registry.
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			// Get the references of exported object from the RMI Registry...
			ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
			ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
			ProductInterface p3 = (ProductInterface) registry.lookup("charger");
			ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
			ProductInterface p5 = (ProductInterface) registry.lookup("keyboard");
			//NUMBER 7

			System.out.println( "The product name is: " + p1.getName() + ",  The price is: " + p1.getPrice());
			System.out.println( "The product name is: " + p2.getName() + ",  The price is: " + p2.getPrice());
			System.out.println( "The product name is: " + p3.getName() + ",  The price is: " + p3.getPrice());
			System.out.println( "The product name is: " + p4.getName() + ",  The price is: " + p4.getPrice());
			System.out.println( "The product name is: " + p5.getName() + ",  The price is: " + p5.getPrice());
			//NUMBER 12


            Cart cart = new Cart();
			cart.AddProducts(p1.getName());
			cart.AddProducts(p2.getName());
			//NUMBER 13

			cart.ViewAddedProducts();
			//NUMBER 14

		}catch(Exception e){
			System.out.println("Client side error..." + e);
		}
	}
}