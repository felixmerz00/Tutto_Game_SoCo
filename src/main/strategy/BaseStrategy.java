package strategy;

import dice.DiceCollection;
import dice.DiceCollectionInterface;

import java.util.Objects;
import java.util.Scanner;

public abstract class BaseStrategy implements CardStrategyInterface{

    protected DiceCollectionInterface aDiceCollection = new DiceCollection();
    //protected StrategyUI UserInterface = new StrategyUI();

    //input validation for all strategies the same?
    //@PRE: triplet is a boolean and number an int between 1-6
    //@POST: (Number, Triplet) is in aDiceCollection
    protected boolean isValid(int Number, boolean triplet){
        if(Number == 5 && aDiceCollection.hasFive() && !triplet){
            return true;
        }
        else if(Number == 1 && aDiceCollection.hasOne() && !triplet) {
            return true;
        }
        else return aDiceCollection.hasTriplet(Number);
    }
    protected boolean putAnotherDiceBack(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to put another die back? (Boolean)");
        while(!input.hasNextBoolean()){
            System.out.println("This is not a boolean! Enter true or false.");
            input.next();
        }
        return input.nextBoolean();
    }

    protected boolean rollAgain(){
        Scanner input = new Scanner(System.in);
        String rollAgainString;
        boolean validInput = false;
        boolean rollAgain = false;
        while(!validInput) {

            System.out.println("Do you want to roll again? R for roll again, E for End turn");
            rollAgainString = input.nextLine();

            if (Objects.equals(rollAgainString, "R")) {
                rollAgain = true;
                validInput = true;
            } else if (Objects.equals(rollAgainString, "E")) {
                //rollAgain = false;
                validInput = true;
            } else {
                System.out.println("Invalid input: R for roll again, E for end turn.");
            }
        }
        return rollAgain;

    }

    protected boolean isNull() {
        return !aDiceCollection.hasTriplet() && !aDiceCollection.hasFive() && !aDiceCollection.hasOne();
    }

    protected boolean isTriplet(int Number){
        boolean triplet = false;
        Scanner scanInput = new Scanner(System.in);
        if(aDiceCollection.hasTriplet(Number)) {
            if (Number == 5 || Number == 1) {
                System.out.println("As triplet? (Boolean)");
                //triplet has to be boolean
                triplet = scanInput.nextBoolean();
            }
            //numbers that are not 1 and 5 can only be put back when they are triplets
            else triplet = true;
        }
        return triplet;
    }

    protected void putBackDice(){
        Scanner scanInput = new Scanner(System.in);
        int Number = 0;
        boolean triplet = false;

        //loop input
        boolean validInput = false;
        while (!validInput) {

            //say which dices you want to put away the dices
            System.out.println("Which Die do you like to put back? An int for the pips (e.g. 5)");

            //Number has to be an int between 1-6
            while(!scanInput.hasNextInt()){
                System.out.println("This is not a Number!");
                System.out.println("Which Die do you like to put back? An int for the pips (e.g. 5)");
                scanInput.next();
            }

            Number = scanInput.nextInt();
            triplet = isTriplet(Number);

            //check for valid input & if the dices can be put aside
            validInput = isValid(Number, triplet);
            if (!validInput) {
                System.out.println("Your input is not valid, try again. ");
            }
        }
        //if so, put them aside
        aDiceCollection.putDiceAway(Number, triplet);
    }

    @Override
    public NullTuple executeStrategy() {
        NullTuple result = new NullTuple(0,false);
        boolean rollAgain;
        boolean putBackAnother;

        while(!aDiceCollection.isEmpty()){

            //roll aDiceCollection
            System.out.println("You roll: ");
            aDiceCollection.rollDices();
            aDiceCollection.printDiceCollection();

            //check if null --> end strategy
            if(isNull()){
                System.out.println(("You rolled Null and your turn ended. "));
                result.Null = true;
                result.points = aDiceCollection.getPoints();
                result.success = false;
                aDiceCollection.reset();
                return result;
            }
            //set putBackAnother to default value after you rolled again after you didnt want to put back a die
            putBackAnother = true;

            //put dices back til no dice can be put back.
            while(!isNull() && putBackAnother) {
                putBackDice();
                if(!isNull()){
                    putBackAnother = putAnotherDiceBack();
                }

                //check if tutto
                //if tutto is reached, Strategy is over
                if (aDiceCollection.isTutto()) {
                    System.out.println("You did a Tutto!"); // put this in the diceCollection?
                    result.points = aDiceCollection.getPoints();
                    result.success = true;
                    aDiceCollection.reset();
                    return result;
                }
            }

            // ask user if he wants to roll again. --> input validation
            rollAgain = rollAgain();
            if(!rollAgain) {
                System.out.println("Your turn is over.");
                result.points = aDiceCollection.getPoints();
                result.success = false;
                aDiceCollection.reset();
                return result;
            }

        }
        //you only get to this point when you rolled a null
        assert isNull();
        result.points = aDiceCollection.getPoints();
        result.Null = true;
        result.success = false;
        aDiceCollection.reset();
        return result;
    }
}
