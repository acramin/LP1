package Ex2;

// This program reads a text file and displays each record.
import java.io.File;
import java.io.FileNotFoundException;
//import java.util.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Ex1.User;

public class LerArqUser {
    private Scanner input;

    // enable user to open file
    public void openFile() {
        try {
            input = new Scanner(new File("usuarios.txt"));
        } // end try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file.");
            System.exit(1);
        } // end catch
    } // end method openFile

    // read record from file
    public void readRecords() {
        // object to be written to screen
        User record = new User();
        System.out.printf("%-12s%-12s\n", 
                          "Usuário", "Senha");

        try {
            while (input.hasNext()) { // read records from file using Scanner object
                record.setuser(input.next()); // read first name
                record.setpassword(input.next()); // read last name
                // display record contents
                System.out.printf("%-12s%-12s\n",
                                record.getuser(),record.getpassword());
            } // end while
        } // end try
        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } // end catch
        catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        } // end catch
    } // end method readRecords

    // close file and terminate application
    public void closeFile() {
        if (input != null)
            input.close(); // close file
    } // end method closeFile

    public void checkUser(User user) {
        User record = new User();
        try {
            while (input.hasNext()) { // read records from file using Scanner object
                record.setuser(input.next()); // read login
                record.setpassword(input.next()); // read password
                if (record.getuser().equals(user.getuser()) && record.getpassword().equals(user.getpassword())) {
                    System.out.println("Login realizado com sucesso.");
                    return;
                }
            } // end while
            System.out.println("Login e/ou senha incorreto(s).");
        } // end try
        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } // end catch
        catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        } // end catch
    }
} // end class ReadTextFile

