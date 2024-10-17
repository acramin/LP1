public class CalculadoraTest {
    
    private Calculadora calculadora;
    
    public void testeCalculadoraSoma(){
        calculadora = new Calculadora();
        int resultadoEsperado = 4;

        int resultado = calculadora.somar(2, 2);

        if(resultado == resultadoEsperado){
            System.out.println("Teste OK");
        } else {
            System.out.println("Teste Falhou");
        }
    }
}
