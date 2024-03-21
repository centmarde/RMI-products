import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;





public class Server{
	public static void main(String[] args){
		try{
			Cart serve = new Cart();
			
			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			System.out.println("Server has been started...");
			//4 insert values
			Product Laptop = new Product(321321,"Laptop","Lenovo", 10000.00, 100.00, 10);
			Product MobilePhone = new Product(12223,"Mobile Phone","iPhone", 441.72,22,13);
			Product Charger = new Product(1233,"Charger","Lenovo Charger", 841.55,12.1,12);
			Product powerBank = new Product(3232,"PowerBank","Panasonic", 44.12,120,15);
			Product tablet = new Product(23123,"tablet", "asus", 440.12,45,6);
			

			ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
			ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
			ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
			ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(powerBank, 0);
			ProductInterface stub_tablet = (ProductInterface) UnicastRemoteObject.exportObject(tablet, 0);
		

			//NUMBER 7
			
			CartInterface cart = (CartInterface) UnicastRemoteObject.exportObject(serve, 0);

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
			registry.rebind("addingItem1", cart);
			registry.rebind("addingItem2", cart);
			//NUMBER 5 & NUMBER 6
			System.out.println("Laptop Details:");
            Laptop.viewProducts();

            System.out.println("Mobile Phone Details:");
            MobilePhone.viewProducts();

            System.out.println("Charger Details:");
            Charger.viewProducts();

            System.out.println("Power Bank Details:");
            powerBank.viewProducts();

            System.out.println("tablet Details:");
            tablet.viewProducts();

			//number 8 registry all product to RMI
			registry.rebind("laptop", stub_laptop);
			registry.rebind("mobilePhone", stub_mobilePhone);
			registry.rebind("charger", stub_charger);
			registry.rebind("powerBank", stub_powerBank);
			registry.rebind("keyboard", stub_tablet);
			

			
			
			System.out.println("Exporting and binding of Objects has been completed...");
		}catch(Exception e){
			System.out.println("Some server error..." + e);
		}
	}
}


// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run