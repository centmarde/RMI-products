import java.rmi.RemoteException;

public class Product implements ProductInterface{
	// Attributes of product
	private String name = "ohaha"; //NUMBER 1
	private String description = "kangkong chips";
	private double price = 300.00;

	public Product() throws RemoteException {
       //NUMBER 2
        this.name = "DefaultName";
        this.description = "DefaultDescription";
        this.price = 0.0;
    }

    public Product(String newName, String newDescription, double newPrice) throws RemoteException {
        this.name = newName;
        this.description = newDescription;
        this.price = newPrice;
    }

	public String getName() throws RemoteException{
		return this.name;
	}
	public String getDescription() throws RemoteException{
		return this.description;
	}
	public double getPrice() throws RemoteException{
		return this.price;
	}
	public void changeProductName(String newName) throws RemoteException{
		this.name = newName;
	}

	//NUMBER 3
	public void viewProducts() {
        System.out.println("Product Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Price: $" + this.price);
        System.out.println("-----------------------");
    }
}