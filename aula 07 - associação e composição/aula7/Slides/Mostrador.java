package Slides;

public class Mostrador {
    // atributos
    private int valor;
    private int limite;

    public Mostrador (int limite){ // limite nessa caso é parametro
        this.limite = limite; // this indica que o primeiro limite é o atributo 
        valor = 0;
    }

    public int getValor(){ 
        return valor;
    }

    public void incrementa(){
        valor = (valor + 1) % limite;
    }

    public String mostra(){
        if ( valor < 10){
            return "0" + valor;
        }
        else {
            return "" + valor;
        }
    }
}
