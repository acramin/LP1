import javax.swing.JOptionPane;

import java.sql.Connection;
import java.util.ArrayList;

public class JavaMySqlApp {

    public static void main(String[] args) {
        String sMenu[] = {"Incluir Cliente", "Consultar Cliente", "Alterar Cliente", "Excluir Cliente", "Listar Clientes", 
                            "Sacar", "Depositar",  "Consultar Saldo", "Imprimir Saldo" , "Sair"};
        Gui gMenu = new Gui(sMenu);
        int iOption;
        Connection conn = ConnFactory.getConn();
        ArrayList<Cliente> aLista;
        Cliente cliente = new Cliente();
        ContaCorrrente conta = new ContaCorrrente();
        Agencia agencia = new Agencia();

            do {
                iOption = gMenu.getOption();
                switch (iOption) {
                    case 0: // Incluir Cliente
                        cliente.setNome(JOptionPane.showInputDialog(null, "Digite o Nome do Cliente:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE));
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE));
                        
                        conta.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Número da Conta:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE)));
                        conta.setDigito(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Dígito da Conta:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE)));
                        conta.setSaldo(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Saldo da Conta:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE)));
                        
                        agencia.setNome(JOptionPane.showInputDialog(null, "Digite o Nome da Agência:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE));
                        agencia.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Número da Agência:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE)));
                        agencia.setDigito(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Dígito da Agência:", "Incluir Cliente", JOptionPane.QUESTION_MESSAGE)));
                        
                        agencia.inserir(conn, agencia);
                        conta.setAgencia(agencia);
                        
                        conta.inserir(conta);
                        cliente.setConta(conta);

                        cliente.inserir(cliente);
                        break;

                    case 1: // Consultar Cliente
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF:", "Consultar", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if(cliente.getNome() == null){
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Cliente não encontrado", JOptionPane.INFORMATION_MESSAGE);
                        } else { 
                            JOptionPane.showMessageDialog(null, cliente.toString(), "Cliente Consultado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                        
                    case 2: // Alterar Cliente
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente a ser alterado:", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Alterar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            cliente.setNome(JOptionPane.showInputDialog(null, "Digite o novo Nome do Cliente:", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE));
                            cliente.atualizar(conn, cliente);
                            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Alterar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3: // Excluir Cliente
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente a ser excluído:", "Excluir Cliente", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Excluir Cliente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            cliente.getConta().deletar(conn, cliente.getConta());
                            cliente.getConta().getAgencia().deletar(conn, cliente.getConta().getAgencia());
                            cliente.deletar(cliente);
                            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Excluir Cliente", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4: // Listar Clientes
                        JOptionPane.showMessageDialog(null, "Acione OK para ver no console os clientes cadastrados!");
                        aLista = Cliente.buscarTodos();
                        for (Cliente c : aLista) {
                            System.out.println(c.toString());
                        }
                        System.out.println("------------------------------");
                        break;
                    case 5: // Sacar
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:", "Sacar", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Sacar", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser sacado:", "Sacar", JOptionPane.QUESTION_MESSAGE));
                            cliente.getConta().sacar( valorSaque);
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Sacar", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6: // Depositar
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:", "Depositar", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Depositar", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser depositado:", "Depositar", JOptionPane.QUESTION_MESSAGE));
                            cliente.getConta().depositar(valorDeposito);
                            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!", "Depositar", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7: // Consultar Saldo
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:", "Consultar Saldo", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Consultar Saldo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            double saldo = cliente.getConta().consultarSaldo();
                            JOptionPane.showMessageDialog(null, "Saldo: " + saldo, "Consultar Saldo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 8: // Imprimir Saldo
                        cliente.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:", "Imprimir Saldo", JOptionPane.QUESTION_MESSAGE));
                        cliente.consultar(conn, cliente);
                        if (cliente.getNome() == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Imprimir Saldo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            double saldo = cliente.getConta().consultarSaldo();
                            System.out.println("Saldo do Cliente " + cliente.getNome() + ": " + saldo);
                            JOptionPane.showMessageDialog(null, "Saldo impresso no console!", "Imprimir Saldo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 9: // Sair
                        System.exit(0);
                    break;
            }
        } while (iOption < sMenu.length - 1);
    }
}
