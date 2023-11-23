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

/**
 * Classe principale du jeu Mastermind.
 * Cette classe gère l'interface graphique et les interactions avec l'utilisateur.
 * Elle permet également de sauvegarder et de charger des parties.
 */

public class Mastermind {

    private static JPanel buttonPanel;
    static int numTour = 0;

    /**
     * Le code secret à deviner.
     */
    static int[] code = Solution.resetCode();

    //Les couleurs de base.
    static String[] colors={"rouge", "bleu", "jaune", "vert"};

    static List<Integer> results = new ArrayList<>();
    static List<Integer> Tries = new ArrayList<>();

    /**
     * Réinitialise la liste des résultats.
     */
    public static void resetResults() {
        results = new ArrayList<>();
    }

    /**
     * Réinitialise la liste des essais.
     */
    public static void resetTries() {
        Tries = new ArrayList<>();
    }

    /**
     * Ajoute un essai à la liste des essais.
     * @param trie l'essai à ajouter.
     */
    public static void addTries(int trie) {
        Tries.add(trie);
    }

    /**
     * Renvoie la liste des essais.
     * @return la liste des essais.
     */
    public static List<Integer> getTries() {
        return Tries;
    }

    /**
     * Ajoute un résultat à la liste des résultats.
     * @param result le résultat à ajouter.
     */
    public static void addResults(int result) {
        results.add(result);
    }

    /**
     * Renvoie la liste des résultats.
     * @return la liste des résultats.
     */
    public static List<Integer> getResults() {
        return results;
    }

    /**
     * Modifie les couleurs sélectionnnées pour les pions.
     * @param colors les nouvelles couleurs sélectionnées.
     */
    public static void setColors(String[] colors) {
        Mastermind.colors = colors;
    }

    /**
     * Renvoie le numéro du tour actuel.
     * @return le numéro du tour actuel.
     */
    public static int getNumTour() {
        return numTour;
    }

    /**
     * Incrémente le numéro du tour actuel.
     */
    public static void addNumTour() {
        numTour ++;
    }

    /**
     * Renvoie le panneau contenant les boutons du jeu.
     * @return le panneau contenant les boutons du jeu.
     */
    public static JPanel getbuttonPanel() {
            return buttonPanel;
        }
    
    public static JFrame frame = new JFrame("Mastermind");

    /**
     * Réinitialise la partie avec une sauvegarde sélectionnée.
     */
    public static void restart(){
        Button.resetButtons();
        Button.resetPawns();
        Button.resetHoles();
        Button.setSelectedHole();
        Button.setSelectedPawn();
        GridBagConstraints constraints = new GridBagConstraints();
        frame.remove(buttonPanel);
        buttonPanel = new JPanel(new GridLayout(16, 7));
        Button.createButtons(buttonPanel, constraints);
        int[] resultsArray = results.stream().mapToInt(i -> i).toArray();
        int[] triesArray = Tries.stream().mapToInt(i -> i).toArray();
        Button.restartIcons(numTour, resultsArray, triesArray);
        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    /**
     * Fonction principale du jeu.
     * @param args les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 960);
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

        //Permet de commencer une nouvelle partie
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
                buttonPanel = new JPanel(new GridLayout(16, 7));
                Button.createButtons(buttonPanel, constraints);
                frame.add(buttonPanel);
                frame.setVisible(true);
            }
        });

        //Permet de sauvegarder la partie
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Entrez le nom du fichier de sauvegarde :");
                if (fileName != null && !fileName.isEmpty()) {
                    try {
                        FileWriter writer = new FileWriter("saves/" + fileName);

                        // Ecriture dans le fichier fileName des informations de la partie
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

        //Permet de charger une ancienne partie
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
                        // Lecture du fichier selectedSave et récupération des informations de la partie sélectionnée
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
                        restart();
                        JOptionPane.showMessageDialog(null, "La partie a ete chargee avec succes !");
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur lors du chargement de la partie : " + ex.getMessage());
                    }
                }
            }
        });

        //Permet de choisir l'ordre et la couleur des pions
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

        // Création du panneau contenant les boutons du jeu
        buttonPanel = new JPanel(new GridLayout(16, 7));
        buttonPanel.setPreferredSize(new Dimension(400, 800));
        GridBagConstraints constraints = new GridBagConstraints();
        Button.createButtons(buttonPanel, constraints);
        frame.add(buttonPanel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2 + 10);
        frame.setVisible(true);

        // Affichage du code secret dans la console
        for (int i = 0; i < 4; i++) {
            System.out.println(code[i]);
        }
    }

}
