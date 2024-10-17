import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaMySqlApp {

    public static void main(String args[]) {
        String sMenu[] = {"Incluir", "Consultar", "Alterar", "Excluir", "Listar", "Sair"};
        ArrayList<Professor> aLista;
        Professor uDraft = new Professor();
        Gui gMenu = new Gui(sMenu);
        CrudBD cBD = new CrudBD();
        int iOption;

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/professor", "root", "1234");
            do {
                uDraft.clearObject();
                iOption = gMenu.getOption();
                switch (iOption) {
                    case 0: // Incluir
                        uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o nome:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                        uDraft.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade:", "Incluir", JOptionPane.QUESTION_MESSAGE)));
                        uDraft.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a matrícula:", "Incluir", JOptionPane.QUESTION_MESSAGE)));
                        cBD.inserir(conn, uDraft);
                        cBD.carregar(conn, uDraft);
                        JOptionPane.showMessageDialog(null, "Professor: " + uDraft.getNome() + "\nIdade: " + uDraft.getIdade() + "\nMatrícula: " + uDraft.getMatricula());
                        break;

                    case 1: // Consultar
                        uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o nome:", "Consultar", JOptionPane.QUESTION_MESSAGE));
                        cBD.carregar(conn, uDraft);
                        JOptionPane.showMessageDialog(null, "Professor: " + uDraft.getNome() + "\nIdade: " + uDraft.getIdade());
                        break;

                    case 2: // Alterar
                        uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o nome:", "Alterar", JOptionPane.QUESTION_MESSAGE));
                        uDraft.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a nova idade:", "Alterar", JOptionPane.QUESTION_MESSAGE)));
                        cBD.alterar(conn, uDraft);
                        cBD.carregar(conn, uDraft);
                        JOptionPane.showMessageDialog(null, "Professor: " + uDraft.getNome() + "\nIdade: " + uDraft.getIdade());
                        break;

                    case 3: // Excluir
                        uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o nome:", "Excluir", JOptionPane.QUESTION_MESSAGE));
                        cBD.excluir(conn, uDraft);
                        break;

                    case 4: // Listar
                        JOptionPane.showMessageDialog(null, "Acione OK para ver no console os professores cadastrados!");
                        aLista = cBD.buscarTodos();
                        for (Professor prof : aLista) {
                            System.out.println(prof.getNome() + " - " + prof.getIdade() + " - " + prof.getMatricula());
                        }
                        System.out.println("------------------------------");
                        break;

                    case 5: // Sair
                        System.exit(0);
                        break;
                }
                //JOptionPane.showMessageDialog(null, "Professor: " + uDraft.getNome() + "\nIdade: " + uDraft.getIdade() + "\nMatrícula: " + uDraft.getMatricula());
            } while (iOption < sMenu.length - 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
}
