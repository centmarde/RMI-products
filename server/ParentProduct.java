import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class ParentProduct extends GrandParentProduct {
    public ParentProduct() {
        super();
    }

    public ParentProduct(int newProductCode, String newName, String newDescription,
                         double newRetailPrice, double newStorePrice, int newQuantity) {
        super(newProductCode, newName, newDescription, newRetailPrice, newStorePrice, newQuantity);
    }

    public void changeProductName(String newName) {
        super.changeProductName(newName);
    }

    public void viewProducts() {
        System.out.println("Product Code: " + this.productCode);
        System.out.println("Product Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Retail Price: " + this.retailPrice);
        System.out.println("Store Price: " + this.storePrice);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("-----------------------");
    }
}