// Définition de la classe Pawn qui hérite de la classe Button
public class Pawn extends Button {
    String color;
    /**
     * Cette classe représente un pion dans le jeu Mastermind.
     * 
     */
    // Constructeur de la classe Pawn qui prend en paramètres deux chaînes de caractères
    public Pawn(String type, String color) {
        super(type); 
        this.color = color; 
    }

    // Méthode qui retourne la couleur de la pièce
    public String getColor() {
        return color;
    }
}
