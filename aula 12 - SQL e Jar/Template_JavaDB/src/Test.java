// Imports
import models.*;
import connection.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        // Instância da classe de conexão
        ConnectDB db = new ConnectDB();
        Connection conn = null;

        try {
            // Conectando ao banco de dados
            conn = db.connect();
            System.out.println("Conectado ao banco de dados.");

            // Algorithm

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar a conexão com o banco de dados
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexão com o banco de dados encerrada.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
