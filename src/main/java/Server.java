import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server extends Thread{

    @Override
    public void run() {
        try {
            LocateRegistry.createRegistry (1099); //repo de objetos
            MyRemote service = new MyRemoteImpl();
            Naming.rebind ("RemoteHello", service );

        }catch (Exception ex){
            System.out.println("Ocorreu um erro: " + ex);
        }
    }

}
