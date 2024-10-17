package Ex2;

public class Desempregado extends PessoaFisica{
    private double seguroDesemprego;

    public Desempregado(){
        seguroDesemprego = 0.0;
    }

    public Desempregado(String nome, String sobrenome, String cpf, double seguroDesemprego){
        super(nome, sobrenome, cpf);
        this.seguroDesemprego = seguroDesemprego;
    }

    public void setSeguroDesemprego(double seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }

    public double getSeguroDesemprego() {
        return seguroDesemprego;
    }

    public String dados(){
        String msg = super.dados() + "\nSeguro Desemprego: " + seguroDesemprego;
        return msg;
    }

}
