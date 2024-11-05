import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TarefaViewGUI extends JFrame {
    private JTextField inputDescricao;
    private JButton btnAdicionar, btnMarcarConcluida, btnMarcarNaoConcluida, btnExcluir, btnVisualizar;
    private JTextArea areaTarefas;
    
    public TarefaViewGUI(TarefaController controller) {
        setTitle("Gerenciador de Tarefas");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Área de exibição das tarefas
        areaTarefas = new JTextArea();
        areaTarefas.setEditable(false);
        add(new JScrollPane(areaTarefas), BorderLayout.CENTER);
        
        // Painel de controle de tarefas
        JPanel panelControls = new JPanel(new FlowLayout());
        
        inputDescricao = new JTextField(20);
        panelControls.add(new JLabel("Descrição da Tarefa:"));
        panelControls.add(inputDescricao);
        
        btnAdicionar = new JButton("Incluir nova tarefa");
        btnAdicionar.addActionListener(e -> controller.adicionarTarefa(inputDescricao.getText()));
        
        btnMarcarConcluida = new JButton("Marcar como Concluída");
        btnMarcarConcluida.addActionListener(e -> {
            int index = getIndiceTarefa();
            if (index >= 0) controller.marcarTarefaComoConcluida(index);
        });
        
        btnMarcarNaoConcluida = new JButton("Marcar como Não Concluída");
        btnMarcarNaoConcluida.addActionListener(e -> {
            int index = getIndiceTarefa();
            if (index >= 0) controller.marcarTarefaComoNaoConcluida(index);
        });
        
        btnExcluir = new JButton("Excluir Tarefa");
        btnExcluir.addActionListener(e -> {
            int index = getIndiceTarefa();
            if (index >= 0) controller.removerTarefa(index);
        });
        
        btnVisualizar = new JButton("Visualizar Lista de Tarefas");
        btnVisualizar.addActionListener(e -> controller.atualizarView());
        
        panelControls.add(btnAdicionar);
        panelControls.add(btnMarcarConcluida);
        panelControls.add(btnMarcarNaoConcluida);
        panelControls.add(btnExcluir);
        panelControls.add(btnVisualizar);
        
        add(panelControls, BorderLayout.SOUTH);
    }
    
    private int getIndiceTarefa() {
        try {
            String input = JOptionPane.showInputDialog("Digite o índice da tarefa:");
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Índice inválido!");
            return -1;
        }
    }
    
    public void exibirTarefas(List<TarefaModel> tarefas) {
        StringBuilder sb = new StringBuilder("Lista de Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            TarefaModel tarefa = tarefas.get(i);
            String status = tarefa.isConcluida() ? "[X]" : "[]";
            sb.append(i).append(" - ").append(status).append(" ").append(tarefa.getDescricao()).append("\n");
        }
        areaTarefas.setText(sb.toString());
    }
}

