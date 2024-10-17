import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int op = -1;
        double p_res = 0.32; // op == 1
        double p_com = 0.5; // op == 2
        double p_ind = 0.7; // op == 3
        double total_cons = 0; // soma de consumos dos 3 tipos de consumidor
        double media_cons = 0; // média de consumo dos tipos 1 e  2
        int id = 0; // código do consumidor
        double cons = 0; // consumo em kWh
        double p1 = 0; // gasto do consumidor tipo 1
        double p2 = 0 ; // gasto do consumidor tipo 2
        double p3 = 0 ; // gasto do consumidor tipo 3
        int i = 0; // contagem de consumidores do tipo 1 e 2
        double soma = 0;

        while (op != 0) {
            System.out.println("\n*** Menu *** \n 1 - Residencial \n 2 - Comercial \n 3 - Industrial\n 0 - Finalizar\n ");
            System.out.print("Digite o tipo de consumidor: ");
            op = sc.nextInt();

            if(op != 0){
                System.out.print("Digite id de consumidor: ");
                id = sc.nextInt();
                System.out.print("Digite o consumo: [kWh] ");
                cons = sc.nextDouble();
            }
            
            switch (op) {
                case 1:
                    p1 = cons * p_res;
                    i++;
                    System.out.println("Custo do consumidor " + id + ": " + p1);
                    soma = soma + cons;
                    total_cons =  p1  + total_cons;
                    break;
                case 2:
                    p2 = cons * p_com;
                    i++;
                    System.out.println("Custo do consumidor " + id + ": " + p2);
                    soma = soma + cons;
                    total_cons =  p2 + total_cons;
                    break;
                case 3:
                    p3 = cons * p_ind;
                    System.out.println("Custo do consumidor " + id + ": " + p3);
                    total_cons =  p3 + total_cons;
                    break;
                default:
                    break;
            }
        }
        if( i == 0){
            System.out.println("Nenhum consumidor foi registrado.");
        }else{
            media_cons = soma / i;
            System.out.println("\nTotal de consumo:  " + total_cons);
            System.out.println("Média de consumo dos tipos 1 e 2: "  + media_cons);
        }
        sc.close();
    }
}