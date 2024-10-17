public class ex6 {
    public static void main(String[] args) {
        
        int n = 1;
        do{
            if(n % 5 == 0){
                System.out.println(n);
            }
            n++;
        }while(n <= 500);
        System.out.println("Programa Finalizado!");
    }
}