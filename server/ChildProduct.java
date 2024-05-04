import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChildProduct extends ParentProduct implements ProductInterface {
    
    public ChildProduct() throws RemoteException {
        super();
    }

    public ChildProduct(int newProductCode, String newName, String newDescription,
                       double newRetailPrice, double newStorePrice, int newQuantity) throws RemoteException {
        super(newProductCode, newName, newDescription, newRetailPrice, newStorePrice, newQuantity);
    }
}
