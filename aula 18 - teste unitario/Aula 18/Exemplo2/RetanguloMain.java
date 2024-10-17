package Exemplo2;

public class RetanguloMain {
    
    public static void main(String[] args) {
        RetanguloTest teste = new RetanguloTest();
        boolean resultado;

        resultado = teste.testeRetanguloArea();
        System.out.println("testeCalculaArea: " + resultado);

        resultado = teste.testeRetanguloPerimetro();
        System.out.println("testeCalculaPerimetro: " + resultado);
    }
}
