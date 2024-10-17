import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame {

    JMenu menuVetor;
    JMenuBar bar;
    JMenuItem dimensionaItem, digitaItem, apresentaItem;
    JMenu menuProbest;
    JMenuItem mediaItem, desvpadItem, varianciaItem, medianaItem, coefassItem, coefvarItem;
    JMenu menuCDI;
    JMenuItem funcaoItem, derivadaItem;
    JMenu menuAlgesd;
    JMenuItem ordenacaoItem[], buscaItem[];

    Vetor vet = new Vetor(0);

    public Menu() {
        super("Menu");

        // CRIA VETOR
        menuVetor = new JMenu("Vetor");

        dimensionaItem = new JMenuItem("Dimensiona");
        digitaItem = new JMenuItem("Digitar");
        apresentaItem = new JMenuItem("Apresenta");

        menuVetor.add(dimensionaItem);
        menuVetor.add(digitaItem);
        menuVetor.add(apresentaItem);

        dimensionaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dimensiona(vet);
            }
        });

        digitaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Digita(vet);
                }
            }
        });

        apresentaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Apresenta(vet);
                }
            }
        });

        // ESTATISTICA
        menuProbest = new JMenu("PROBEST");

        mediaItem = new JMenuItem("Média");
        desvpadItem = new JMenuItem("Desvio Padrão");
        varianciaItem = new JMenuItem("Variância");
        medianaItem = new JMenuItem("Mediana");
        coefassItem = new JMenuItem("Coef. Assimetria");
        coefvarItem = new JMenuItem("Coef. Variação");

        menuProbest.add(mediaItem);
        menuProbest.add(desvpadItem);
        menuProbest.add(varianciaItem);
        menuProbest.add(medianaItem);
        menuProbest.add(coefassItem);
        menuProbest.add(coefvarItem);

        mediaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Media(vet);
                }
            }
        });

        desvpadItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new DesvPad(vet);
                }
            }
        });

        varianciaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Variancia(vet);
                }
            }
        });

        medianaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Mediana(vet);
                }
            }
        });

        coefassItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new CoefAss(vet);
                }
            }
        });

        coefvarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new CoefVar(vet);
                }
            }
        });

        // CALCULO -_-
        menuCDI = new JMenu("CDI");

        funcaoItem = new JMenuItem("Função");
        derivadaItem = new JMenuItem("Derivada");

        menuCDI.add(funcaoItem);
        menuCDI.add(derivadaItem);

        funcaoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Func(vet);
                }
            }
        });

        derivadaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vet.getTamanho() == 0) {
                    JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                } else {
                    new Derivada(vet);
                }
            }
        });

        // ALGORITMOS E ED
        ItemHandler itemHandler = new ItemHandler();

        menuAlgesd = new JMenu("ALGESD");

        JMenu ord = new JMenu("Ordenação");

        String ordenacao[] = {"Trocas", "Seleção", "Inserção", "Quick", "Merge"};

        ordenacaoItem = new JMenuItem[ordenacao.length];

        for (int count = 0; count < ordenacao.length; count++) {
            ordenacaoItem[count] = new JMenuItem(ordenacao[count]);
            ord.add(ordenacaoItem[count]);
            ordenacaoItem[count].addActionListener(itemHandler);
        }

        menuAlgesd.add(ord);
        menuAlgesd.addSeparator();

        JMenu bsc = new JMenu("Busca");

        String busca[] = {"Linear Iterativa", "Linear Recursiva", "Binária Iterativa", "Binária Recursiva"};

        buscaItem = new JMenuItem[busca.length];

        for (int count = 0; count < busca.length; count++) {
            buscaItem[count] = new JMenuItem(busca[count]);
            bsc.add(buscaItem[count]);
            buscaItem[count].addActionListener(itemHandler);
        }

        menuAlgesd.add(bsc);
        menuAlgesd.addSeparator();

        bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(menuVetor);
        bar.add(menuProbest);
        bar.add(menuCDI);
        bar.add(menuAlgesd);

        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ItemHandler implements ActionListener {
        private boolean sorted = false;
        private String msg = "", msg1 = "";

        public void actionPerformed(ActionEvent event) {

            Vetor aux = new Vetor(vet.getTamanho());
            for(int i = 0; i < vet.getTamanho(); i++){
                aux.setElemento(i, vet.getElemento(i));
            }

            for (int count = 0; count < ordenacaoItem.length; count++) {
                if (event.getSource() == ordenacaoItem[count]) {
                    if (vet.getTamanho() == 0) {
                        JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                    } else {
                        //System.out.println("Ordenação Selecionada: " + ordenacaoItem[count].getText());
                        switch (count) {
                            case 0:
                                msg = str(aux);
                                new Trocas(aux);
                                msg1 = str(aux);
                                JOptionPane.showMessageDialog(null, "Original = [" + msg + 
                "]\n Ordenado = [ " + msg1 + " ]");
                                break;
                            case 1:
                                msg = str(aux);
                                new Selecao(aux);
                                msg1 = str(aux);
                                JOptionPane.showMessageDialog(null, "Original = [" + msg + 
                "]\n Ordenado = [ " + msg1 + " ]");
                                break;
                            case 2:
                                msg = str(aux);
                                new Insercao(aux);
                                msg1 = str(aux);
                                JOptionPane.showMessageDialog(null, "Original = [" + msg + 
                "]\n Ordenado = [ " + msg1 + " ]");
                                break;
                            case 3: 
                                msg = str(aux);
                                new Quick(aux);
                                msg1 = str(aux);
                                JOptionPane.showMessageDialog(null, "Original = [" + msg + 
                "]\n Ordenado = [ " + msg1 + " ]");
                                break;
                            case 4: 
                                msg = str(aux);
                                new Merge(aux);
                                msg1 = str(aux);
                                JOptionPane.showMessageDialog(null, "Original = [" + msg + 
                "]\n Ordenado = [ " + msg1 + " ]");
                                break;
                            default:
                                break;
                        }
                        sorted = ord(aux);
                    }
                }
            }

            for (int count = 0; count < buscaItem.length; count++) {
                
                if (event.getSource() == buscaItem[count]) {
                    if (vet.getTamanho() == 0) {
                        JOptionPane.showMessageDialog(menuVetor, "Dimensione o vetor primeiro");
                    } else {
                        //System.out.println("Busca Selecionada: " + buscaItem[count].getText());
                        switch (count) {
                            case 0:
                                new LinIn(vet);
                                break;
                            case 1:
                                new LinRec(vet);
                                break;
                            case 2:
                                if(sorted){
                                    new Trocas(aux); // garantido que realmente estja ordenado 
                                    new BinIn(aux);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(menuVetor, "Ordene o vetor primeiro para usar essa opção");
                                    break;
                                }
                            case 3: 
                                if(sorted){
                                    new Trocas(aux); // garantido que realmente estja ordenado 
                                    new BinRec(aux);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(menuVetor, "Ordene o vetor primeiro para usar essa opção");
                                    break;
                                }
                            default:
                                break;
                        }
                        sorted = false;
                    }
                }
            }
        }
    }

    private boolean ord(Vetor v) {
        for (int i = 0; i < v.getTamanho() - 1; i++) {
            double current = v.getElemento(i);
            double next = v.getElemento(i + 1);
            //System.out.println("Comparação: " + current + " e " + next);
            if (current > next) {
                //System.out.println("Não ordenado: " + current + " > " + next);
                return false;
            }
        }
        return true;
    }

    private String str(Vetor v){
        String msg = "" + v.getElemento(0);
        for(int i = 1; i < v.getTamanho(); i++){
            msg =  msg +  "     " + v.getElemento(i);
        }
        return msg;
    }
    

}
