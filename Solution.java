import java.util.Random;

// Définition de la classe Solution
public class Solution {
    /**
     * Cette classe représente la solution dans le jeu Mastermind.
     * 
     */
    static Random rand = new Random();

    // Définition de la méthode resetCode qui renvoie un tableau d'entiers qui servira de code à trouver
    static public int[] resetCode(){

        // Génération de 4 nombres aléatoires entre 1 et 4 inclus
        int num1 = rand.nextInt(4) + 1;
        int num2 = rand.nextInt(4) + 1;
        int num3 = rand.nextInt(4) + 1;
        int num4 = rand.nextInt(4) + 1;
        int[] code = {num1, num2, num3, num4};
        return code;
    }
}
