import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
public interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;

    public String myName(String nome) throws RemoteException;

    public String nowTime(SimpleDateFormat formatter) throws RemoteException;


    //base de dados
    public String getData() throws RemoteException;
}
