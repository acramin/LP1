package Ex2;

public class Relogio {
    public Mostrador hora;
    public Mostrador minuto;
    public Mostrador segundos;
    public String mostrador;

    public Relogio(){ // instancia relogio
        hora = new Mostrador(24);
        minuto = new Mostrador(60);
        atualizaMostrador();

    }

    public void ticTac(){ // incrementa de minuto a minuto
            minuto.incrementa();
            if(minuto.getValor() == 0){
                hora.incrementa();
            }  
        atualizaMostrador(); 
    }


    public void atualizaMostrador(){ 
        mostrador = hora.mostra() + ":" + minuto.mostra();
    }

    public String mostra(){
        return mostrador;
    }

}
