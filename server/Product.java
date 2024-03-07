import java.rmi.RemoteException;

public class Product implements ProductInterface {
    // Attributes of product
    private int productCode;
    private String name;
    private String description;
    private double retailPrice;
    private double storePrice;
    private int quantity;

    public Product() {
        // Default values
        this.productCode = 200134;
        this.name = "DefaultName";
        this.description = "DefaultDescription";
        this.retailPrice = 0.0;
        this.storePrice = 0.0;
        this.quantity = 0;
    }

    public Product(int newProductCode, String newName, String newDescription,
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
    public void ViewAddedProducts() throws RemoteException {
        throw new UnsupportedOperationException("Unimplemented method 'ViewAddedProducts'");
    }

    
    public void addProducts() throws RemoteException {
        throw new UnsupportedOperationException("Unimplemented method 'addProducts'");
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