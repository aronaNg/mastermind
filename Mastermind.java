import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;

public class Mastermind {

    private static JPanel buttonPanel;
    static int numTour = 0;
    static int[] code = Solution.resetCode();
    static String[] colors={"rouge", "bleu", "jaune", "vert"};
    static List<Integer> results = new ArrayList<>();
    static List<Integer> Tries = new ArrayList<>();

    public static void resetResults() {
        results = new ArrayList<>();
    }

    public static void resetTries() {
        Tries = new ArrayList<>();
    }

    public static void addTries(int trie) {
        Tries.add(trie);
    }

    public static List<Integer> getTries() {
        return Tries;
    }

    public static void addResults(int result) {
        results.add(result);
    }

    public static List<Integer> getResults() {
        return results;
    }

    public static void setColors(String[] colors) {
        Mastermind.colors = colors;
    }

    public static int getNumTour() {
        return numTour;
    }

    public static void addNumTour() {
        numTour ++;
    }

    public static JPanel getbuttonPanel() {
            return buttonPanel;
        }
    
    public static JFrame frame = new JFrame("Mastermind");

    public static void printCode() {
        for (int i = 0; i < 4; i++) {
            System.out.println(code[i]);
        }
    }

    public static void main(String[] args) {
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
                Button.resetButtons();
                Button.resetPawns();
                Button.resetHoles();
                numTour = 0;
                Button.setSelectedHole();
                Button.setSelectedPawn();
                code = Solution.resetCode();
                for (int i = 0; i < 4; i++) {
                    System.out.println(code[i]);
                }
                GridBagConstraints constraints = new GridBagConstraints();
                frame.remove(buttonPanel);
                JPanel buttonPanel1 = new JPanel(new GridLayout(16, 7));
                Button.createButtons(buttonPanel1, constraints);
                frame.add(buttonPanel1);
                frame.setVisible(true);
                
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Entrez le nom du fichier de sauvegarde :");
                if (fileName != null && !fileName.isEmpty()) {
                    try {
                        FileWriter writer = new FileWriter("saves/" + fileName);
                        writer.write("numTour=" + numTour + "\n");
                        writer.write("code=");
                        for (int i = 0; i < code.length; i++) {
                            writer.write(code[i] + ",");
                        }
                        writer.write("\n");
                        writer.write("colorsSet=");
                        for (int i = 0; i < colors.length; i++) {
                            writer.write(colors[i] + ",");
                        }
                        writer.write("\n");
                        writer.write("results=");
                        getResults().forEach((result) -> {
                            try {
                                writer.write(result + ",");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Erreur lors de la sauvegarde de la partie : " + ex.getMessage());
                            }
                        });
                        writer.write("\n");
                        writer.write("tries=");
                        getTries().forEach((trie) -> {
                            try {
                                writer.write(trie + ",");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Erreur lors de la sauvegarde de la partie : " + ex.getMessage());
                            }
                        });
                        writer.write("\n");
                        writer.close();
                        JOptionPane.showMessageDialog(null, "La partie a ete sauvegardee avec succes !");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la sauvegarde de la partie : " + ex.getMessage());
                    }
                }
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour charger une ancienne partie
                File savesDirectory = new File("saves");
                File[] saveFiles = savesDirectory.listFiles();
                if (saveFiles == null || saveFiles.length == 0) {
                    JOptionPane.showMessageDialog(null, "Aucune sauvegarde trouvee.");
                    return;
                }
                JComboBox<File> saveBox = new JComboBox<>(saveFiles);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Choisissez la sauvegarde à charger :"));
                panel.add(saveBox);
                int result = JOptionPane.showConfirmDialog(null, panel, "Charger une ancienne partie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    File selectedSave = (File) saveBox.getSelectedItem();
                    try {
                        Scanner scanner = new Scanner(selectedSave);
                        String line = scanner.nextLine();
                        numTour = Integer.parseInt(line.substring(8));
                        line = scanner.nextLine();
                        String[] codeStrings = line.substring(5).split(",");
                        for (int i = 0; i < codeStrings.length; i++) {
                            code[i] = Integer.parseInt(codeStrings[i]);
                        
                        }
                        line = scanner.nextLine();
                        String[] colorSaved = line.substring(10).split(",");
                        for (int i = 0; i < colorSaved.length; i++) {
                            colors[i] = colorSaved[i];
                        }
                        Button.setColors(colors[0], colors[1], colors[2], colors[3]);
                        line = scanner.nextLine();
                        resetResults();
                        String[] resultsSaved = line.substring(8).split(",");
                        for (int i = 0; i < resultsSaved.length; i++) {
                            results.add(Integer.parseInt(resultsSaved[i]));
                        }
                        line = scanner.nextLine();
                        resetTries();
                        String[] triesSaved = line.substring(6).split(",");
                        for (int i = 0; i < triesSaved.length; i++) {
                            Tries.add(Integer.parseInt(triesSaved[i]));
                        }
                        scanner.close();
                        int[] triesArray = Tries.stream().mapToInt(Integer::intValue).toArray();
                        int[] resultsArray = results.stream().mapToInt(Integer::intValue).toArray();
                        Button.restart(buttonPanel, numTour, triesArray, resultsArray, colors);
                        JOptionPane.showMessageDialog(null, "La partie a ete chargee avec succes !");
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur lors du chargement de la partie : " + ex.getMessage());
                    }
                }
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
                        String[] colorsToSave = {color1, color2, color3, color4};
                        setColors(colorsToSave);
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
                        resetResults();
                        resetTries();
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
