import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Client extends Thread{

    @Override
    public void run() {
        try {
            //Scanner scanner = new Scanner(System.in);

            //enviar mensagem
            /*System.out.println("Insira o seu nome: ");
            String nome = scanner.next();*/

            //"yyyy-MM-dd 'at' HH:mm:ss z"
            //SimpleDateFormat formatter = new SimpleDateFormat(data);

            MyRemote service = (MyRemote)
                    Naming.lookup("rmi://127.0.0.1/RemoteHello");

            String data = service.getData();
            System.out.println(data);

        }catch (Exception ex){

            System.out.println("Ocorreu um no client: " + ex);
        }
    }


}
