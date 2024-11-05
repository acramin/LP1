import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    private List<TarefaModel> tarefas = new ArrayList<>();
    //private TarefaView view = new TarefaView();
    private TarefaViewGUI view;

    public TarefaController() {
        this.view = new TarefaViewGUI(this);
        view.setVisible(true);
    }

    public void adicionarTarefa(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            TarefaModel novaTarefa = new TarefaModel(descricao);
            tarefas.add(novaTarefa);
            atualizarView();
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            atualizarView();
        }
    }

    public void marcarTarefaComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcaConcluida();
            atualizarView();
        }
    }

    public void marcarTarefaComoNaoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).desmarcaConcluida();
            atualizarView();
        }
    }

    public void atualizarView() {
        view.exibirTarefas(tarefas);
    }

    // original 
    /*public void adicionarTarefa(String descricao) {
        TarefaModel novaTarefa = new TarefaModel(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(int indice) {
        tarefas.remove(indice);
    }

    public void marcarTarefaComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcaConcluida();
        }
    }

    public void marcarTarefaComoNaoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).desmarcaConcluida();
        }
    }

    public void atualizarView() {
        view.exibirTarefas(tarefas);
    }*/
}
