package Slides;

//import java.util.Scanner; // usado para atualizar manualmente
import java.util.concurrent.TimeUnit;

public class Teste {
    public static void main(String[] args) throws InterruptedException{ 
        Relogio relogio = new Relogio();

        /*for(int i = 0; i < 1444; i ++){ // 1444 = 1 seguendo
            relogio.ticTac();
            System.out.println(relogio.mostra());
        }*/ // original

        /*Scanner sc = new Scanner(System.in);
        String s = "tictac";

        while(s.equals("tictac")){
            s = sc.nextLine();

            if(s.equals("tictac")){
                relogio.ticTac();
                System.out.println(relogio.mostra());
            }

        }*/ // atualiza manualmente

        /*while(!relogio.mostra().equals("23:59")){
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long sleepTimeInSeconds = 1;
            timeUnit.sleep(sleepTimeInSeconds);
            relogio.ticTac();
            System.out.println(relogio.mostra());
        }*/ // HH:MM:SS

        while(!relogio.mostra().equals("23:59")){
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long sleepTimeInSeconds = 1;
            timeUnit.sleep(sleepTimeInSeconds);
            relogio.ticTac();
            System.out.println(relogio.mostra());
        } // HH:MM:SS - AM/PM


    }
}
