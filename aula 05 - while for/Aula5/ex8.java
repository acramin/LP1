public class ex8 {
    public static void main(String[] args) {
        int n = 1;
        int soma = 0;

        while(n <= 100){
            soma = soma + n;
            System.out.println(n);
            n ++;
        }
        System.out.println("Soma: " + soma);
    }
}
