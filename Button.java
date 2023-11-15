import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Button {

    static ImageIcon I0R0B = new ImageIcon("Image\\0R0B.gif");
    static ImageIcon I1B = new ImageIcon("Image\\1B.gif");
    static ImageIcon I1R = new ImageIcon("Image\\1R.gif");
    static ImageIcon I1R1B = new ImageIcon("Image\\1R1B.gif");
    static ImageIcon I1R2B = new ImageIcon("Image\\1R2B.gif");
    static ImageIcon I1R3B = new ImageIcon("Image\\1R3B.gif");
    static ImageIcon I2B = new ImageIcon("Image\\2B.gif");
    static ImageIcon I2R = new ImageIcon("Image\\2R.gif");
    static ImageIcon I2R1B = new ImageIcon("Image\\2R1B.gif");
    static ImageIcon I2R2B = new ImageIcon("Image\\2R2B.gif");
    static ImageIcon I3B = new ImageIcon("Image\\3B.gif");
    static ImageIcon I3R = new ImageIcon("Image\\3R.gif");
    static ImageIcon I3R1B = new ImageIcon("Image\\3R1B.gif");
    static ImageIcon I4B = new ImageIcon("Image\\4B.gif");
    static ImageIcon I4R = new ImageIcon("Image\\4R.gif");
    static ImageIcon IEntreBoutons = new ImageIcon("Image\\Entre_Couleurs&Valide.gif");
    static ImageIcon IL1C1 = new ImageIcon("Image\\L1C1.gif");
    static ImageIcon IL1C2 = new ImageIcon("Image\\L1C2.gif");
    static ImageIcon IL1C3 = new ImageIcon("Image\\L1C3.gif");
    static ImageIcon IL1C5 = new ImageIcon("Image\\L1C5.gif");
    static ImageIcon IL1C6 = new ImageIcon("Image\\L1C6.gif");
    static ImageIcon IL1C7 = new ImageIcon("Image\\L1C7.gif");
    static ImageIcon IL1C8 = new ImageIcon("Image\\L1C8.gif");
    static ImageIcon IL2C1 = new ImageIcon("Image\\L2C1.gif");
    static ImageIcon IL2C6 = new ImageIcon("Image\\L2C6.gif");
    static ImageIcon IL2C8 = new ImageIcon("Image\\L2C8.gif");
    static ImageIcon IL3C1 = new ImageIcon("Image\\L3C1.gif");
    static ImageIcon IL3C6 = new ImageIcon("Image\\L3C6.gif");
    static ImageIcon IL3C8 = new ImageIcon("Image\\L3C8.gif");
    static ImageIcon IL9C1 = new ImageIcon("Image\\L9C1.gif");
    static ImageIcon IL9C6 = new ImageIcon("Image\\L9C6.gif");
    static ImageIcon IL10C1 = new ImageIcon("Image\\L10C1.gif");
    static ImageIcon IL10C2 = new ImageIcon("Image\\L10C2.gif");
    static ImageIcon IL10C3 = new ImageIcon("Image\\L10C3.gif");
    static ImageIcon IL10C5 = new ImageIcon("Image\\L10C5.gif");
    static ImageIcon IL10C6 = new ImageIcon("Image\\L10C6.gif");
    static ImageIcon IL10C7 = new ImageIcon("Image\\L10C7.gif");
    static ImageIcon IL10C8 = new ImageIcon("Image\\L10C8.gif");
    static ImageIcon IL11C1 = new ImageIcon("Image\\L11C1.gif");
    static ImageIcon IL11C8 = new ImageIcon("Image\\L11C8.gif");
    static ImageIcon IL12C1 = new ImageIcon("Image\\L12C1.gif");
    static ImageIcon IL12C2 = new ImageIcon("Image\\L12C2.gif");
    static ImageIcon IL12C3 = new ImageIcon("Image\\L12C3.gif");
    static ImageIcon IL12C7 = new ImageIcon("Image\\L12C7.gif");
    static ImageIcon IL12C8 = new ImageIcon("Image\\L12C8.gif");
    static ImageIcon IPBS = new ImageIcon("Image\\Pion_Bleu_Selection.gif");
    static ImageIcon IPB = new ImageIcon("Image\\Pion_Bleu.gif");
    static ImageIcon IPJS = new ImageIcon("Image\\Pion_Jaune_Selection.gif");
    static ImageIcon IPJ = new ImageIcon("Image\\Pion_Jaune.gif");
    static ImageIcon IPRS = new ImageIcon("Image\\Pion_Rouge_Selection.gif");
    static ImageIcon IPR = new ImageIcon("Image\\Pion_Rouge.gif");
    static ImageIcon IPVS = new ImageIcon("Image\\Pion_Vert_Selection.gif");
    static ImageIcon IPV = new ImageIcon("Image\\Pion_Vert.gif");
    static ImageIcon IPO = new ImageIcon("Image\\Pion_Orange.gif");
    static ImageIcon IPOS = new ImageIcon("Image\\Pion_Orange_Selection.gif");
    static ImageIcon IPVi = new ImageIcon("Image\\Pion_Violet.gif");
    static ImageIcon IPViS = new ImageIcon("Image\\Pion_Violet_Selection.gif");
    static ImageIcon IPRo = new ImageIcon("Image\\Pion_Rose.gif");
    static ImageIcon IPRoS = new ImageIcon("Image\\Pion_Rose_Selection.gif");
    static ImageIcon IPBl = new ImageIcon("Image\\Pion_Blanc.gif");
    static ImageIcon IPBlS = new ImageIcon("Image\\Pion_Blanc_Selection.gif");
    static ImageIcon ITS = new ImageIcon("Image\\Trou_Selection.gif");
    static ImageIcon IT = new ImageIcon("Image\\Trou.gif");
    static ImageIcon IBValideClic = new ImageIcon("Image\\Valide_Clic.gif");
    static ImageIcon IBValide = new ImageIcon("Image\\Valide.gif");
    static ImageIcon IFinA = new ImageIcon("Image\\FinA.gif");
    static ImageIcon IFinM = new ImageIcon("Image\\FinM.gif");
    static ImageIcon IFinX = new ImageIcon("Image\\FinX.gif");

    String type;
    static Random rand = new Random();

    private static List<Button> buttons = new ArrayList<>();
    private static List<Pawn> pawns = new ArrayList<>();
    private static List<Hole> holes = new ArrayList<>();

    private static int selectedHole = 0;
    //Order of the colors : Yellow, Red, Green, Blue
    private static int selectedPawn = 0;

    static ImageIcon[] imageFin = {IFinA, IFinM, IFinX};
    static ImageIcon[] imagePions = {IPJ,IPJS,IPR,IPRS,IPV,IPVS,IPB,IPBS,IPO,IPOS,IPVi,IPViS,IPRo,IPRoS,IPBl,IPBlS};
    static ImageIcon[] imageIcons = {I0R0B,I1B,I2B,I3B,I4B,I1R,I1R1B,I1R2B,I1R3B,I2R, /*10*/I2R1B,I2R2B,I3R,I3R1B,I4R,IEntreBoutons,IL1C1,IL1C2,IL1C3,IL1C5, /*20*/IL1C6,IL1C7,IL1C8,IL2C1,IL2C6,IL2C8,IL3C1,IL3C6,IL3C8,IL9C1, /*30*/IL9C6,IL10C1,IL10C2,IL10C3,IL10C5,IL10C6,IL10C8,IL11C1,IL11C8,IL12C1, /*40*/IL12C2,IL12C3,IL12C7,IL12C8,IPR,IPRS,IPB,IPBS,IPJ,IPJS, /*50*/IPV,IPVS,ITS,IT,IBValideClic,IBValide};


    public Button(String type) {
        this.type = type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String gettype() {
        return type;
    }

    public static void resetPawns(){
        pawns = new ArrayList<>();
    }

    public static void resetHoles(){
        holes = new ArrayList<>();
    }

    public static void resetButtons(){
        buttons = new ArrayList<>();
    }


    public static void setSelectedHole(){
        selectedHole=0;
    }

    public static void setSelectedPawn(){
        selectedPawn=0;
    }

    public static ImageIcon getScaledImageIcon(ImageIcon originalIcon) {
        int width = 50;
        int height = 50;
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void changeIconButton(int buttonNumber, JPanel buttonPanel, ImageIcon image) {

        Component[] components = buttonPanel.getComponents();

        // Get a specific button
        JButton specificButton = (JButton) components[buttonNumber-1];

        // Modify the button
        ImageIcon scaledIcon = getScaledImageIcon(image);
        specificButton.setIcon(scaledIcon);
        specificButton.revalidate();
        specificButton.repaint();
    }

    public static void restart(JPanel buttonPanel, int numTour, int[] tries, int[] results, String[] colors){
        GridBagConstraints constraints = new GridBagConstraints();
        Mastermind.frame.remove(buttonPanel);
        buttonPanel = new JPanel(new GridLayout(16, 7));
        Button.createButtons(buttonPanel, constraints);
        Mastermind.frame.add(buttonPanel);
        Mastermind.frame.setVisible(true);
        holes = new ArrayList<>();
        for (int i = 0; i < tries.length; i++) {
            holes.add(new Hole("Hole", 0, 0));
        }
        selectedPawn = 0;
        selectedHole = 0;
        for (int i=0; i<numTour; i++){
            for (int j=0; j<4; j++){
                holes.get(4*i+j).color = tries[4*i+j];
                changeIconButton(8*(12-i)+j+2, buttonPanel, imageIcons[44+2*(tries[4*i+j]-1)]);
            }
            changeIconButton(8*(12-i)+7, buttonPanel, imageIcons[results[i]]);
        }
    }

    static public void setColors(String color1, String color2, String color3, String color4){
        String[] colors = {color1, color2, color3, color4};
        List<ImageIcon> imageIconsList = new ArrayList<>(Arrays.asList(imageIcons));
        imageIconsList.subList(44, 52).clear();
        for (int i=3; i>=0; i--){
            switch (colors[i]) {
                case "rouge" :
                    imageIconsList.add(44, IPR);
                    imageIconsList.add(45, IPRS);
                    break;
                
                case "bleu" :
                    imageIconsList.add(44, IPB);
                    imageIconsList.add(45, IPBS);
                    break;

                case "vert" :
                    imageIconsList.add(44, IPV);
                    imageIconsList.add(45, IPVS);
                    break;
                
                case "jaune" :
                    imageIconsList.add(44, IPJ);
                    imageIconsList.add(45, IPJS);
                    break;

                case "orange" :
                    imageIconsList.add(44, IPO);
                    imageIconsList.add(45, IPOS);
                    break;
                
                case "violet" :
                    imageIconsList.add(44, IPVi);
                    imageIconsList.add(45, IPViS);
                    break;
                
                case "blanc" :
                    imageIconsList.add(44, IPBl);
                    imageIconsList.add(45, IPBlS);
                    break;

                default :
                    imageIconsList.add(44, IPRo);
                    imageIconsList.add(45, IPRoS);
                    break;
            }
        }
        imageIcons = imageIconsList.toArray(new ImageIcon[0]);
    }
    
    static java.awt.event.ActionListener buttonActionListener = new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String actionCommand = e.getActionCommand();
            System.out.println("Button clicked: " + actionCommand);
            String numberString = actionCommand.replace("Button ", "");
            int buttonNumber = Integer.parseInt(numberString);
            buttonManager(buttonNumber, Mastermind.getbuttonPanel());
        }
    };

    static public void buttonManager(int buttonNumber, JPanel buttonPanel) {
        int numTour = Mastermind.getNumTour();
        if( 8*(12-numTour) +1 < buttonNumber && buttonNumber < 8*(12-numTour)+6 && numTour<12){
            int holeNumber = buttonNumber - (8*(12-numTour)+1);
            Hole hole = holes.get(4-holeNumber + 4*numTour);
            if (buttonNumber == selectedHole){
                selectedHole = 0;
                changeIconButton(buttonNumber, buttonPanel, imageIcons[53]);
            }
            else if(hole.color!=0){
                if(selectedPawn != 0){
                    changeIconButton(selectedPawn, buttonPanel, imageIcons[44+2*(selectedPawn-114)]);
                    changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(selectedPawn-114)]);
                    hole.color = selectedPawn-113;
                    selectedPawn = 0;
                }
                else{
                    hole.color = 0;
                    changeIconButton(buttonNumber, buttonPanel, imageIcons[53]);
                    if (selectedHole != 0){
                        changeIconButton(selectedHole, buttonPanel, imageIcons[53]);
                        selectedHole = 0;
                    }
                }
            }

            else if (selectedHole != 0){
                changeIconButton(selectedHole, buttonPanel, imageIcons[53]);
                changeIconButton(buttonNumber, buttonPanel, imageIcons[52]);
                selectedHole = buttonNumber;
            }
            else if(selectedPawn != 0){
                hole.color = selectedPawn-113;
                changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(selectedPawn-114)]);
                changeIconButton(selectedPawn, buttonPanel, imageIcons[44+2*(selectedPawn-114)]);
                selectedPawn = 0;
                selectedHole = 0;
            }
            else{
                selectedHole = buttonNumber;
                changeIconButton(buttonNumber, buttonPanel, imageIcons[52]);
            }
        }
        else if( 113 < buttonNumber && buttonNumber < 118 && numTour<12){
            if (buttonNumber == selectedPawn){
                selectedPawn = 0;
                changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(buttonNumber-114)]);
            }
            else if (selectedPawn != 0){                                     
                changeIconButton(selectedPawn, buttonPanel, imageIcons[44+2*(selectedPawn-114)]);
                changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(buttonNumber-114)+1]);
                selectedPawn = buttonNumber;
            }
            else if (selectedHole != 0){
                int holeNumber = selectedHole - (8*(12-numTour)+1);
                Hole hole = holes.get(4-holeNumber + 4*numTour);
                hole.color=buttonNumber-113;
                changeIconButton(selectedHole, buttonPanel, imageIcons[44+2*(buttonNumber-114)]);
                changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(buttonNumber-114)]);
                selectedPawn = 0;
                selectedHole = 0;
            }
            else {
                selectedPawn = buttonNumber;
                changeIconButton(buttonNumber, buttonPanel, imageIcons[44+2*(buttonNumber-114)+1]);
            }
        }

        else if(buttonNumber == 119 && numTour<12){
            boolean isFull = true;
            int nbRouge = 0;
            int nbBlanc = 0;
            int[] trouve = {0,0,0,0};
            int[] trouveBis = {0,0,0,0};
            int[] code = Mastermind.code;
            for (int i = 0; i < 4; i++) {
                Hole hole = holes.get(3-i + 4*numTour);
                if (hole.color == 0){
                    isFull = false;
                }
                else if(hole.color == code[i]){
                    nbRouge++;
                    trouve[i] = 1;
                    trouveBis[i] = 1;
                }
            }

            for (int i = 0; i < 4; i++) {
                Hole hole = holes.get(3-i + 4*numTour);
                if (hole.color == 0){
                    isFull = false;
                }
                else{
                    for (int j = 0; j < 4; j++) {
                        if (hole.color == code[j] && trouve[i] == 0 && trouveBis[j] == 0){
                            nbBlanc++;
                            trouve[i] = 1;
                            trouveBis[j] = 1;
                        }
                    }
                }
            }

            if (isFull){
                int position;
                switch (nbRouge) {
                    case 0:
                        position = 0;
                        break;
                    case 1:
                        position = 5;
                        break;
                    case 2:
                        position = 9;
                        break;
                    case 3:
                        position = 12;
                        break;
                    default:
                        position = 14;
                        break;
                }
                position += nbBlanc;
                changeIconButton(8*(12-numTour)+7, buttonPanel, imageIcons[position]);
                Mastermind.addResults(position);

                for (int i = 0; i < 4; i++) {
                    Hole holeToSave = holes.get(3-i + 4*numTour);
                    Mastermind.addTries( holeToSave.color);
                }

                if (nbRouge == 4){
                    Mastermind.numTour = -1;
                    JFrame frameFin = new JFrame("BRAVOOOOOOOOOOO !");
                    frameFin.setLocationRelativeTo(null);
                    ImageIcon im = imageFin[rand.nextInt(3)];
                    JLabel label = new JLabel(im);
                    frameFin.setSize(im.getIconWidth(), im.getIconHeight());
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    frameFin.setLocation(dim.width/2 - frameFin.getWidth()/2, dim.height/2 - frameFin.getHeight()/2 + 10);
                    frameFin.add(label);
                    frameFin.setVisible(true);

                }
                else{
                    Mastermind.addNumTour();
                }

            }
        }
    }

    static void createButtons(JPanel buttonPanel, GridBagConstraints constraints) {
        int adaptateur;
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 8; col++) {
                JButton buttonFrame;
                adaptateur = 0;
                ImageIcon image;
                if(col==6 && 0<row && row<13){
                    image = imageIcons[0];
                    Button button = new Button("Decoration");
                    buttons.add(button);
                }
                else if(row==0)
                {
                    if(col>2)
                        adaptateur = -1;
                    image = imageIcons[16 + col + adaptateur];
                    Button button = new Button("Decoration");
                    buttons.add(button);
                }
                else if(col==0){
                    Button button = new Button("Decoration");
                    buttons.add(button);
                    if(row==1)
                        image = IL2C1;
                    else if(1<row && row<12)
                        image = IL3C1;
                    else if(row==12)
                        image = IL9C1;
                    else if(row==13)
                        image = IL10C1;
                    else if(row==14)
                        image = IL11C1;
                    else
                        image = IL12C1;
                }
                else if(col==5 && row<13){
                    Button button = new Button("Decoration");
                    buttons.add(button);
                    if(row==1)
                        image=IL2C6;
                    else if(1<row && row<12)
                        image=IL3C6;
                    else
                        image=IL9C6;
                }
                else if(col==7 && row!=13){
                    Button button = new Button("Decoration");
                    buttons.add(button);
                    if(row==1)
                        image=IL2C8;
                    else if(1<row && row<13)
                        image=IL3C8;
                    else if(row==14)
                        image=IL11C8;
                    else
                        image=IL12C8;
                }
                else if(row==13){
                    Button button = new Button("Decoration");
                    buttons.add(button);
                    if(col==1)
                        image=IL10C2;
                    else if(col==2 || col==3)
                        image=IL10C3;
                    else if(col==4)
                        image=IL10C5;
                    else if(col==5)
                        image=IL10C6;
                    else if(col==6)
                        image=IL10C7;
                    else
                        image=IL10C8;
                }
                else if(row==14){
                    if(col==1){
                        Pawn pawn = new Pawn("Pawn", "Yellow");
                        pawns.add(pawn);
                        image=imageIcons[44];}
                    else if(col==2){
                        Pawn pawn = new Pawn("Pawn", "Red");
                        pawns.add(pawn);
                        image=imageIcons[46];}
                    else if(col==3){
                        Pawn pawn = new Pawn("Pawn", "Green");
                        pawns.add(pawn);
                        image=imageIcons[48];}
                    else if(col==4){
                        Pawn pawn = new Pawn("Pawn", "Blue");
                        pawns.add(pawn);
                        image=imageIcons[50];}
                    else if(col==5){
                        image=IEntreBoutons;
                        Button button = new Button("Decoration");
                        buttons.add(button);}
                    else{
                        Button button = new Button("Validate");
                        buttons.add(button);
                        image=IBValide;}
                }
                else if(row==15){
                    Button button = new Button("Decoration");
                    buttons.add(button);
                    if(col==1)
                        image=IL12C2;
                    else if(col==6)
                        image=IL12C2;
                    else
                        image=IL12C3;
                }        
                else{
                    Hole hole = new Hole("Hole", 13-row, col);
                    holes.add(0, hole);
                    image = imageIcons[53];}


                ImageIcon scaledIcon = getScaledImageIcon(image);
                buttonFrame = new JButton(scaledIcon);
                buttonFrame.setActionCommand("Button " + (row * 8 + col + 1));
                buttonFrame.addActionListener(buttonActionListener);

                if(col==6 && row==14)
                    buttonFrame.setPressedIcon( getScaledImageIcon(IBValideClic));
                buttonFrame.setBorderPainted(false); 
                constraints.gridx = col;
                constraints.gridy = row;
                buttonPanel.add(buttonFrame, constraints);
            }
        }
    }
}