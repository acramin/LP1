package Ex6;

import java.util.ArrayList;

public class BancoDeClientes {
    private ArrayList<Cliente> clientes;

    public BancoDeClientes(){
        this.clientes = new ArrayList<>();
    }

    public void inserirCliente(Cliente cliente){
        this.clientes.add(cliente);
        System.out.println();
        System.out.println("Cliente inserido.");
    }

    public void removerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                System.out.println();
                System.out.println("Cliente removido.");
                return; // sai assim que encontra
            }
        }
        System.out.println();
        System.out.println("Cliente com ID " + id + " não encontrado.");
    }

    public void alterarCliente(int id, String novoNome, String novoFone) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(novoNome);
                cliente.setFone(novoFone);
                return; // sai assim que encontra
            }
        }
        System.out.println();
        System.out.println("Cliente com ID " + id + " não encontrado.");
    }

    public void listarCliente(int id) { // informação de um único cliente
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                System.out.println();
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Telefone: " + cliente.getFone());
                return; // sai assim que encontra
            }
        }
        System.out.println();
        System.out.println("Cliente com ID " + id + " não encontrado.");
    }

    public void listarTodosClientes() {
        for (Cliente cliente : clientes) {
            System.out.println();
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getFone());
            System.out.println();
        }
        if(clientes.isEmpty()){
            System.out.println();
            System.out.println("Não existem clientes cadastrados.");
        }
    }
}
