import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import example.*;

public class CalcTest {
    Calc c = new Calc();

    @Test
    @DisplayName("Teste de soma")

    public void testSoma() {
        assertEquals(4, c.soma(2, 2));
    }
}
