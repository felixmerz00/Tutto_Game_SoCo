package dice;
import java.util.Random;

public class Dice{
    //individual dice objects

    private int eyes;

    public Dice() {
        Random roll = new Random();
        this.eyes = roll.nextInt(6) + 1;
    }

    public void rollDice() {
        //roll dice
        Random roll = new Random();
        this.eyes = roll.nextInt(6) + 1;
    }

    public int diceResult() {
        //return dice roll result
        return this.eyes;
    }

    @Override
    public String toString() {
        return "" + eyes + "";
    }
}
