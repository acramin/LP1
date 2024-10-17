public class Vetor {
    
    private double[] vetor;
    private int tamanho; 

    // construtor instancia vetor com o tamanho dado
    public Vetor( int tamanho){
        this.tamanho = tamanho;
        this.vetor = new double[tamanho];
    }

    // seta tamanho
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new double[tamanho];
    }

    // pega tamanho
    public int getTamanho() {
        return tamanho;
    }

    // seta elemento
    public void setElemento(int index, double valor) {
        if (index >= 0 && index < tamanho) {
            vetor[index] = valor;
        }
    }

    // pega elemento
    public double getElemento(int index) {
            return vetor[index];
    }
}
