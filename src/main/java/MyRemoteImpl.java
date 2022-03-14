import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

    private Connection connectDB() throws RemoteException, ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/alunos",
                    "root","");
            return con;
    }

    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says: Hello";
    }

    @Override
    public String myName(String nome) throws RemoteException {
        return "Olá" + nome;
    }

    @Override
    public String nowTime(SimpleDateFormat formatter) throws RemoteException {
        return formatter.format(new Date(System.currentTimeMillis()));
    }

    @Override
    public String getData() throws RemoteException {
        StringBuilder dados = new StringBuilder();

        try {

            Statement statement = connectDB().createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM alunos");

            while(results.next()){
                dados.append("Nome:").append(results.getString("firstname")).append(" ").append(results.getString("lastname"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Ocorreu um erro ao obter os dados: " + ex);
        }

        return dados.toString();
    }
}
