import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	// Lets us define API
	public int getProductCode() throws RemoteException;  
    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public double getRetailPrice() throws RemoteException;  
    public double getStorePrice() throws RemoteException;   
    public void changeProductName(String newName) throws RemoteException; 
    public void ViewAddedProducts() throws RemoteException;  
	public void addProducts() throws RemoteException; 
}

