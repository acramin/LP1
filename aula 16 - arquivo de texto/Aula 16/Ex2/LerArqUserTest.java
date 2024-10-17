package Ex2;

import Ex1.User;

import java.util.Scanner;

public class LerArqUserTest {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("Usuário: ");
        try (Scanner input = new Scanner(System.in)) {
            user.setuser(input.next());
            System.out.println("Senha: ");
            user.setpassword(input.next());
        }
        LerArqUser application = new LerArqUser();
        application.openFile();
        application.checkUser(user);
        application.closeFile();

    } // end main


}   // end class CreateTextFileTest

