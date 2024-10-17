package Exemplo1;
import java.util.Scanner;
public class FileDemonstrationTest {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            FileDemonstration application = new FileDemonstration();

            System.out.println("Enter file or directory name:");
            application.analyzePath(input.nextLine());
        }
    } // end main
} // end class FileDemonstrationTest
