import java.util.Scanner;

public class ex24 {
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        int voto = 0; 
        int eleitores = 0;
        int p1 = 0; 
        int p2 = 0; 
        int p3 = 0; 
        int p4 = 0;
        
        while(voto != -1){
            
            System.out.println("Candidatos: \t 1 \t 2 \t 3 \t 4 \n(-1 para sair)");
            System.out.print("Selecione seu candidato: ");
            voto = sc.nextInt();
            
            if(voto >= 1 && voto <= 4){
                switch(voto){
                    case 1:
                        p1++;
                        break;
                    case 2:
                        p2++;
                        break;
                    case 3:
                        p3++;
                        break;
                    case 4:
                        p4++;
                        break;
                    default:
                        break;
                }
                eleitores++;
            } else if (voto != -1) {
                System.out.println("Candidato invalido. Por favor, selecione novamente.");
            }
        }
        
        if(eleitores != 0){
            double percent_p1 =  ((double)p1 / eleitores) * 100;
            double percent_p2 =  ((double)p2 / eleitores) * 100;
            double percent_p3 =  ((double)p3 / eleitores) * 100;
            double percent_p4 =  ((double)p4 / eleitores) * 100;
        
            System.out.println("Partido 1: " + percent_p1 + " %");
            System.out.println("Partido 2: " + percent_p2 + " %");
            System.out.println("Partido 3: " + percent_p3 + " %");
            System.out.println("Partido 4: " + percent_p4 + " %");
            System.out.println("Total de eleitores: " + eleitores);
        } else {
            System.out.println("Nenhum voto foi registrado.");
        }
        sc.close();

    }
}
