import java.util.Scanner;

public class Ex13_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma data [dd/mm/aa]: ");
        String data = sc.nextLine();

        String dia = data.substring(0, 2);
        System.out.println("dia: " + dia);
        String mes = data.substring(3, 5);
        System.out.println("mes: " + mes);
        String ano =  data.substring(6, 8);
        System.out.println("ano: 20" + ano);


    }
}
