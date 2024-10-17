import java.text.DecimalFormat;

public class Ex6_aula3 {
    public static void main(String[] args) {
        int N = 8;
        int J = 10;
        double ValorInicial = 100.0;
        double valor = Divida(N, J, ValorInicial);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("O valor pago será de: " + df.format(valor));
    }

    public static double Divida(int N, int J, double ValorInicial){
        return  ValorInicial * Math.pow(1 + (((double) J)/100), N);
    }
}

