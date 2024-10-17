package Ex1;

public class Cheque extends Pagamento{
    private String numeroDoCheque;

    public Cheque(String nomeDoPagador, String cpf, double valorASerPago, String numeroDoCheque){
        super(nomeDoPagador, cpf, valorASerPago);
        this.numeroDoCheque = numeroDoCheque;
    }

    public void setNumeroDoCheque(String numeroDoCheque) {
        this.numeroDoCheque = numeroDoCheque;
    }

    public String getNumeroDoCheque() {
        return numeroDoCheque;
    }
}
