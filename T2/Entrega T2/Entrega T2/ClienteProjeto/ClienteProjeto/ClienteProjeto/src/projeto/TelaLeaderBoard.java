package projeto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import projeto.Message.Action;


import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.logging.*;
import java.util.Arrays;

import java.util.ResourceBundle;
import java.util.Locale;

public class TelaLeaderBoard extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private String[][] partidas;
    private volatile boolean running = true;

    Player player;
    Grid grid;
    Socket socket;
    ClienteService service;

    Object[][] data = new Object[][]{};
    String[] columnNames = new String[]{};

    ResourceBundle bundle = LanguageManager.getResourceBundle();

    public TelaLeaderBoard(Grid grid, Player player, ClienteService service, Socket socket) {

        this.service = service;
        this.player = player;
        this.grid = grid;
        this.socket = socket;
        
        // Set the title and layout for the frame
        setTitle(bundle.getString("leaderboardTitle"));
        setLayout(new BorderLayout());

        String[] comboBoxItems = {bundle.getString("vitoriaAno"), bundle.getString("vitoriaMes"), bundle.getString("vitoriaSemana"),
                                  bundle.getString("derrotaAno"), bundle.getString("derrotaMes"), bundle.getString("derrotaSemana"),};
        JComboBox<String> comboBox = new JComboBox<>(comboBoxItems);

        // Style the JComboBox
        comboBox.setBackground(new Color(7, 8, 28));             // Dark background
        comboBox.setForeground(Color.WHITE);                     // White text color
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Set a larger font size
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(44, 46, 95))); // Border matches other components
        comboBox.setFocusable(false);                            // Remove focus border for a cleaner look

        // Custom UI to ensure dropdown button matches color scheme
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new Color(44, 46, 95));     // Dark blue background for arrow button
                button.setBorder(BorderFactory.createLineBorder(new Color(44, 46, 95))); // Matching border
                return button;
            }
        });

// Center-align text in each item in the combo box dropdown and ensure background consistency
comboBox.setRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        label.setBackground(isSelected ? new Color(44, 46, 95) : new Color(7, 8, 28)); // Dark background
        label.setForeground(Color.WHITE); // White text color
        return label;
    }
});

