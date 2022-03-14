import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teste {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/alunos",
                "root","");
    }

}
