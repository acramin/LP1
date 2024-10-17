package Ex5;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixa;

    public Deposito(){
        this.caixa = new ArrayList<>();
    }

    public void inserirCaixa(Caixa caixa){
        this.caixa.add(caixa);
    }

    public void removerCaixa(String dono){
        for (int i = 0; i < this.caixa.size(); i++) { // passa por todas as caixas
            if (this.caixa.get(i).getDono().equals(dono)) { // se o dono da caixa atual corresponde ao dono digitado
                this.caixa.remove(i); // remover a caixa atual
                break;
            }
        }
    }

    public int procurarCaixa(String dono) {
        for (int i = 0; i < this.caixa.size(); i++) { // passa por todas as caixas
            if (this.caixa.get(i).getDono().equals(dono)) { // se o dono da caixa atual corresponde ao dono digitado
                return i; // retorna indice da caixa ! indice no arrayList !
            }
        }
        return -1;
    }

    public void mudarCaixa(String dono, String novoCorredor, int novaPosicao) {
        int i = procurarCaixa(dono); // procura a caixa que tera atributos alterados
        if (i != -1) { // se encontrou
            Caixa caixa = this.caixa.get(i); // pega a caixa 
            caixa.setCorredor(novoCorredor); // muda corredor
            caixa.setPosicao(novaPosicao);   // muda posição
        }
    }

    public ArrayList<Caixa> caixaMaisPesadas(double pesoLimite) {
        ArrayList<Caixa> caixaPesadas = new ArrayList<>();  // 'vetor' de caixas pesadas
        for (Caixa caixa : this.caixa) { // percorre todas as caixas
            if (caixa.getPeso() > pesoLimite) { // compara peso com o limite
                caixaPesadas.add(caixa); // se for maior q o limte, add na lista de caixas pesadas
            }
        }
        return caixaPesadas; // retorna lista de caixas pesadas
    }

}
