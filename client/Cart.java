public class Cart {
    String AddedProducts; //NUMBER 9 AND NUMBER 11 EXECUTE THE PROGRAM

    public void AddProducts(String productName) {
        if (AddedProducts == null) {
            AddedProducts = productName;
        } else {
            AddedProducts += "\n" + productName;
        }
        System.out.println(productName + " added to the cart.\n");
    }    

    //NUMBER 10

    public void ViewAddedProducts() {
        if (AddedProducts == null || AddedProducts.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Contents:\n" + AddedProducts);
        }
    }

}
