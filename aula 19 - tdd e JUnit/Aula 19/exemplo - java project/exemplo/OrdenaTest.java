package Exemplo1;

public class OrdenaTest 
{
    
    public OrdenaTest() 
    {
        int proposto[]  = new int[] {10, 9};
        int esperado[]  = new int[] {9, 10};
        int inesperado[] = new int[] {9}; // Teste de falha

    Ordena teste = new Ordena();
    teste.ordenaNumerosCrescentes(proposto);

    System.out.println("Teste de Ordenação\n====================");
    System.out.println("Ficou com o mesmo tamanho: " + caso1Test(proposto.length, esperado.length));
    System.out.println("Ordenou com sucesso: " + caso2Test(proposto, esperado));
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
