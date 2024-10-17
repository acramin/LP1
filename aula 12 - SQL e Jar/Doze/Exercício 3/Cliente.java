import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {
    
    private String nome;
    private String cpf;
    private ContaCorrrente conta;

    public Cliente(String n, String cpf, ContaCorrrente c){
        nome = n;
        this.cpf = cpf;
        conta = c;
    }

    public Cliente(){
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public ContaCorrrente getConta(){
        return conta;
    }

    public void setConta(ContaCorrrente conta) {
        this.conta = conta;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return "Nome: " + nome + "\nCpf: " + cpf + "\nConta: " + conta.getNumero() + "-" + conta.getDigito() + "\nSaldo: " + conta.getSaldo();
    }

    /* CRUD cliente */

    public void inserir(Cliente c){
        String sql = "INSERT INTO cliente (nome, cpf, conta) VALUES (?,?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setInt(3, c.getConta().getNumero());
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

    public void deletar(Cliente c){
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
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

    public void atualizar(Connection conn, Cliente c){
        String sql = "UPDATE cliente SET nome = ? WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
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


    public void consultar(Connection conn, Cliente c){
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.executeQuery();
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

    public static ArrayList<Cliente> buscarTodos() {
        ArrayList<Cliente> aL = new ArrayList<>();
        String sqlSelect = "SELECT c.nome, c.cpf, " +
                            "cc.numero, cc.digito, cc.saldo, " +
                            "a.nome, a.numero, a.digito" +
                            "FROM Cliente AS c JOIN Conta AS cc ON c.conta = cc.numero JOIN Agencia AS a ON cc.agencia = a.numero";

        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));

                ContaCorrrente conta = new ContaCorrrente();
                conta.setNumero(rs.getInt("numero"));
                conta.setDigito(rs.getInt("digito"));
                conta.setSaldo(rs.getDouble("saldo"));

                Agencia agencia = new Agencia();
                agencia.setNome(rs.getString("nome"));
                agencia.setNumero(rs.getInt("numero"));
                agencia.setDigito(rs.getInt("digito"));

                conta.setAgencia(agencia);
                cliente.setConta(conta);

                aL.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os dados: " + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt, rs);
        }
        return aL;
    }
}
