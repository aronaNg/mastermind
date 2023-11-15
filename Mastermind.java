import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mastermind {

    private static JPanel buttonPanel;
    static int numTour = 0;
    static int[] code = Solution.resetCode();
    static String[] colors;


    public static int getNumTour() {
        return numTour;
    }

    public static void addNumTour() {
        numTour ++;
    }

    public static JPanel getbuttonPanel() {
            return buttonPanel;
        }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mastermind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(416, 832);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Commencer une nouvelle partie");
        JMenuItem menuItem2 = new JMenuItem("Sauvegarder la partie");
        JMenuItem menuItem3 = new JMenuItem("Charger une ancienne partie");
        JMenuItem menuItem4 = new JMenuItem("Choisir l'ordre et la couleur des pions");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GridBagConstraints constraints = new GridBagConstraints();
                frame.remove(buttonPanel);
                buttonPanel = new JPanel(new GridLayout(16, 7));
                Button.createButtons(buttonPanel, constraints);
                frame.add(buttonPanel);
                frame.setVisible(true);
                numTour=0;
                Button.setSelectedHole();
                Button.setSelectedPawn();
                code = Solution.resetCode();
                for (int i = 0; i < 4; i++) {
                    System.out.println(code[i]);
                }
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour sauvegarder la partie
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour charger une ancienne partie   
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] colors = {"rouge", "bleu", "vert", "jaune", "orange", "violet", "blanc", "rose"};
                JComboBox<String> colorBox1 = new JComboBox<>(colors);
                JComboBox<String> colorBox2 = new JComboBox<>(colors);
                JComboBox<String> colorBox3 = new JComboBox<>(colors);
                JComboBox<String> colorBox4 = new JComboBox<>(colors);

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Choisissez la couleur du premier pion :"));
                panel.add(colorBox1);
                panel.add(new JLabel("Choisissez la couleur du deuxieme pion :"));
                panel.add(colorBox2);
                panel.add(new JLabel("Choisissez la couleur du troisieme pion :"));
                panel.add(colorBox3);
                panel.add(new JLabel("Choisissez la couleur du quatrieme pion :"));
                panel.add(colorBox4);
                
                int result = JOptionPane.showConfirmDialog(null, panel, "Choisir l'ordre et la couleur des pions", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String color1 = (String) colorBox1.getSelectedItem();
                    String color2 = (String) colorBox2.getSelectedItem();
                    String color3 = (String) colorBox3.getSelectedItem();
                    String color4 = (String) colorBox4.getSelectedItem();
                    if( color1 != color2 && color1 != color3 && color1 != color4 && color2 != color3 && color2 != color4 && color3 != color4) {
                        Button.setColors(color1, color2, color3, color4);
                        GridBagConstraints constraints = new GridBagConstraints();
                        frame.remove(buttonPanel);
                        buttonPanel = new JPanel(new GridLayout(16, 7));
                        Button.createButtons(buttonPanel, constraints);
                        frame.add(buttonPanel);
                        frame.setVisible(true);
                        code = Solution.resetCode();
                        for (int i = 0; i < 4; i++) {
                            System.out.println(code[i]);
                        }
                        numTour=0;
                        Button.setSelectedHole();
                        Button.setSelectedPawn();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Vous avez choisi deux couleurs identiques, veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        buttonPanel = new JPanel(new GridLayout(16, 7));
        buttonPanel.setPreferredSize(new Dimension(400, 800));

        GridBagConstraints constraints = new GridBagConstraints();

        Button.createButtons(buttonPanel, constraints);

        // Ajoute le JPanel contenant la grille de boutons au cadre
        frame.add(buttonPanel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2 + 10);

        frame.setVisible(true);
        for (int i = 0; i < 4; i++) {
            System.out.println(code[i]);
        }
    }

}
