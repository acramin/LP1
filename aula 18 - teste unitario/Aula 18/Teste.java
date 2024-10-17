import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        // Todos os teste retornam true se entrada for Casa1
        // Para qualquer outra entrada, os testes Checksum e CRC retornam false
        // O teste ChecksumFile retorna false se o arquivo teste.txt não existir, 
        // ou se o checksum calculado for diferente de W (texto do arquivo teste.txt é Casa1)
        // O teste CriarNovoArquivoComChecksum retorna false se o arquivo teste2.txt não for criado

        
        ChecksumTest checksumTest = new ChecksumTest();

        Scanner sc = new Scanner(System.in);
        System.out.println("mensagem: ");
        String s = sc.nextLine();
        char[] data = s.toCharArray();
        sc.close();

        System.out.println("Teste Checksum: " + checksumTest.testeChecksum(data));

        System.out.println("Teste ChecksumFile: " + checksumTest.testeChecksumFile());

        System.out.println("Teste CriarNovoArquivoComChecksum: " + checksumTest.testeCriarNovoArquivoComChecksum());

        System.out.println("Teste CRC: " + checksumTest.testeCRC(data));
    }
}
