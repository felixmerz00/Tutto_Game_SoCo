package strategy;

import dice.DiceCollectionInterface;

import java.util.Objects;
import java.util.Scanner;

public class StrategyUI implements StrategyInterfaceUI{

    @Override
    public boolean putAnotherDiceBack() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to put another die back? (Boolean)");
        while(!input.hasNextBoolean()){
            System.out.println("This is not a boolean! Enter true or false.");
            input.next();
        }
        return input.nextBoolean();
    }

    @Override
    public boolean rollAgain() {
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
        return rollAgain;    }

    @Override
    public boolean isTriplet(int Number, DiceCollectionInterface aDiceCollection) {
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
    @Override
    public Tuple putBackDice(DiceCollectionInterface aDiceCollection){
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
            triplet = isTriplet(Number, aDiceCollection);

            //check for valid input & if the dices can be put aside
            validInput = isValid(Number, triplet, aDiceCollection);
            if (!validInput) {
                System.out.println("Your input is not valid, try again. ");
            }
        }
        return new Tuple(Number,triplet);
    }

    protected boolean isValid(int Number, boolean triplet, DiceCollectionInterface aDiceCollection){
        if(Number == 5 && aDiceCollection.hasFive() && !triplet){
            return true;
        }
        else if(Number == 1 && aDiceCollection.hasOne() && !triplet) {
            return true;
        }
        else return aDiceCollection.hasTriplet(Number);
    }
    @Override
    public boolean isNull(DiceCollectionInterface aDiceCollection) {
        return !aDiceCollection.hasTriplet() && !aDiceCollection.hasFive() && !aDiceCollection.hasOne();
    }


}
