// Ex2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex2 {

    public static void LerArquivo(String nomeArquivo) {
        try{
            File arquivo = new File(nomeArquivo);
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNext()) {
                System.out.print(sc.nextLine());
                System.out.println(" ");
            }
            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        LerArquivo("teste.txt");
    }
}