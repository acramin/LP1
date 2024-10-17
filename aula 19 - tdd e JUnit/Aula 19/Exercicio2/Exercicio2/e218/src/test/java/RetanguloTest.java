import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ex2.*;

public class RetanguloTest {
    
    Retangulo retangulo;

    @Test
    @DisplayName("Teste de cálculo da área do retângulo")

    public void testRetanguloArea() {
        retangulo = new Retangulo(10, 2);
        assertEquals(20, retangulo.calcularArea());
    }

    @Test
    @DisplayName("Teste de cálculo do perímetro do retângulo")
    public void testRetanguloPerimetro() {
        retangulo = new Retangulo(10, 2);
        assertEquals(24, retangulo.calcularPerimetro());
    }

}
