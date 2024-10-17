import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Agencia {
    
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String n, int num, int d){
        nome = n;
        numero = num;
        digito = d;
    }

    public Agencia(){
    }

    public int getDigito() {
        return digito;
    }
    
    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean mod11(int numero, int digito){
        int p = numero/1000;
        int s = (numero % 1000)  / 100; 
        int t = (numero % 100) / 10 ;
        int q = (numero % 10);
        
        int valido = (p*4 +  s*6+ t*8+ q*2 ) % 11;
        
        if ( valido == digito){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Nome: " + nome + "\nNumero: " + numero + "-" + digito;
    }

    /* CRUD agencia */

    public void inserir(Connection conn, Agencia agencia){
        String sql = "INSERT INTO agencia (nome, numero, digito) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, agencia.getNome());
            stmt.setInt(2, agencia.getNumero());
            stmt.setInt(3, agencia.getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(Connection conn, Agencia agencia) {
        String sql = "DELETE FROM Agencia WHERE numero = ? AND digito = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agencia.getNumero());
            stmt.setInt(2, agencia.getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Connection conn, Agencia agencia) {
        String sql = "UPDATE Agencia SET nome = ? WHERE numero = ? AND digito = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, agencia.getNome());
            stmt.setInt(2, agencia.getNumero());
            stmt.setInt(3, agencia.getDigito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultar(Connection conn, Agencia agencia){
        String sql = "SELECT * FROM agencia WHERE numero = " + agencia.getNumero();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar(){
        String sql = "SELECT * FROM agencia";
        Connection conn = ConnFactory.getConn();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
