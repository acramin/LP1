public class TarefaModel 
{
    private String descricao;
    private boolean concluida;

    public TarefaModel(String descricao) 
    {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public boolean isConcluida() 
    {
        return concluida;
    }

    public void marcaConcluida() 
    {
        this.concluida = true;
    }

    public void desmarcaConcluida() 
    {
        this.concluida = false;
    }
}