import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CartInterface extends Remote{
    public void addProduct(String product) throws RemoteException;
    public String viewAllProductsinCart() throws RemoteException;
}