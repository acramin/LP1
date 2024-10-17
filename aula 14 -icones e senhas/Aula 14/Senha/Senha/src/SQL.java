
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
    String varchar1, varchar2;
    int int1;


    //Para criar uma conexao fazer apenas "conn = Conexao.getConn();"
    
    //Nao esquecer de fazer Conexao.closeConn(conn);

    //Colocar essa funcoes 
    public void inserir(Connection conn) throws SQLException {
        String sql = "INSERT INTO nomeDaTable (varchar1, int1, varchar2) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.varchar1);
            pstmt.setInt(2, this.int1);
            pstmt.setString(3, this.varchar2);
            pstmt.executeUpdate();
        }
    }

    public void alterar(Connection conn) throws SQLException {
        String sql = "UPDATE nomeDaTable SET varchar1 = ?, int1 = ? WHERE varchar2 = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.varchar1);
            pstmt.setInt(2, this.int1);
            pstmt.setString(3, this.varchar2);
            pstmt.executeUpdate();
        }
    }

    public void excluir(Connection conn) throws SQLException {
        String sql = "DELETE FROM nomeDaTable WHERE varchar2 = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.varchar2);
            pstmt.executeUpdate();
        }
    }

        public void carregar(Connection conn) throws SQLException {
        String sql = "SELECT varchar1, int1 FROM nomeDaTable WHERE varchar2 = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.varchar2);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.varchar1 = rs.getString("varchar1");
                this.int1 = rs.getInt("int1");
            }
        }
    }

    public void listarItens(Connection conn) throws SQLException {
        String sql = "SELECT * FROM nomeDaTabela";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String varchar1 = rs.getString("varchar1");
                int int1 = rs.getInt("int1");
                String varchar2 = rs.getString("varchar2");

                // Exiba os resultados, você pode modificar essa parte conforme necessário
                System.out.println("varchar1: " + varchar1 + ", int1: " + int1 + ", varchar2: " + varchar2);
            }
        }
    }

}
