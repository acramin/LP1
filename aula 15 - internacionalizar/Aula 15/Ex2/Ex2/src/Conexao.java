
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;

public  class Conexao{   
    
    private static final String URL  =   "jdbc:mysql://localhost:3306/logins";
    private static final String USER =   "loginSenha";
    private static final String PASS =   "1234";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ERROBD = "Erro na conexão com o Banco de Dados: "; 

    public static Connection getConn(){
        try
        {   Class.forName(DRIVER); //conecta o java com o banco de dados (carrega o driver de conexão)
            return DriverManager.getConnection(URL, USER, PASS); //"pega" a conexão com o banco de dados
        }
        catch(ClassNotFoundException | SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }

    public static void closeConn(Connection conn) {   
        try
        {   if(conn != null) 
            {   conn.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    public static void closeConn(Connection conn, PreparedStatement stmt) {   
        closeConn(conn);
        try
        {   if(stmt != null) 
            {   stmt.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    public static void closeConn(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConn(conn, stmt);
        try
        {   if(rs != null) 
            {   rs.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
}
