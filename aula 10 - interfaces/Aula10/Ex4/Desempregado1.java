package Ex4;

public class Desempregado1 extends PessoaFisica1{
    private double seguroDesemprego;

    public Desempregado1(){
        seguroDesemprego = 0.0;
    }

    public Desempregado1(String nome, String sobrenome, String cpf, double seguroDesemprego){
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
