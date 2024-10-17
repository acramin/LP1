package ex5;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Checksum {
    
    public Checksum() {}

    
    public int calculateChecksum(char[] data) {
        int checksum = 0;
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        checksum = (~sum + 1) & 0xFF;
        return checksum;
    }


    public int calculateChecksumFile(String filename) throws Exception {
        FileInputStream fis = null;
        int soma = 0;

        try {
            fis = new FileInputStream(filename);
            int byteLido;

            while ((byteLido = fis.read()) != -1) {
                soma += byteLido;
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        int checksum = (~soma + 1) & 0xFF;
        return checksum; 
    }

    public void criarNovoArquivoComChecksum(String arquivoOriginal, String novoArquivo) throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int checksum = calculateChecksumFile(arquivoOriginal);

        try {
            fis = new FileInputStream(arquivoOriginal);
            fos = new FileOutputStream(novoArquivo);

            int byteLido;
            
            while ((byteLido = fis.read()) != -1) {
                fos.write(byteLido);
            } fos.write(checksum);
            
        } finally {
            if (fis != null) {
                fis.close();
            }

            if (fos != null) {
                fos.close();
            }
        }
    }

    public int calulateCRC(char[] data) {
        int resto = 0;
        int pol = 0x8005;  
        int ordem = 0x8000; 
        
        for (int i = 0; i < data.length; i++) { 
            resto ^= (data[i] << 15); 
            for (int j = 0; j < 15; j++) { 
                if ((resto & ordem) != 0) { 
                    resto = (resto << 1) ^ pol;
                } else {
                    resto = (resto << 1);
                }
            }
        }
        return resto;
    }

}
