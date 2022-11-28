package dice;

import java.util.ArrayList;

public class DiceCollection {
    //create 6 dices
    private final ArrayList<Dice> TheDice = new ArrayList<>();

    private int points = 0;

    //store correct amount of dices
    private int remainingDice = 6;

    public DiceCollection() {
        for(int i = 0; i < remainingDice; i++){
            Dice aDice = new Dice();
            TheDice.add(aDice);
        }
        //System.out.println(TheDice);
    }

    //roll remainingDices
    public void rollDices(){
        for(int i = 0; i < remainingDice; i++){
            //roll remainingDices
            TheDice.get(i).rollDice();
            System.out.print(" ");
            TheDice.get(i).printDice();
            System.out.print(",");
        }
        System.out.println(" ");

    }
    //@PRE: DiceCollection has enough Dices left
    //      Number is int from 1,...,6
    //      Boolean triplet is true if and only if aDiceCollection has a triplet
    public void putDiceAway(int Number, Boolean triplet){

        int drillingIndex = 0;

        for(int i = 0;i < remainingDice && drillingIndex <= 3; i++){ //if player wants to put a way a drilling but rolled more than 3 of the same
            Dice aDice = TheDice.get(i);
            if(aDice.diceResult() == Number){
                //found a die with number, one fewer die can be used
                remainingDice--;

                //put Dice to the end of ArrayList, such that the first remaining dices are used.
                TheDice.remove(i);
                TheDice.add(aDice);
                i--;

                if(!triplet){
                    break;
                }
                else drillingIndex++;

            }
        }
        //calculate points.
        //triplet of ones = 1000
        if(triplet && Number == 1){
            points += 1000;
        }
        //five = 50 points
        else if(!triplet && Number == 5){
            points += 50;
        }
        //One = 100 points, triplets have always 100*number points except 1.
        else points += 100*Number;
    }

    public void printDiceCollection(){
        System.out.println("Your remaining Dice: ");
        for(int i = 0; i < remainingDice;i++){
            TheDice.get(i).printDice();
            System.out.print(", ");
        }
        System.out.println(" ");
        System.out.println("The Dice you put back: ");
        for(int i = remainingDice; i < 6 ;i++){
            TheDice.get(i).printDice();
            System.out.print(", ");
        }
        System.out.println(" ");
    }
    public boolean isTutto(){
        return remainingDice == 0;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasFive(){
        for(int i = 0; i < remainingDice; i++){
            if(TheDice.get(i).diceResult() == 5){
                return true;
            }
        }
        return false;
    }
    public boolean hasOne(){
        for(int i = 0; i < remainingDice; i++){
            if(TheDice.get(i).diceResult() == 1 ){
                return true;
            }
        }
        return false;
    }

    public boolean  hasTriplet(){
        int value;

        if(TheDice.size()<3){
            return false;
        }
        for(int i = 0; i < remainingDice; i++){
            value = TheDice.get(i).diceResult();
            for(int j = i+1; j < remainingDice;j++){
                if(value == TheDice.get(j).diceResult()){
                    for(int k = j+1; k < remainingDice;k++){
                        if(value == TheDice.get(k).diceResult()) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public boolean  hasTriplet(int value){
        if(TheDice.size()<3){
            return false;
        }
        for(int i = 0; i < remainingDice; i++){
            if(value == TheDice.get(i).diceResult()){
                for(int j = i+1; j < remainingDice;j++) {
                    if (value == TheDice.get(j).diceResult()) {
                        for (int k = j + 1; k < remainingDice; k++) {
                            if (value == TheDice.get(k).diceResult()) {
                                return true;
                          }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isNull() {
        return hasTriplet() || hasFive() || hasOne();
    }
}
