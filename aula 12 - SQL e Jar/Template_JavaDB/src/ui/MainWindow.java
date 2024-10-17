package ui;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
    // Widgets
    /*private JLabel title;
    private JTextField text;
    private JButton button;*/

    public MainWindow(String title){
        super(title);

        // Layout
        Container window = getContentPane();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();

        // Inst. widgets

        // Add panels
        window.add(northPanel, BorderLayout.NORTH);
        window.add(southPanel, BorderLayout.SOUTH);
        window.add(centerPanel, BorderLayout.CENTER);
        window.add(westPanel, BorderLayout.WEST);
        window.add(eastPanel, BorderLayout.EAST);

        // Window config.
        //setSize(X, Y);
        setSize(300, 115);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Button events
    public void actionPerformed(ActionEvent e){
        ///if(e.getSource()){
        ///}
    }
}
