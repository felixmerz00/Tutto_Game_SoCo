package strategy;

import dice.DiceCollectionInterface;

public class StraigthStrategyUI extends StrategyUI implements StrategyInterfaceUI{
    //cant stop, new rule for is valid
    @Override
    public boolean rollAgain(){
        return true;
    }

    @Override
    protected boolean isValid(int Number, boolean triplet, DiceCollectionInterface aDiceCollection){
        return aDiceCollection.isNotPutBack(Number) && aDiceCollection.isIn(Number);
    }

    //if every number in theDice already is in putBackDice then its not valid
    @Override
    public boolean isNull(DiceCollectionInterface aDiceCollection){
        //when all dice in theDice are in putBackDice too.
        for (int i = 1; i <=6; i++) {
            if(aDiceCollection.isIn(i) && aDiceCollection.isNotPutBack(i)){
                return false;
            }
        }
        return true;
    }

    //straightStrat doesn't use triplets
    @Override
    public boolean isTriplet(int Number, DiceCollectionInterface aDicecollection){
        return  false;
    }
}
