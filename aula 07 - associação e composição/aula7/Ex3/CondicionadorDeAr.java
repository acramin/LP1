package Ex3;

public class CondicionadorDeAr {

    private Termostato termostato;
    private boolean ligado;

    public CondicionadorDeAr(){
        ligado = false;
        termostato = new Termostato();
    }

    public Termostato getTermostato() {
        return termostato;
    }

    public boolean getLigado(){
        return ligado;
    }

    public void ligar(){
        ligado = true;
    }

    public void desligar(){
        ligado = false;
    }

    public void aumentarTemperatura(){
        if (ligado) {
            double atual = termostato.getTemperatura();
            if (atual < 28){
                termostato.setTemperatura((termostato.getTemperatura()+1));
                System.out.println("Temperatura aumentada\n");
            }
            else{
                System.out.println("Nao foi possivel aumentar a temperaturaa - limite atingido\n");
            }
        }
        else{
            System.out.println("O Ar nao esta ligado");
        }

        
    }
    public void diminuirTemperatura(){

        if (ligado) {
            double atual = termostato.getTemperatura();
            if(atual > 15){
                termostato.setTemperatura((atual-1));
                System.out.println("Temperatura diminuida\n");
            }
            else{
                System.err.println("Nao foi possivel diminuir a temperartura - limite atingido\n");
            }
        }
        else{
            System.out.println("O Ar nao esta ligado");
        }
    }

    public void imprimirTemperatura(){
        if (ligado){
            System.out.println("A temperatura atual é "+termostato.getTemperatura()+"°C\n");
        } else {
            System.out.println("O Ar nao esta ligado");
        }
    }


}
