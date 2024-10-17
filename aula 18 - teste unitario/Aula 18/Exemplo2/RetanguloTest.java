package Exemplo2;

public class RetanguloTest {
    
    Retangulo retangulo;

    public boolean testeRetanguloArea() {
        retangulo = new Retangulo(10, 2);
        int resultadoEsperado = 20;

        int resultado = retangulo.calcularArea();
        if(resultado == resultadoEsperado){
            //System.out.println("Teste OK");
            return true;
        } else {
            //System.out.println("Teste Falhou");
            return false;
        }
    }

    public boolean testeRetanguloPerimetro() {
        retangulo = new Retangulo(10, 2);
        int resultadoEsperado = 24;

        int resultado = retangulo.calcularPerimetro();
        if(resultado == resultadoEsperado){
            //System.out.println("Teste OK");
            return true;
        } else {
            //System.out.println("Teste Falhou");
            return false;
        }
    }

}
