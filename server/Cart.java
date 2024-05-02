import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {

    private List<String> addedProducts;

    public Cart() {
        this.addedProducts = new ArrayList<>();
    }

    @Override
    public void addProduct(String product) {
        if (addedProducts.size() < 2) {
            addedProducts.add(product);
            System.out.println(product + " added to cart.");
        } else {
            System.out.println("Cart is full. Cannot add more products.");
        }
    }

    @Override
    public String viewAllProductsinCart() {
        if (addedProducts.isEmpty()) {
            return "No products in Cart.";
        } else {
            StringBuilder products = new StringBuilder("\nAll Products in Cart: ");
            for (String product : addedProducts) {
                products.append(product).append(", ");
            }
            return products.substring(0, products.length() - 2); 
        }
    }
}
