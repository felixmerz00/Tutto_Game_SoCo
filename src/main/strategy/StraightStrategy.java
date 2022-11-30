package strategy;

//import dice.DiceCollection;

public class StraightStrategy extends BaseStrategy{
    //cant stop, new rule for is valid

    @Override
    protected String rollAgain(){
        return "R";
    }

    @Override
    protected boolean isValid(int Number, boolean triplet){
        return false;//!aDiceCollection.hasIn(Number);
    }

    //mmh geht besser
    /*public boolean isNull(DiceCollection aDiceCollection){
        //wenn alle würfel in theDice auch in putBackDice sind.
        return false;
    }*/

    @Override
    public NullTuple executeStrategy() {
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points = 2000;
        }
        else result.points = 0;

        return result;
    }
}