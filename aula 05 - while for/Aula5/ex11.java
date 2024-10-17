import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int idade = 0;
        int i = 0; // contador de pessoas com meno de 21 anos
        int j =0; // contador de pessoas com mais de 50 anos

        while (idade >= 0 && idade <= 120) {
            System.out.print("digite idade: ");
            idade = sc.nextInt();

            if (idade < 120 ){

                if (idade < 21 ){
                    i++;
                }

                if ( idade > 50){
                    j++;
                }
            }

        }
        System.out.println("Pessoa com menos de 21 anos: " + i);
        System.out.println("Pessoa com mais de 50 anos: " + j);
        sc.close();
    }
}
