package Slides;

public class Relogio {
    // atributos
    public Mostrador hora;
    public Mostrador minuto;
    public Mostrador segundos;
    public String mostrador;

    /*public Relogio(){ // instancia relogio
        hora = new Mostrador(24);
        minuto = new Mostrador(60);
        segundos = new Mostrador(60);
        atualizaMostrador(); // coloca valor no display

    }*/ // ex 1 a 4

    public Relogio(){ // instancia relogio
        hora = new Mostrador(12);
        minuto = new Mostrador(60);
        segundos = new Mostrador(60);
        atualizaMostrador(); // coloca valor no display

    } // ex 5


    public void ticTac(){ // incrementa de minuto a minuto
        segundos.incrementa();;
        if (segundos.getValor() == 0){
            minuto.incrementa();
            if(minuto.getValor() == 0){
                hora.incrementa();
            }
        }   
        atualizaMostrador(); 
    }

    /*private void atualizaMostrador(){ 
        mostrador = hora.mostra() + ":" + minuto.mostra() + ":" + segundos.mostra();
    }*/ // ex1 a 4

    private void atualizaMostrador(){
        mostrador = hora.mostra() + ":" + minuto.mostra() + ":" + segundos.mostra();       
    } // ex 5 (não ta pronto)

    public String mostra(){
        return mostrador;
    }

}
