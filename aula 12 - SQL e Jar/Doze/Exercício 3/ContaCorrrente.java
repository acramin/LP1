import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaCorrrente {
    
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrrente(int n, int d, Agencia a, double s){
        numero = n;
        digito = d;
        agencia = a;
        saldo = s;
    }

    public ContaCorrrente(){
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public int getDigito() {
        return digito;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double depositar(double valor){
        return saldo = saldo + valor;    
    }

    public double sacar(double valor){
        if (valor > saldo){
            return 0;
        } else {
            saldo = saldo - valor;
            return saldo;
        } 
    }

    public double consultarSaldo(){
        return saldo;
    }

    public String imprimirSaldo(){
        return "Numero da conta: " + numero + "-" + digito + "\nNumero da agencia: " 
        + agencia.getNumero() +  "-" + agencia.getDigito() + "\nSaldo da conta corrente: " + saldo; 
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
        return "Numero da conta: " + numero + "-" + digito + "\nNumero da agencia: " 
        + agencia.getNumero() +  "-" + agencia.getDigito() + "\nSaldo da conta corrente: " + saldo; 
    }

    /* CRUD conta corrente */


    public void inserir(ContaCorrrente c){
        String sql = "INSERT INTO conta (numero, digito, saldo, agencia) VALUES (?, ?, ?, ?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, c.getNumero());
            stmt.setInt(2, c.getDigito());
            stmt.setDouble(3, c.getSaldo());
            stmt.setInt(4, c.getAgencia().getNumero()); 
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void deletar(Connection conn, ContaCorrrente conta){
        String sql = "DELETE FROM conta WHERE numero = " + conta.getNumero() + " AND digito = " + conta.getDigito();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void atualizar(Connection conn, ContaCorrrente conta){
        String sql = "UPDATE conta SET saldo = " + conta.getSaldo() + " WHERE numero = " + conta.getNumero() + " AND digito = " + conta.getDigito();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSaldo(Connection conn, ContaCorrrente conta){
        atualizar(conn, conta);
    }

    public void consultar(Connection conn, ContaCorrrente conta){
        String sql = "SELECT * FROM conta WHERE numero = " + conta.getNumero() + " AND digito = " + conta.getDigito();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar(){
        Connection conn = ConnFactory.getConn();
        String sql = "SELECT * FROM conta";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
