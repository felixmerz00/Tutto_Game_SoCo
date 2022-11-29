package dice;

import java.util.ArrayList;

public class DiceCollection {
    //create 6 dices
    private final ArrayList<Dice> TheDice = new ArrayList<>();
    private final ArrayList<Dice> putBackDice = new ArrayList<>();

    private int points = 0;

    //store correct amount of dices
    private int remainingDice = 6;

    public DiceCollection() {
        for(int i = 0; i < 6; i++){ //6 because else we could call the constructor and create a diceCollection with remainingDice != 6
            Dice aDice = new Dice();
            TheDice.add(aDice);
        }
        //System.out.println(TheDice);
    }

    //roll remainingDices
    public void rollDices(){
        for (Dice aDice : TheDice) {
            aDice.rollDice();
        }
    }

    //@PRE: DiceCollection has enough Dices left
    //      Number is int from 1,...,6
    //      Boolean triplet is true if and only if aDiceCollection has a triplet
    public void putDiceAway(int Number, Boolean triplet){

        int tripletIndex = 0;

        for(int i = 0;i < remainingDice && tripletIndex <= 3; i++){ //if player wants to put a way a drilling but rolled more than 3 of the same
            Dice aDice = TheDice.get(i);
            if(aDice.diceResult() == Number){
                //found a die with number, one fewer die can be used
                remainingDice--;

                //put Dice to the end of ArrayList, such that the first remaining dices are used.
                TheDice.remove(i);
                putBackDice.add(aDice);
                i--;

                if(!triplet){
                    break;
                }
                else tripletIndex++;

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
        for (Dice aDice : TheDice) {
            System.out.print(aDice);
            System.out.print(", ");
        }
        System.out.println(" ");
        System.out.println("The Dice you put back: ");
        for (Dice aDice : putBackDice) {
            System.out.print(aDice);
            System.out.print(", ");
        }
        System.out.println(" ");
    }
    public boolean isTutto(){
        return TheDice.isEmpty();
    }

    public int getPoints() {
        return points;
    }

    public boolean hasFive(){
        for(Dice aDice: TheDice){
            if(aDice.diceResult() == 5){
                return true;
            }
        }
        return false;
    }
    public boolean hasOne(){
        for(Dice aDice : TheDice){
            if(aDice.diceResult() == 1 ){
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
        return !hasTriplet() && !hasFive() && !hasOne();
    }
    public boolean isEmpty(){
        return TheDice.isEmpty();
    }
}
