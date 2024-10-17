package Ex1;

public class Boleto extends Pagamento{
    private String nuemroDoBoleto;
    private int dia;
    private int mes;
    private int ano;

    public Boleto(String nomeDoPagador, String cpf, double valorASerPago, String numeroDoBoleto, int dia, int mes, int ano){
        super(nomeDoPagador, cpf, valorASerPago);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.nuemroDoBoleto = numeroDoBoleto;
    }

    public String getNuemroDoBoleto() {
        return nuemroDoBoleto;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public String getNumeroDoBoleto(){
        return nuemroDoBoleto;
    }
}
