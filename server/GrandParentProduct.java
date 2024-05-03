import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class GrandParentProduct {
    protected int productCode;
    protected String name;
    protected String description;
    protected double retailPrice;
    protected double storePrice;
    protected int quantity;

    public GrandParentProduct() {
        this.productCode = -1; // Default product code
        this.name = "N/A";
        this.description = "N/A";
        this.retailPrice = 0.0;
        this.storePrice = 0.0;
        this.quantity = 0;
    }

    public GrandParentProduct(int newProductCode, String newName, String newDescription,
                              double newRetailPrice, double newStorePrice, int newQuantity) {
        this.productCode = newProductCode;
        this.name = newName;
        this.description = newDescription;
        this.retailPrice = newRetailPrice;
        this.storePrice = newStorePrice;
        this.quantity = newQuantity;
    }

    public int getProductCode() {
        return this.productCode;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getStorePrice() {
        return this.storePrice;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public void changeProductName(String newName) {
        this.name = newName;
    }
}
