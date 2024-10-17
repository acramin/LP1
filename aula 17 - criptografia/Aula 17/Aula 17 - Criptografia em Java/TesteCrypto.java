// Classe “TesteCrypto.java”
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TesteCrypto {
    public static void main(String[] args) throws Exception {
        String sMsgClara = null;
        byte[] bMsgClara = null;
        byte[] bMsgCifrada = null;
        byte[] bMsgDecifrada = null;

        // LEITURA DO ARQUIVO DE TEXTO
        // Caminho do arquivo de texto
        File arquivoTexto = new File("mensagem.txt");

        // Lê o conteúdo do arquivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoTexto))) {
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha);
                sb.append(System.lineSeparator());
            }
            sMsgClara = sb.toString().trim(); // Remove o último line separator
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // FIM DA LEITURA DO ARQUIVO DE TEXTO

        // Converte o texto String dado no equivalente byte[]
        bMsgClara = sMsgClara.getBytes("ISO-8859-1");

        // Instancia objeto da classe Impressora
        Impressora prn = new Impressora();

        // Abre os arquivos para escrita
        try (BufferedWriter writerCifrada = new BufferedWriter(new FileWriter("texto_cifrada.txt"));
             BufferedWriter writerDecifrada = new BufferedWriter(new FileWriter("texto_decifrada.txt"))) {

            /*
             * Criptografia Dummy ------------------------------------------------------------
             */
            CryptoDummy cdummy = new CryptoDummy();
            cdummy.geraChave(new File("chave.dummy"));
            cdummy.geraCifra(bMsgClara, new File("chave.dummy"));
            bMsgCifrada = cdummy.getTextoCifrado();

            // Escreve o texto cifrado Dummy no arquivo
            writerCifrada.write("Mensagem Cifrada com Dummy (Hexadecimal):\n");
            writerCifrada.write(prn.hexBytesToString(bMsgCifrada));
            writerCifrada.write("\n\nMensagem Cifrada com Dummy (String):\n");
            writerCifrada.write(new String(bMsgCifrada, "ISO-8859-1"));
            writerCifrada.write("\n\n");

            cdummy.geraDecifra(bMsgCifrada, new File("chave.dummy"));
            bMsgDecifrada = cdummy.getTextoDecifrado();

            // Escreve o texto decifrado Dummy no arquivo
            writerDecifrada.write("Mensagem Decifrada com Dummy (Hexadecimal):\n");
            writerDecifrada.write(prn.hexBytesToString(bMsgDecifrada));
            writerDecifrada.write("\n\nMensagem Decifrada com Dummy (String):\n");
            writerDecifrada.write(new String(bMsgDecifrada, "ISO-8859-1"));
            writerDecifrada.write("\n\n");

            /*
             * Criptografia AES --------------------------------------------------------------
             */
            CryptoAES caes = new CryptoAES();
            caes.geraChave(new File("chave.simetrica"));
            caes.geraCifra(bMsgClara, new File("chave.simetrica"));
            bMsgCifrada = caes.getTextoCifrado();

            // Escreve o texto cifrado AES no arquivo
            writerCifrada.write("Mensagem Cifrada com AES (Hexadecimal):\n");
            writerCifrada.write(prn.hexBytesToString(bMsgCifrada));
            writerCifrada.write("\n\nMensagem Cifrada com AES (String):\n");
            writerCifrada.write(new String(bMsgCifrada, "ISO-8859-1"));
            writerCifrada.write("\n\n");

            caes.geraDecifra(bMsgCifrada, new File("chave.simetrica"));
            bMsgDecifrada = caes.getTextoDecifrado();

            // Escreve o texto decifrado AES no arquivo
            writerDecifrada.write("Mensagem Decifrada com AES (Hexadecimal):\n");
            writerDecifrada.write(prn.hexBytesToString(bMsgDecifrada));
            writerDecifrada.write("\n\nMensagem Decifrada com AES (String):\n");
            writerDecifrada.write(new String(bMsgDecifrada, "ISO-8859-1"));
            writerDecifrada.write("\n\n");

            /*
             * Criptografia RSA --------------------------------------------------------------
             */
            CryptoRSA crsa = new CryptoRSA();
            crsa.geraParDeChaves(new File("chave.publica"), new File("chave.privada"));
            crsa.geraCifra(bMsgClara, new File("chave.publica"));
            bMsgCifrada = crsa.getTextoCifrado();

            // Escreve o texto cifrado RSA no arquivo
            writerCifrada.write("Mensagem Cifrada com RSA (Hexadecimal):\n");
            writerCifrada.write(prn.hexBytesToString(bMsgCifrada));
            writerCifrada.write("\n\nMensagem Cifrada com RSA (String):\n");
            writerCifrada.write(new String(bMsgCifrada, "ISO-8859-1"));
            writerCifrada.write("\n\n");

            crsa.geraDecifra(bMsgCifrada, new File("chave.privada"));
            bMsgDecifrada = crsa.getTextoDecifrado();

            // Escreve o texto decifrado RSA no arquivo
            writerDecifrada.write("Mensagem Decifrada com RSA (Hexadecimal):\n");
            writerDecifrada.write(prn.hexBytesToString(bMsgDecifrada));
            writerDecifrada.write("\n\nMensagem Decifrada com RSA (String):\n");
            writerDecifrada.write(new String(bMsgDecifrada, "ISO-8859-1"));
            writerDecifrada.write("\n\n");

        } catch (IOException e) {
            System.err.println("Erro ao escrever nos arquivos: " + e.getMessage());
        }
    }
}
