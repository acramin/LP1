import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String  op = "";
        // int i = 0; // contador

        do{
            System.out.print("Digite um nome ou FIM para sair: ");
            op = sc.nextLine();
            op = op.toUpperCase();
            System.out.println(op);
        }while(!op.equals("FIM"));


        sc.close();
    }
}
