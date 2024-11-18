package SQL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenericDialog<T extends JComponent> extends JDialog {
    private T contentComponent;
    private JButton confirmButton;
    private JButton cancelButton;

    public GenericDialog(JFrame parent, String title, T contentComponent) {
        super(parent, title, true); // Configura o diálogo como modal
        this.contentComponent = contentComponent;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        add(contentComponent, BorderLayout.CENTER);

        // Configura os botões padrão (Confirmar e Cancelar)
        JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirmar");
        cancelButton = new JButton("Cancelar");

        confirmButton.addActionListener(e -> onConfirm());
        cancelButton.addActionListener(e -> onCancel());

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(getParent());
    }

    // Método para tratar a ação de confirmação
    protected void onConfirm() {
        dispose(); // Fecha o diálogo
    }

    // Método para tratar a ação de cancelamento
    protected void onCancel() {
        dispose(); // Fecha o diálogo
    }

    // Permite obter o componente associado ao conteúdo do diálogo
    public T getContentComponent() {
        return contentComponent;
    }

    // Métodos para personalizar os botões
    public void setConfirmButtonText(String text) {
        confirmButton.setText(text);
    }

    public void setCancelButtonText(String text) {
        cancelButton.setText(text);
    }

    public void addConfirmActionListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void addCancelActionListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe genérica
        JFrame frame = new JFrame("Exemplo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Criando um diálogo genérico com um JTextArea
        JTextArea textArea = new JTextArea(10, 30);
        GenericDialog<JTextArea> dialog = new GenericDialog<>(frame, "Diálogo Genérico", textArea);

        dialog.setConfirmButtonText("Salvar");
        dialog.setCancelButtonText("Fechar");
        dialog.addConfirmActionListener(e -> {
            String input = textArea.getText();
            JOptionPane.showMessageDialog(frame, "Conteúdo: " + input);
            dialog.dispose();
        });
        dialog.addCancelActionListener(e -> System.exit(0));

        dialog.setVisible(true);
    }
}
