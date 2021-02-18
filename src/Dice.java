import java.util.Random;

public class Dice {
    //returns the result of rolling 'n' six sided die
    public static int diceRoll(int n) {
        int num = 0;
        int roll = 0;
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            roll = r.nextInt(6) + 1;
            num += roll;
        }
        return num;
    }
}
