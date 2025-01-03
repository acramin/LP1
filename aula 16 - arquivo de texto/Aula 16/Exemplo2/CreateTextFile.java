package Exemplo2;

// Writing data to a text file with class Formatter.
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter output; // object used to output text to file
    
    public void openFile() { // enable user to open file
        try {
            output = new Formatter("clients.txt");
        } // end try
        catch (SecurityException securityException) {
            System.err.println("You do not have write access to this file.");
            System.exit(1);
        }
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error creating file.");
            System.exit(1);
        } // end catch
    } // end method openFile

    public void addRecords() { // add records to file
    // object to be written to the file
    AccountRecord record = new AccountRecord();
    try (Scanner input = new Scanner(System.in)) {
        System.out.printf("%s\n%s\n%s\n", 
            "To terminate input, type the end-of-file indicator",
            "when you are prompted to enter input.",
            "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter;",
            "On Windows type <ctrl> z then press Enter or <ctrl> c");
        System.out.printf("%s\n%s",
            "Enter account number (> 0) <SPACE> first name <SPACE> last name <SPACE> balance <ENTER>", 
            "> ");

        while (input.hasNext()) { // loop until end-of-file indicator
            try { // output values to file
                // retrieve data to be output
                record.setAccount(input.nextInt()); // read account number
                record.setFirstName(input.next()); // read first name
                record.setLastName(input.next()); // read last name
                record.setBalance(input.nextDouble()); // read balance
                if (record.getAccount() > 0) {
                    // write new record
                    output.format("%d %s %s %.2f\n", record.getAccount(),
                                  record.getFirstName(), record.getLastName(),
                                  record.getBalance());
                } else {
                    System.out.println("Account number must be greater than 0.");
                } // end if
            } // end try
            catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file.");
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine(); // discard input so user can try again
            } // end catch
            System.out.printf("%s %s\n%s", 
                              "Enter account number (>0) <SPACE>", 
                              "first name <SPACE> last name <SPACE> balance <ENTER>", 
                              "> ");
        } // end while
    }
} // end method addRecords

public void closeFile() { // close file
    if (output != null)
        output.close();
} // end method closeFile
} // end class CreateTextFile

