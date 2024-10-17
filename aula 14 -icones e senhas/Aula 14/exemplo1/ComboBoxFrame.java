package exemplo1;
// usando uma JComboBox para selecionar um ícone para exibir
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboBoxFrame extends JFrame{
    private JComboBox imagesJComboBox; // combobox para armazenar os nomes dos ícones
    private JLabel label; // label para mostar o ícone selecionado
    private String[] names = {"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif"};
    private Icon[] icons = {new ImageIcon(getClass().getResource(names[0])), 
                            new ImageIcon(getClass().getResource(names[1])), 
                            new ImageIcon(getClass().getResource(names[2])), 
                            new ImageIcon(getClass().getResource(names[3]))};
    
    public ComboBoxFrame(){
        super("Testando JComboBox");
        setLayout(new FlowLayout()); // especifica o layout do frame
        
        imagesJComboBox = new JComboBox(names); // programa JComboBox
        imagesJComboBox.setMaximumRowCount(3); // mostra 3 linhas
        
        imagesJComboBox.addItemListener( 
            new ItemListener(){ // manipulador de eventos para JComboBox
                public void itemStateChanged(ItemEvent event){ // determina se o check box foi selecionado
                    if(event.getStateChange() == ItemEvent.SELECTED)
                        label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                }
            }
        );
        
        add(imagesJComboBox); // add combobox ao JFrame
        label = new JLabel(icons[0]); // apresenta o 1° ícone
        add(label); // add label ao JFrame
    }
}