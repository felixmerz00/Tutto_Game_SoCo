package dice;

import strategy.StrategyInterfaceUI;
import strategy.Tuple;

import java.util.ArrayList;

public class MockUI implements StrategyInterfaceUI {

    public ArrayList<Integer> inputOneFiveTriplet = new ArrayList<>();
    public ArrayList<Boolean> rollAgain = new ArrayList<>();
    public ArrayList<Boolean>  asTriplet = new ArrayList<>();
    public ArrayList<Boolean>  inputStopPuttingBack= new ArrayList<>();
    public void setInput(ArrayList<Integer> inputOneFiveTriplet, ArrayList<Boolean> rollAgain, ArrayList<Boolean> inputStopPuttingBack, ArrayList<Boolean>  asTriplet){
        this.inputOneFiveTriplet = inputOneFiveTriplet;
        this.rollAgain = rollAgain;
        this.inputStopPuttingBack = inputStopPuttingBack;
        this.asTriplet = asTriplet;
    }

    @Override
    public boolean putAnotherDiceBack() {
        boolean first = inputStopPuttingBack.get(0);
        inputStopPuttingBack.remove(0);
        return first;
    }

    @Override
    public boolean rollAgain() {
        boolean first = this.rollAgain.get(0);
        rollAgain.remove(0);
        return first;
    }

    @Override
    public boolean isTriplet(int Number, DiceCollectionInterface aDiceCollection) {
        boolean triplet = asTriplet.get(0);
        asTriplet.remove(0);
        return triplet;
    }

    @Override
    public Tuple putBackDice(DiceCollectionInterface aDiceCollection) {
        Tuple result = new Tuple(0,false);
        //which dice to put back? 1, 5, triplets
        int num = inputOneFiveTriplet.get(0);
        inputOneFiveTriplet.remove(0);
        result.points = num;
        if(num != 5 && num !=1 ){  //triplet or not without 1 or 5
            result.success = aDiceCollection.hasTriplet(num);
        }
        else if(aDiceCollection.hasTriplet(num)){ // has triplet with 1 or 5
            result.success = isTriplet(num, aDiceCollection);
        }
        return result;
    }

    @Override
    public boolean isNull(DiceCollectionInterface aDiceCollection) {
        return !aDiceCollection.hasTriplet() && !aDiceCollection.hasFive() && !aDiceCollection.hasOne();
    }
}
