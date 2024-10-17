import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ex5.*;

//import java.io.File;

public class ChecksumTest {
    
    Checksum checksum;

    /*@Test
    @DisplayName("Teste de checksum")
    public void testeChecksum() {
        char[] data = {'C', 'a', 's', 'a', '1'};
        assertEquals(true, testeChecksum(data));
    }

    public boolean testeChecksum(char[] data) {
        checksum = new Checksum();
        char resultadoEsperado = 'W';

        int resultado = checksum.calculateChecksum(data);
        if((char) resultado == resultadoEsperado){
            return true;
        } else {
            return false;
        }
    }*/

    /*@Test
    @DisplayName("Teste de checksum de arquivo")
    public void ChecksumFileTeste() {
        assertEquals(true, testeChecksumFile());
    }

    @Test
    @DisplayName("Teste de criar novo arquivo com checksum")
    public void CriarNovoArquivoComChecksumTest() {
        assertEquals(true, testeCriarNovoArquivoComChecksum());
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
    }*/

    @Test
    @DisplayName("Teste de CRC")
    public void CRCTeste() {
        char[] data = {'C', 'a', 's', 'a', '1'};
        assertEquals(true, testeCRC(data));
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
