import javax.swing.SwingUtilities;

public class AplicacaoTarefa {
    public static void main(String[] args) {
        // original
        /*TarefaController controller = new TarefaController();
        controller.atualizarView();
        controller.adicionarTarefa("Fazer Compras");
        controller.atualizarView();
        controller.adicionarTarefa("Estudar Java");
        controller.atualizarView();
        controller.adicionarTarefa("Exemplo de MVC");
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(0);
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(1);
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(2);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(0);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(1);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(2);
        controller.atualizarView();
        controller.removerTarefa(0);
        controller.atualizarView();
        controller.removerTarefa(0);
        controller.atualizarView();
        controller.removerTarefa(0);
        controller.atualizarView();*/

         SwingUtilities.invokeLater(() -> new TarefaController());
    }
}
