import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudD {

    public void inserir(Disciplina d, Professor p) {
        String sqlInsertDisciplina = "INSERT INTO Disciplina (nome, codigo, professor) VALUES (?, ?, ?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmtDisciplina = null;

        try {
            conn.setAutoCommit(false);
            stmtDisciplina = conn.prepareStatement(sqlInsertDisciplina);
            stmtDisciplina.setString(1, d.getNome());
            stmtDisciplina.setString(2, d.getCodigo());
            stmtDisciplina.setString(3, p.getNome());
            stmtDisciplina.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            ConnFactory.closeConn(conn, stmtDisciplina);
        }
    }

    public void alterar(Disciplina d) {
        String sqlUpdate = "UPDATE Disciplina SET nome = ? WHERE codigo = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCodigo());
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

    public void excluir(Disciplina d) {
        String sqlDelete = "DELETE FROM Disciplina WHERE codigo = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setString(1, d.getCodigo());
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

    public void carregar(Disciplina d) {
        String sqlSelect = "SELECT nome FROM Disciplina WHERE codigo = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, d.getCodigo());
            rs = stmt.executeQuery();
            if (rs.next()) {
                d.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnFactory.closeConn(conn, stmt, rs);
        }
    }

    public ArrayList<Disciplina> buscarTodos() {
        ArrayList<Disciplina> aL = new ArrayList<>();
        String sqlSelect = "SELECT d.nome, d.codigo, d.professor, p.idade, p.matricula FROM Disciplina as d JOIN Professor as p ON d.professor = p.nome_p;";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                // existe a disciplina?
                Disciplina existingDisciplina = null;
                for (Disciplina d : aL) {
                    if (d.getCodigo().equals(rs.getString("codigo"))) {
                        existingDisciplina = d;
                        break;
                    }
                }
    
                if (existingDisciplina == null) {
                    existingDisciplina = new Disciplina();
                    existingDisciplina.setNome(rs.getString("nome"));
                    existingDisciplina.setCodigo(rs.getString("codigo"));
                    existingDisciplina.setProfessores(new ArrayList<Professor>());
                    aL.add(existingDisciplina);
                }
    
                Professor p = new Professor();
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setMatricula(rs.getInt("matricula"));
    
                existingDisciplina.getProfessores().add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os dados: " + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt, rs);
        }
        return aL;
    }
}

