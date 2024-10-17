import java.io.File;

public class ChecksumTest {
    
    Checksum checksum;

    public boolean testeChecksum(char[] data) {
        checksum = new Checksum();
        char resultadoEsperado = 'W';

        int resultado = checksum.calculateChecksum(data);
        if((char) resultado == resultadoEsperado){
            return true;
        } else {
            return false;
        }
    }

    public boolean testeChecksumFile() {
        checksum = new Checksum();
        String filename = "teste.txt";
        char resultadoEsperado = 'W';

        try {
            int resultado = checksum.calculateChecksumFile(filename);
            if((char) resultado == resultadoEsperado){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean testeCriarNovoArquivoComChecksum() {
        checksum = new Checksum();
        String arquivoOriginal = "teste.txt";
        String novoArquivo = "teste2.txt";
        File arquivo = new File(novoArquivo);

        try {
            checksum.criarNovoArquivoComChecksum(arquivoOriginal, novoArquivo);
            if(arquivo.exists()){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean testeCRC(char[] data) {
        Checksum checksum = new Checksum();
        int restoEsperado = 2145812606; // valor esperado para a string "Casa1" usando CRC-16
        int resto = checksum.calulateCRC(data);

        if (resto == restoEsperado) {
            return true;
        } else {
            return false;
        }
    }

}
