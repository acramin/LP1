public class Ordena {
    
    public void ordenaNumerosCrescentes(int[] vetor)
    {
        /*int rascunho;
        if(vetor[0] > vetor[1])
        {
            rascunho = vetor[1];
            vetor[1] = vetor[0];
            vetor[0] = rascunho;
        }*/ // versão inicial

        int iA, iB, iT;
        for(iA = 1; iA < vetor.length; iA++)
        {
            for(iB = vetor.length - 1; iB >= iA; iB--)
            {
                if(vetor[iB - 1] > vetor[iB])
                {
                    iT = vetor[iB - 1];
                    vetor[iB - 1] = vetor[iB];
                    vetor[iB] = iT;
                }
            }
        }
    }

}
