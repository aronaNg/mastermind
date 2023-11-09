import javax.swing.*;
import java.awt.*;

public class Testes {

    public static ImageIcon getScaledImageIcon(ImageIcon originalIcon, int width, int height) {
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 840);

        // Crée un JPanel avec un GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(12, 7)); // grille de 12 lignes, 7 colonnes
        buttonPanel.setPreferredSize(new Dimension(400, 800)); // Spécifiez la taille préférée en pixels
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        GridBagConstraints constraints = new GridBagConstraints();

        ImageIcon I0R0B = new ImageIcon("Image\\0R0B.gif");
        ImageIcon I1B = new ImageIcon("Image\\1B.gif");
        ImageIcon I1R = new ImageIcon("Image\\1R.gif");
        ImageIcon I1R1B = new ImageIcon("Image\\1R1B.gif");
        ImageIcon I1R2B = new ImageIcon("Image\\1R2B.gif");
        ImageIcon I1R3B = new ImageIcon("Image\\1R3B.gif");
        ImageIcon I2B = new ImageIcon("Image\\2B.gif");
        ImageIcon I2R = new ImageIcon("Image\\2R.gif");
        ImageIcon I2R1B = new ImageIcon("Image\\2R1B.gif");
        ImageIcon I2R2B = new ImageIcon("Image\\2R2B.gif");
        ImageIcon I3B = new ImageIcon("Image\\3B.gif");
        ImageIcon I3R = new ImageIcon("Image\\3R.gif");
        ImageIcon I3R1B = new ImageIcon("Image\\3R1B.gif");
        ImageIcon I4B = new ImageIcon("Image\\4B.gif");
        ImageIcon I4R = new ImageIcon("Image\\4R.gif");
        ImageIcon IEntreBoutons = new ImageIcon("Image\\Entre_Couleurs&Valide.gif");
        ImageIcon IL1C1 = new ImageIcon("Image\\L1C1.gif");
        ImageIcon IL1C2 = new ImageIcon("Image\\L1C2.gif");
        ImageIcon IL1C3 = new ImageIcon("Image\\L1C3.gif");
        ImageIcon IL1C5 = new ImageIcon("Image\\L1C5.gif");
        ImageIcon IL1C6 = new ImageIcon("Image\\L1C6.gif");
        ImageIcon IL1C7 = new ImageIcon("Image\\L1C7.gif");
        ImageIcon IL1C8 = new ImageIcon("Image\\L1C8.gif");
        ImageIcon IL2C1 = new ImageIcon("Image\\L2C1.gif");
        ImageIcon IL2C6 = new ImageIcon("Image\\L2C6.gif");
        ImageIcon IL2C8 = new ImageIcon("Image\\L2C8.gif");
        ImageIcon IL3C1 = new ImageIcon("Image\\L3C1.gif");
        ImageIcon IL3C6 = new ImageIcon("Image\\L3C6.gif");
        ImageIcon IL3C8 = new ImageIcon("Image\\L3C8.gif");
        ImageIcon IL9C1 = new ImageIcon("Image\\L9C1.gif");
        ImageIcon IL9C6 = new ImageIcon("Image\\L9C6.gif");
        ImageIcon IL10C1 = new ImageIcon("Image\\L10C1.gif");
        ImageIcon IL10C2 = new ImageIcon("Image\\L10C2.gif");
        ImageIcon IL10C3 = new ImageIcon("Image\\L10C3.gif");
        ImageIcon IL10C5 = new ImageIcon("Image\\L10C5.gif");
        ImageIcon IL10C6 = new ImageIcon("Image\\L10C6.gif");
        ImageIcon IL10C8 = new ImageIcon("Image\\L10C8.gif");
        ImageIcon IL11C1 = new ImageIcon("Image\\L11C1.gif");
        ImageIcon IL11C8 = new ImageIcon("Image\\L11C8.gif");
        ImageIcon IL12C1 = new ImageIcon("Image\\L12C1.gif");
        ImageIcon IL12C2 = new ImageIcon("Image\\L12C2.gif");
        ImageIcon IL12C3 = new ImageIcon("Image\\L12C3.gif");
        ImageIcon IL12C7 = new ImageIcon("Image\\L12C7.gif");
        ImageIcon IL12C8 = new ImageIcon("Image\\L12C8.gif");
        ImageIcon IPBS = new ImageIcon("Image\\Pion_Bleu_Selection.gif");
        ImageIcon IPB = new ImageIcon("Image\\Pion_Bleu.gif");
        ImageIcon IPJS = new ImageIcon("Image\\Pion_Jaune_Selection.gif");
        ImageIcon IPJ = new ImageIcon("Image\\Pion_Jaune.gif");
        ImageIcon IPRS = new ImageIcon("Image\\Pion_Rouge_Selection.gif");
        ImageIcon IPR = new ImageIcon("Image\\Pion_Rouge.gif");
        ImageIcon IPVS = new ImageIcon("Image\\Pion_Vert_Selection.gif");
        ImageIcon IPV = new ImageIcon("Image\\Pion_Vert.gif");
        ImageIcon ITS = new ImageIcon("Image\\Trou_Selection.gif");
        ImageIcon IT = new ImageIcon("Image\\Trou.gif");
        ImageIcon IBValideClic = new ImageIcon("Image\\Valide_Clic.gif");
        ImageIcon IBValide = new ImageIcon("Image\\Valide.gif");
        
        ImageIcon[] imageIcons = {I0R0B,I1B,I1R,I1R1B,I1R2B,I1R3B,I2B,I2R,I2R1B,I2R2B, /*10*/I3B,I3R,I3R1B,I4B,I4R,IEntreBoutons,IL1C1,IL1C2,IL1C3,IL1C5, /*20*/IL1C6,IL1C7,IL1C8,IL2C1,IL2C6,IL2C8,IL3C1,IL3C6,IL3C8,IL9C1, /*30*/IL9C6,IL10C1,IL10C2,IL10C3,IL10C5,IL10C6,IL10C8,IL11C1,IL11C8,IL12C1, /*40*/IL12C2,IL12C3,IL12C7,IL12C8,IPBS,IPB,IPJS,IPJ,IPRS,IPR, /*50*/IPVS,IPV,ITS,IT,IBValideClic,IBValide};
        
        // Crée et ajoute des boutons à la grille
        int adaptateur;
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button;
                adaptateur = 0;
                ImageIcon image;
                if(col==6 && 0<row && row<9)
                   image = imageIcons[0];
                else if(col==5 && row==10)
                    image =  imageIcons[15];
                else if(row==0)
                {
                    if(col>2)
                        adaptateur = -1;
                    image = imageIcons[16 + col + adaptateur];
                }
                //else if(col==0)
                else 
                    image = imageIcons[53];

                ImageIcon scaledIcon = getScaledImageIcon(image, 70, 70);
                button = new JButton(scaledIcon);
            

                constraints.gridx = col;
                constraints.gridy = row;
                buttonPanel.add(button, constraints);
            }
        }

        // Ajoute le JPanel contenant la grille de boutons au cadre
        frame.add(buttonPanel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2 + 10);

        frame.setVisible(true);
    }
}
