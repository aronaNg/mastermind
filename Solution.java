import java.util.Random;

public class Solution {
    static Random rand = new Random();
    static public int[] resetCode(){
        int num1 = rand.nextInt(4) + 1;
        int num2 = rand.nextInt(4) + 1;
        int num3 = rand.nextInt(4) + 1;
        int num4 = rand.nextInt(4) + 1;
        int[] code = {num1, num2, num3, num4};
        return code;
    }
}
