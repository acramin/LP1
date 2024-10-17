package Ex4;

import java.util.ArrayList;

public class BlocoDeNotas {
    private ArrayList<String> notas;

    public BlocoDeNotas(){
        this.notas = new ArrayList<String>();
    }

    public void inserirNota(String nota) {
        this.notas.add(nota);
    }

    public void removerNota(String nota) {
        if (this.notas.remove(nota)) System.out.println("Nota removida!"); // se foi possivel remover é pq a nota existe
        else System.out.println("Nota não encontrada.");
    }

    public void buscarNota(String nota) {
        if (this.notas.contains(nota)) System.out.println("Nota encontrada: " + nota); // ve se o array tem a string procurada
        else System.out.println("Nota não encontrada.");
    }

    public void imprimirNotas() {
        System.out.println("Notas:");
        for (String nota : this.notas) 
                System.out.println(nota);
        
    }
}
