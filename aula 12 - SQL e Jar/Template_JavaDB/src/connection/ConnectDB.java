package connection;

// Imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.management.RuntimeErrorException;

public class ConnectDB {
    public Connection connect() throws SQLException{
        String server = "localhost";
        String port = "3306";
        // DATABASE name MODIFY
        String database = "";

        // ACESS data MODIFY
        String user = "";
        String password = "";

        return DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database+"?user="+user+"&password="+password);
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(">> ERRO: Failed to close connection: " + e.getMessage());
            }
        }
    }
}
