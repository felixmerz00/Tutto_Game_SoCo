package strategy;

import dice.DiceCollection;
import dice.DiceCollectionInterface;

public abstract class BaseStrategy implements CardStrategyInterface{

    protected DiceCollectionInterface aDiceCollection = new DiceCollection();

    protected StrategyInterfaceUI UserInterface; //every Strategy need their own Constructor with that

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
            if(UserInterface.isNull(aDiceCollection)){
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
            while(!UserInterface.isNull(aDiceCollection) && putBackAnother) {
                Tuple putBack = UserInterface.putBackDice(aDiceCollection);
                //if so, put them aside
                aDiceCollection.putDiceAway(putBack.points, putBack.success);
                if(!UserInterface.isNull(aDiceCollection)){
                    putBackAnother = UserInterface.putAnotherDiceBack();
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
            rollAgain = UserInterface.rollAgain();
            if(!rollAgain) {
                System.out.println("Your turn is over.");
                result.points = aDiceCollection.getPoints();
                result.success = false;
                aDiceCollection.reset();
                return result;
            }

        }
        //you can only get to this point when you rolled a null & diceCollection is empty, return statement needed
        assert UserInterface.isNull(aDiceCollection);
        result.points = aDiceCollection.getPoints();
        result.Null = true;
        result.success = false;
        aDiceCollection.reset();
        return result;
    }
}
