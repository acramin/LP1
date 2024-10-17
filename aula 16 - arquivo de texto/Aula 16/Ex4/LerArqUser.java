package Ex4;

// This program reads a text file and displays each record.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Ex3.Aluno;

public class LerArqUser {
    private Scanner input;

    // Enable user to open file
    public void openFile() {
        try {
            input = new Scanner(new File("alunos.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    // Read records from file and check for specific RA
    public void readRecords(String raEntrada) {
        Aluno record = new Aluno();
        boolean found = false; // Flag to track if RA is found

        StringBuilder messageBuilder = new StringBuilder();

        try {
            // Read records from file
            while (input.hasNext()) {

                String ra = input.next();
                record.setra(ra);
                record.setnome(input.next());
                record.setsobrenome(input.next());
                record.setp1(input.nextDouble());
                record.setp2(input.nextDouble());
                record.setp3(input.nextDouble());
                record.setp4(input.nextDouble());
                input.nextDouble(); // Skip media

                if (ra.equals(raEntrada)) {
                    // RA found; build message
                    found = true;
                    messageBuilder.append(String.format("RA: %s\nNome completo: %s %s\nMedia: %.1f",
                        record.getra(), record.getnome(), record.getsobrenome(), record.getMedia()));
                    break; // Exit loop as we found the RA
                }
            }

            if (found) {
                // Display message using JOptionPane
                JOptionPane.showMessageDialog(null, messageBuilder.toString(), "Record Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Display message if RA is not found
                JOptionPane.showMessageDialog(null, "RA não encontrado.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
    }

    // Close file and terminate application
    public void closeFile() {
        if (input != null)
            input.close(); // Close file
    }
}
