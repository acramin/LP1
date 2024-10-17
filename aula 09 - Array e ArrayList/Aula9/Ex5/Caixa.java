package Ex5;

public class Caixa {
    private String corredor;
    private int posicao;
    private double peso;
    private String dono;

    public Caixa(String corredor, int posicao, double peso, String dono){
        this.corredor = corredor;
        this.posicao = posicao;
        this.peso = peso;
        this.dono = dono;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getCorredor() {
        return corredor;
    }

    public String getDono() {
        return dono;
    }

    public double getPeso() {
        return peso;
    }

    public int getPosicao() {
        return posicao;
    }

    
}
