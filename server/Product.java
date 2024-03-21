

public class Product implements ProductInterface {
    
    private int productCode;
    private String name;
    private String description;
    private double retailPrice;
    private double storePrice;
    private int quantity;

    public Product() {
        // number 1: Define initial variables for the products
        this.productCode = 000000;
        this.name = "N/A";
        this.description = "N/A";
        this.retailPrice = 0.0;
        this.storePrice = 0.0;
        this.quantity = 0;
    }
    //number 2: updated product constructor
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
  //number 3 define view prodcut method
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
