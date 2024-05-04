
public class Cart implements CartInterface {

    private String addedProduct1;
    private String addedProduct2;

    public Cart() {
        this.addedProduct1 = "none";
        this.addedProduct2 = "none";
    }

    public void addProduct(String product) {
        if (addedProduct1.equals("none")) {
            System.out.println("adding products 1.");
            addedProduct1 = product;
        } else if (addedProduct2.equals("none")) {
            System.out.println("adding products 2.");
            addedProduct2 = product;
        } else {
            System.out.println("Cart is full. Cannot add more products.");
        }
    }

    public String viewAllProductsinCart() {
        StringBuilder products = new StringBuilder("\nAll Products in Cart: ");
        if (!addedProduct1.equals("none")) {
            products.append(addedProduct1).append(", ");
        }
        if (!addedProduct2.equals("none")) {
            products.append(addedProduct2).append(", ");
        }
        return products.length() > 0 ? products.substring(0, products.length() - 2) : "No products in Cart.";
    }
}
