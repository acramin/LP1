import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App extends JFrame implements ActionListener {
    // Widgets
    private JTextField fieldDisplay;
    /* Numbers */
    private JButton[] buttonNum = new JButton[10];
    private JButton buttonE, buttonPi;
    /* Operators Buttons */
    private JButton buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonEquals, buttonPow, buttonMod, buttonFac, buttonSqrt, buttonTrade, buttonP;
    /* Other Buttons */
    private JButton buttonClear, buttonDel;
    private JButton buttonpssw;
    private String username2;

    /* Variables */
    private String displayText = "";

    public App(String title, String username) {
        super(title);
        
        // Set Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Window
        Container window = getContentPane();
        JPanel northPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new GridLayout(5, 4));
        JPanel southPanel = new JPanel(new FlowLayout());

        // Display part
        fieldDisplay = new JTextField(displayText, 13);
        fieldDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        fieldDisplay.setEditable(false);
        northPanel.add(fieldDisplay);
        window.add(northPanel, BorderLayout.NORTH);

        // Buttons
        /* Numbers */
        for(int i = 0; i < 10; i ++){
            buttonNum[i] = new JButton(String.valueOf(i));
            buttonNum[i].addActionListener(this);
        }
        
        username2 = username;
        buttonE = new JButton("e");
        buttonE.addActionListener(this); 
        buttonPi = new JButton("π");
        buttonPi.addActionListener(this);
        
        /* Operators Buttons */
        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(this);
        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(this);
        buttonMult = new JButton("*");
        buttonMult.addActionListener(this);
        buttonDiv = new JButton("÷");
        buttonDiv.addActionListener(this);
        buttonEquals = new JButton("=");
        buttonEquals.addActionListener(this);
        buttonPow = new JButton("x^y");
        buttonPow.addActionListener(this);
        buttonMod = new JButton("|x|");
        buttonMod.addActionListener(this);
        buttonFac = new JButton("1/x");
        buttonFac.addActionListener(this);
        buttonSqrt = new JButton("√x");
        buttonSqrt.addActionListener(this);
        buttonTrade = new JButton("+/-");
        buttonTrade.addActionListener(this);
        buttonP = new JButton(".");
        buttonP.addActionListener(this);
        
        /* Other Buttons */
        buttonClear = new JButton("C");
        buttonClear.addActionListener(this);
        buttonDel = new JButton("DEL");
        buttonDel.addActionListener(this);

        buttonpssw = new JButton("Mudar Senha :)");
        buttonpssw.addActionListener(this);

        /* Add buttons */
        centerPanel.add(buttonClear);
        centerPanel.add(buttonDel);
        centerPanel.add(buttonP);
        centerPanel.add(buttonTrade);
        centerPanel.add(buttonPlus);

        centerPanel.add(buttonMod);
        centerPanel.add(buttonNum[7]);
        centerPanel.add(buttonNum[8]);
        centerPanel.add(buttonNum[9]);
        centerPanel.add(buttonMinus);

        centerPanel.add(buttonFac);
        centerPanel.add(buttonNum[4]);
        centerPanel.add(buttonNum[5]);
        centerPanel.add(buttonNum[6]);
        centerPanel.add(buttonMult);

        centerPanel.add(buttonPow);
        centerPanel.add(buttonNum[1]);
        centerPanel.add(buttonNum[2]);
        centerPanel.add(buttonNum[3]);
        centerPanel.add(buttonDiv);

        centerPanel.add(buttonSqrt);
        centerPanel.add(buttonNum[0]);
        centerPanel.add(buttonE);
        centerPanel.add(buttonPi);
        centerPanel.add(buttonEquals);

        southPanel.add(buttonpssw);

        window.add(centerPanel, BorderLayout.CENTER);

        window.add(southPanel, BorderLayout.SOUTH);

        // Window config.
        setSize(350, 225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        /* Options */
        if(e.getSource() == buttonClear){
            displayText = "";
            fieldDisplay.setText("");
        }
        else if(e.getSource() == buttonpssw){
            new SenhaWindow(username2);
            dispose();
        }
        else if(e.getSource() == buttonDel){
            if(displayText.length() > 0){
                displayText = displayText.substring(0, (displayText.length()-1));
                fieldDisplay.setText(displayText);
            }
        }
        else if(e.getSource() == buttonEquals){
            Calculus calculator = new Calculus();
            String result = calculator.result(displayText);
            displayText = result;
            fieldDisplay.setText(String.valueOf(result));
        }

        /* Operations */
        else if(e.getSource() == buttonPlus){
            displayText += " + ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonMinus){
            displayText += " - ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonMult){
            displayText += " * ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonDiv){
            displayText += " ÷ ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonPow){
            displayText += " ^ ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonP){
            displayText += ".";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonFac){
            displayText += "1 / ";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonSqrt){
            displayText = Math.sqrt(Double.parseDouble(displayText))+"";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonMod){
            try {
                double num = Double.parseDouble(displayText);
                num = Math.abs(num);
                displayText = String.valueOf(num);
                fieldDisplay.setText(displayText);
            } catch(NumberFormatException ex) {
                displayText = "Error";
                fieldDisplay.setText(displayText);
                displayText = "";
            }
        }
        else if(e.getSource() == buttonTrade){
            double num = Double.parseDouble(fieldDisplay.getText());
            num *= -1;
            displayText = num+"";
            fieldDisplay.setText(num+"");
        }

        /* Numbers */
       for(int i = 0; i < 10; i++){
            if(e.getSource() == buttonNum[i]){
                displayText += i;
                fieldDisplay.setText(displayText);
            }
        }

        if(e.getSource() == buttonPi){
            displayText += "π";
            fieldDisplay.setText(displayText);
        }
        else if(e.getSource() == buttonE){
            displayText += "e";
            fieldDisplay.setText(displayText);
        }

    }
}
