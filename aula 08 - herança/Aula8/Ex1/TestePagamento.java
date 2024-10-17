package Ex1;

public class TestePagamento {
    public static void main(String[] args) {

        // teste pagamento

        System.out.println("TESTE DE PAGAMENTO");
        System.out.println();
        System.out.println();

        Pagamento pg = new Pagamento("Filomena Noia", "095.584.487-99", 100);
        String msg = "Nome: " +  pg.getNomeDoPagador() + "\nCPF: " + pg.getCpf() +  "\nValor da ser pago: " + pg.getValorASerPago();
        System.out.println(msg);

        System.out.println();
        System.out.println();


        // teste cheque

        System.out.println("TESTE DE CHEQUE");
        System.out.println();
        System.out.println();


        Cheque ch = new Cheque("Zé", "094.464.264-91", 1000, "0555");
        String msg2 = "Nome: " +  ch.getNomeDoPagador() + "\nCPF: " + ch.getCpf() +  "\nValor da ser pago: " + ch.getValorASerPago() + 
        "\nNumero do Cheque: " + ch.getNumeroDoCheque();
        System.out.println(msg2);


        System.out.println();
        System.out.println();

        // teste cartao de credito

        System.out.println("TESTE DE CARTAO");
        System.out.println();
        System.out.println();


        CartaoDeCredito cc = new CartaoDeCredito("Zinha", "654.487.569-98", 8900, 
        "456 887 656 514");
        String msg3 = "Nome: " +  cc.getNomeDoPagador() + "\nCPF: " + cc.getCpf() +  "\nValor da ser pago: " + cc.getValorASerPago() + 
        "\nNumero do Cartao: " + cc.getNumeroDoCartao();
        System.out.println(msg3);

        System.out.println();
        System.out.println();


        // teste boleto

        System.out.println("TESTE DE BOLETO");
        System.out.println();
        System.out.println();


        Boleto bol = new Boleto("Penga", "800.486.987-94", 9490, "546 988 114", 
        10, 05, 2024);
        String mgs4 = "Nome: " +  bol.getNomeDoPagador() + "\nCPF: " + bol.getCpf() +  "\nValor da ser pago: " + bol.getValorASerPago() + 
        "\nNumero do Boleto: " + bol.getNuemroDoBoleto();

        if (bol.getMes() < 10){
            if(bol.getDia() < 10){
                mgs4 += "\nData: 0" + bol.getDia() + "/0" +  bol.getMes() + "/" + bol.getAno();
            }
            else{
                mgs4 += "\nData: " + bol.getDia() + "/0" +  bol.getMes() + "/" + bol.getAno();
            }
        } 
        else{
            mgs4 += "\nData: " + bol.getDia() + "/" +  bol.getMes() + "/" + bol.getAno();
        }
        System.out.println(mgs4);

        System.out.println();
        System.out.println();
    }
}
