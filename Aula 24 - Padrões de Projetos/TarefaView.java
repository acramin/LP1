import java.util.List;

public class TarefaView {
    public void exibirTarefas(List<TarefaModel> tarefas) {
        System.out.println("Lista de Tarefas: ");
        for( TarefaModel tarefa : tarefas){
            String status = tarefa.isConcluida() ? "[X]" : "[]";
            System.out.println(status + " " + tarefa.getDescricao());
        }
        System.out.println();
    }
}
