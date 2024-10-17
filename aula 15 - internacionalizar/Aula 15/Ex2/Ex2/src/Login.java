import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Login {

    public String usuario;
    public String senha;

    public Login(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public void inserir(Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "oattock");
            stmt.setString(2, "baostock");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao alterar os dados: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            Conexao.closeConn(conn, stmt);
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT Password FROM Users WHERE Username = ( ? )";
        //conn = Conexao.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("BURRO: "+(rs.getString("Password")));
                if(rs.getString("Password").equals(this.senha)){
                    JOptionPane.showMessageDialog(null, LanguageManager.getResourceBundle().getString("loginSucess"), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, LanguageManager.getResourceBundle().getString("loginError"), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                this.senha = rs.getString("Password");
            }
            else{
                JOptionPane.showMessageDialog(null, LanguageManager.getResourceBundle().getString("loginError"), "Erro", JOptionPane.ERROR_MESSAGE);
                this.senha = senha + " BUGOU ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler os dados " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            Conexao.closeConn(conn, stmt, rs);
        }
    }

    public void alterar(Connection conn) {
        String sql = "UPDATE Users SET Password = ? WHERE Username = ?";
        conn = Conexao.getConn();
        PreparedStatement stmt = null;
        try {
            System.out.println(this.senha);
            System.out.println(this.usuario);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.senha);
            stmt.setString(2, this.usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao alterar os dados: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            Conexao.closeConn(conn, stmt);
        }
    }
}