// Update the ComboBox editor to set its background and alignment
comboBox.setEditor(new BasicComboBoxEditor() {
    @Override
    protected JTextField createEditorComponent() {
        JTextField editor = super.createEditorComponent();
        editor.setBackground(new Color(7, 8, 28)); // Dark background
        editor.setForeground(Color.WHITE); // White text color
        editor.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        return editor;
    }
});
comboBox.setEditable(true); // Make ComboBox editable to apply the editor customization
comboBox.setSelectedItem(bundle.getString("vitoriaAno"));
add(comboBox, BorderLayout.NORTH);

        // Initialize JTable with an empty model and add it to a scroll pane
        String[] initialColumnNames = {bundle.getString("celulaJogador"), bundle.getString("celulaVitorias")};
        tableModel = new DefaultTableModel(new Object[][]{}, initialColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // All cells are non-editable
            }
        };
        
        // Create the JTable with the non-editable model
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true); // Make the table fill the scroll pane area
        table.setRowHeight(28); // Set the row height to 30 pixels (adjust as needed)

        // Set font size and style for the table cells
        table.setFont(new Font("SansSerif", Font.PLAIN, 16)); // 16-point font size

        // Center-align text in each cell
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane tableScrollPane = new JScrollPane(table);

        // Set the background behind the table
        tableScrollPane.getViewport().setBackground(new Color(7, 8, 28));

        // Remove or customize the border of the JScrollPane
        tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(7, 8, 28)));

        // Style table cell colors
        table.setBackground(new Color(7, 8, 28));            // Dark background for cells
        table.setForeground(Color.WHITE);                    // White text color for cells
        table.setSelectionBackground(new Color(44, 46, 95)); // Dark blue for selected cells
        table.setSelectionForeground(Color.WHITE);           // White text for selected cells
        table.setGridColor(new Color(44, 46, 95));           // Dark blue grid color

        // Customize header colors and remove border
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(44, 46, 95));         // Dark blue background for header
        header.setForeground(Color.WHITE);                   // White text color for header
        header.setBorder(new LineBorder(new Color(44, 46, 95))); // Border matches header color

        // Add table to the center
        add(tableScrollPane, BorderLayout.CENTER);

        // Create and style the "Voltar" button
        JButton button = new JButton(bundle.getString("voltar"));
        button.setBackground(new Color(44, 46, 95));
        // Dark blue background for button
        button.setForeground(Color.WHITE);                   // White text color for button
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(44, 46, 95))); // Border matches button color

        add(button, BorderLayout.SOUTH);

        // Load initial table data
        updateTableData(bundle.getString("vitoriaAno"));

        // Set default close operation and frame size, then display the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);

        // Create a new thread to listen for incoming messages from the server
        Thread thread = new Thread(new ListenerSocket(socket));
        thread.start();

        // Add action listener to JComboBox to update table data on selection change
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                updateTableData(selectedOption);
            }
        });

        // Add action listener to "Voltar" button to return to initial screen
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaInicial(grid, player, service, socket);
                Message message = new Message();
                message.setAction(Action.TELA_LEADERBOARD);
                service.envia(message);
                thread.interrupt();
                stop();
                dispose();
                
            }
        });

        
        
        
        
    }


    private void updateTableData(String selectedOption) {
        Message message = new Message();

        if (selectedOption.equals(bundle.getString("vitoriaAno"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_ANO_VITORIA);
            service.envia(message);
        } else if (selectedOption.equals(bundle.getString("vitoriaMes"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_MES_VITORIA);
            service.envia(message);
        } else if (selectedOption.equals(bundle.getString("vitoriaSemana"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_SEMANA_VITORIA);
            service.envia(message);
        } else if (selectedOption.equals(bundle.getString("derrotaAno"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_ANO_DERROTA);
            service.envia(message);
        } else if (selectedOption.equals(bundle.getString("derrotaMes"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_MES_DERROTA);
            service.envia(message);
        } else if (selectedOption.equals(bundle.getString("derrotaSemana"))) {
            message.setAction(Message.Action.TELA_LEADERBOARD_SEMANA_DERROTA);
            service.envia(message);
        }

    }
    
        private class ListenerSocket implements Runnable
    {
        private ObjectInputStream input;
        

        public ListenerSocket(Socket socket)
        {
            
            this.input = service.getInput();
            
        }

        @Override
        public void run()
        {
            Message message = null;
            try
                {
                    while (running)
                        {
                            if (Thread.currentThread().isInterrupted()) {
                                break; // Sai do loop se a thread for interrompida
                            }
                            message = (Message) input.readObject();


                            Action action = message.getAction();
                            //System.out.println("Action received: " + action); // Debug statement

                            if(action.equals(Action.TELA_LEADERBOARD_ANO_VITORIA))
                            {
                                
                                //System.out.println("ENTRO");
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaVitorias")};
                                //System.out.println(Arrays.deepToString(data));
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD_MES_VITORIA))
                            {
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaVitorias")};
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD_SEMANA_VITORIA))
                            {
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaVitorias")};
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD_ANO_DERROTA))
                            {
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaDerrotas")};
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD_MES_DERROTA))
                            {
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaDerrotas")};
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD_SEMANA_DERROTA))
                            {
                            
                                partidas = message.getLeaderboard();
                                data = partidas;
                                columnNames = new String[]{bundle.getString("celulaJogador"), bundle.getString("celulaDerrotas")};
                                tableModel.setDataVector(data, columnNames);
                            }
                            if(action.equals(Action.TELA_LEADERBOARD))
                            {
                                running = false;
                                System.out.println("RECEBA"+running);
                                break;
                            }
                            //System.out.println("RECEBA"+running);
                    }

                }
            catch(IOException e)
            {
                
            }
            catch(ClassNotFoundException e)
            {
                
            }
            
        }

    }
    public void stop() {
        running = false;
    }
}
