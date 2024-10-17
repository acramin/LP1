import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex5_aula3 {

    public static void main(String[] args) {
        LerArquivo("Ex5.txt");
    }

    public static void LerArquivo(String nomeArquivo) {

        List<String> lista = new ArrayList<>();
        
        try{
            File arquivo = new File(nomeArquivo);
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNext()) {
                lista.add(sc.nextLine());
            }
            Collections.reverse(lista);
            System.out.print(lista);
            System.out.println(" ");
            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}