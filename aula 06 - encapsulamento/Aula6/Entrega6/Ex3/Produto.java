package Entrega6.Ex3;

public class Produto {

    private String nome;
    private double preco;
    private int qtd;

    public Produto(String n, double p, int q){
        nome = n;
        preco = p;
        qtd = q;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public int getQtd(){
        return qtd;
    }

    public void setNome( String n){
        nome = n;
    }

    public void setPreco(double p){
        preco = p;
    }

    public void setQtd(int q){
        qtd = q;
    }
    
}