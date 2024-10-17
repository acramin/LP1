import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudBD {

    public void inserir(Connection conn, Professor p) {
        String sqlInsert = "INSERT INTO PROFESSOR(nome, idade, matricula) VALUES(?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setInt(3, p.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao incluir os dados: " + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(null, stmt);
        }
    }

    public void carregar(Connection conn, Professor p) {
        String sqlSelect = "SELECT idade FROM Professor WHERE nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, p.getNome());
            rs = stmt.executeQuery();
            if (rs.next()) {
                p.setIdade(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar os dados: " + ex.toString());
        } finally {
            ConnFactory.closeConn(null, stmt, rs);
        }
    }

    public void alterar(Connection conn, Professor p) {
        String sqlUpdate = "UPDATE Professor SET idade = ? WHERE nome = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setInt(1, p.getIdade());
            stmt.setString(2, p.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao alterar os dados: " + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(null, stmt);
        }
    }

    public void excluir(Connection conn, Professor p) {
        String sqlDelete = "DELETE FROM Professor WHERE nome = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setString(1, p.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao excluir os dados: " + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(null, stmt);
        }
    }

    public ArrayList<Professor> buscarTodos() {
        ArrayList<Professor> aL = new ArrayList<>();
        String sqlSelect = "SELECT nome, idade, matricula FROM Professor";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = ConnFactory.getConn();
        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor p = new Professor();
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setMatricula(rs.getInt("matricula"));
                aL.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os dados: " + ex.toString());
        } finally {
            ConnFactory.closeConn(null, stmt, rs);
        }
        return aL;
    }
}
