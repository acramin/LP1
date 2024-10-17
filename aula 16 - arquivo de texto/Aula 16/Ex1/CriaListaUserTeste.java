package Ex1;

public class CriaListaUserTeste {
    public static void main(String[] args) {
        CriaListaUser application = new CriaListaUser();
        application.openFile();
        application.addRecords();
        application.closeFile();

    } // end main
}   // end class CreateTextFileTest

