package dice;

import java.util.ArrayList;

public interface DiceCollectionInterface {
      ArrayList<Dice> TheDice = new ArrayList<>();
      ArrayList<Dice> putBackDice = new ArrayList<>();

     int points = 0;

    //store correct amount of dices
     int remainingDice = 6;

    void rollDices();

    void putDiceAway(int Number, boolean triplet);

    void printDiceCollection();

    boolean isTutto();

    int getPoints();

    boolean hasFive();
    boolean hasOne();

    boolean  hasTriplet();

    boolean  hasTriplet(int value);

    boolean isIn(int value);

    boolean isEmpty();

    boolean isNotPutBack(int value);
}
