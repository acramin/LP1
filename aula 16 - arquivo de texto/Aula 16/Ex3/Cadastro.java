package Ex3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.NoSuchElementException;

public class Cadastro {
    private Formatter output; // object used to output text to file

    public void openFile() { // enable user to open file
        try {
            // Create a FileWriter in append mode
            FileWriter fileWriter = new FileWriter("alunos.txt", true);
            output = new Formatter(fileWriter);
        } catch (SecurityException securityException) {
            System.err.println("You do not have write access to this file.");
            System.exit(1);
        } catch (IOException ioException) {
            System.err.println("Error creating file.");
            System.exit(1);
        }
    } // end method openFile

    public void addRecords(String Ra, String Nome, String Sobrenome, String P1,
                            String P2, String P3, String P4) { // adiciona registros ao arquivo
        Aluno record = new Aluno();
        try {
            record.setra(Ra);
            record.setnome(Nome);
            record.setsobrenome(Sobrenome);
            record.setp1(Double.parseDouble(P1));
            record.setp2(Double.parseDouble(P2));
            record.setp3(Double.parseDouble(P3));
            record.setp4(Double.parseDouble(P4));
            record.getMedia();
            if (record.getra().length() > 0 && record.getnome().length() > 0 && record.getsobrenome().length() > 0) {
                output.format("%s %s %s %.1f %.1f %.1f %.1f %.1f\n", record.getra(), record.getnome(), record.getsobrenome(), record.getp1(), record.getp2(), record.getp3(), record.getp4(), record.getMedia());
            } else {                    
                System.out.println("RA, Nome e Sobrenome devem ter mais de 0 caracteres.");
            } 
        } 
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida. Tente novamente.");
        }
    } 

    public void closeFile() { // fecha o arquivo
        if (output != null)
            output.close();
    } 
}
