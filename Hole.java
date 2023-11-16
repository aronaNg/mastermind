// Définition de la classe Hole qui hérite de la classe Button
public class Hole extends Button {
    int row; // numéro de ligne
    int col; // numéro de colonne
    int color=0 ; // couleur du trou, initialisée à 0

    // Constructeur de la classe Hole
    public Hole(String type, int row, int col) {
        super(type); 
        this.row = row; 
        this.col = col; 
    }

    // Fonction qui retourne le numéro de ligne du trou
    public int getRow() {
        return row;
    }

    // Fonction qui retourne le numéro de colonne du trou
    public int getCol() {
        return col;
    }
}
