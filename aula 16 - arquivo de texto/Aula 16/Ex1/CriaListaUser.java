package Ex1;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CriaListaUser {
    private Formatter output; // objeto usado para gravar texto no arquivo
    
    public void openFile() { // permite ao usuário abrir o arquivo
        try {
            output = new Formatter("usuarios.txt");
        } 
        catch (SecurityException securityException) {
            System.err.println("Você não tem permissão de escrita para este arquivo.");
            System.exit(1);
        } 
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Erro ao criar o arquivo.");
            System.exit(1);
        } 
    } 

    public void addRecords() { // adiciona registros ao arquivo
        User record = new User();
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("%s\n%s\n%s\n", 
                "Para terminar a entrada, digite o indicador de fim de arquivo",
                "quando solicitado a inserir os dados.",
                "No UNIX/Linux/Mac OS X, digite <ctrl> d e pressione Enter;\nNo Windows, digite <ctrl> z e pressione Enter ou <ctrl> c");
            System.out.printf("%s\n%s", 
                "Digite o Usuário <ESPAÇO> Senha <ENTER>", 
                "> ");
            while (input.hasNext()) { // loop até o indicador de fim de arquivo
                try { // grava os valores no arquivo
                    // obtém os dados a serem gravados
                    record.setuser(input.next()); // lê o nome de usuário
                    record.setpassword(input.next()); // lê a senha
                    if (record.getuser().length() > 0 && record.getpassword().length() > 0) {
                        output.format("%s %s\n", record.getuser(), record.getpassword());
                    } else {                    
                        System.out.println("Usuário e Senha devem ter mais de 0 caracteres.");
                    } 
                } 
                catch (FormatterClosedException formatterClosedException) {
                    System.err.println("Erro ao gravar no arquivo.");
                    break;
                } 
                catch (NoSuchElementException elementException) {
                    System.err.println("Entrada inválida. Tente novamente.");
                    input.nextLine(); // descarta a entrada para permitir nova tentativa
                } 
                System.out.printf("%s\n%s", 
                                  "Digite o Usuário <ESPAÇO> Senha <ENTER>", 
                                  "> ");
            } 
        }
    } 

    public void closeFile() { // fecha o arquivo
        if (output != null)
            output.close();
    } 
} 
