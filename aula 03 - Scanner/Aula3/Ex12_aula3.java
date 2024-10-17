
import java.util.Scanner;

public class Ex12_aula3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma data [ddmmaa]: ");
        int data = sc.nextInt();

        int dia = data / 10000;
        int mes = (data % 10000) / 100;
        int ano = data % 100;

        if( dia < 10 ){
            System.out.println("dia: 0" + dia );
        }else{
            System.out.println("dia: " + dia );
        }
        if (mes < 10) {
            System.out.println("mes: 0" + mes);
        }else{
            System.out.println("mes: " + mes);
        }
        if(ano < 10){
            System.out.println("ano: 200" + ano);
        }else{
            System.out.println("ano: 20" + ano);
        }
    }
}
