import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ex1.*;

public class OrdenaTest 
{
    Ordena teste = new Ordena();
    
    // Teste de Ordenação com JUnit
        @Test
        @DisplayName("Teste de Ordenação")
        public void testOrdena() {

            int proposto[]  = new int[] {9, 10};
            int esperado[]  = new int[] {10, 9};
            int inesperado[] = new int[] {9}; // Teste de falha caso1

            teste.ordenaNumerosCrescentes(proposto);

            assertEquals(true, caso1Test(proposto.length, esperado.length));
            assertEquals(true, caso2Test(proposto, esperado));
    }

    public boolean caso1Test(int tamprop, int tampesp)
    {
        boolean resp = true;
        if(tamprop != tampesp) resp = false;
        return resp;
    }
    
    public boolean caso2Test(int[] prop, int[] esp)
    {
        return numerosIguais(prop, esp);
    }

    public boolean numerosIguais(int[] prop, int[] esp)
    {
        boolean resultado = true;
        for(int i = 0; i < prop.length; i++)
        {
            if(prop[i] != esp[i]){
                resultado = false;
                i = prop.length;    
            }  
        }
        return resultado;
    }
}
