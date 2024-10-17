import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JavaMySqlApp {

    public static void main(String[] args) {
        String sMenu[] = {"Incluir", "Consultar", "Alterar", "Excluir", "Listar", "Sair"};
        ArrayList<Disciplina> aLista;
        Disciplina uDraft = new Disciplina();
        Professor pDraft = new Professor();
        Gui gMenu = new Gui(sMenu);
        CrudD cBD = new CrudD();
        CrudP cBP = new CrudP();
        int iOption;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/disciplina", "root", "1234");

            do {
                // Limpar os dados da disciplina
                uDraft = new Disciplina();
                iOption = gMenu.getOption();
                switch (iOption) {
                    case 0: // Incluir
                        uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o Nome da Disciplina:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                        uDraft.setCodigo(JOptionPane.showInputDialog(null, "Digite o Código da Disciplina:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                        pDraft.setNome(JOptionPane.showInputDialog(null, "Digite o Nome do Professor:", "Incluir", JOptionPane.QUESTION_MESSAGE));
                        pDraft.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Idade do Professor:", "Incluir", JOptionPane.QUESTION_MESSAGE)));
                        pDraft.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Matrícula do Professor:", "Incluir", JOptionPane.QUESTION_MESSAGE)));
                        cBP.inserir(conn, pDraft);
                        cBP.carregar(conn, pDraft);
                        uDraft.setProfessores(new ArrayList<Professor>());
                        uDraft.getProfessores().add(pDraft);
                        cBD.inserir(uDraft, pDraft);
                        break;

                    case 1: // Consultar
                        uDraft.setCodigo(JOptionPane.showInputDialog(null, "Digite o Código da Disciplina:", "Consultar", JOptionPane.QUESTION_MESSAGE));
                        cBD.carregar(uDraft);
                        if(uDraft.getNome() == null){
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!", "Disciplina não encontrada", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else { 
                            JOptionPane.showMessageDialog(null,"Disciplina: [nome = " + uDraft.getNome() + ", codigo = " + uDraft.getCodigo()+ " ]", "Disciplina Consultada", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
    
                    case 2: // Alterar
                        uDraft.setCodigo(JOptionPane.showInputDialog(null, "Digite o Código da Disciplina:", "Alterar", JOptionPane.QUESTION_MESSAGE));
                        cBD.carregar(uDraft);
                        if(uDraft.getNome() == null){
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!", "Disciplina não encontrada", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else {
                            uDraft.setNome(JOptionPane.showInputDialog(null, "Digite o Novo Nome da Disciplina:", "Alterar", JOptionPane.QUESTION_MESSAGE));
                            cBD.alterar(uDraft);
                        }
                        break;
                    case 3: // Excluir
                        uDraft.setCodigo(JOptionPane.showInputDialog(null, "Digite o Código da Disciplina:", "Excluir", JOptionPane.QUESTION_MESSAGE));
                        cBD.excluir(uDraft);
                        if(!uDraft.getProfessores().isEmpty()){
                            pDraft = uDraft.getProfessores().get(0);
                            cBP.excluir(conn, pDraft);
                        }
                        break;
    
                    case 4: // Listar
                        JOptionPane.showMessageDialog(null, "Acione OK para ver no console as disciplinas cadastradas!");
                        aLista = cBD.buscarTodos();
                        for (Disciplina d : aLista) {
                            System.out.println(d.toString());
                        }
                        System.out.println("------------------------------");
                        break;
    
                    case 5: // Sair
                        System.exit(0);
                        break;
                }
            } while (iOption < sMenu.length - 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
