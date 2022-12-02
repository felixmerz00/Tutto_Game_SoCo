package strategy;

public class StraightStrategy extends BaseStrategy{
    //cant stop, new rule for is valid

    @Override
    protected String rollAgain(){
        return "R";
    }

    @Override
    protected boolean isValid(int Number, boolean triplet){
        return aDiceCollection.isNotPutBack(Number) && aDiceCollection.isIn(Number);
    }

    //if every number in theDice already is in putBackDice then its not valid
    @Override
    protected boolean isNull(){
        //wenn alle würfel in theDice auch in putBackDice sind.
        for (int i = 1; i <=6; i++) {
            if(aDiceCollection.isIn(i) && aDiceCollection.isNotPutBack(i)){
                return false;
            }
        }
        return true;
    }

    //straightStrat doesn't use triplets
    @Override
    protected boolean isTriplet(int Number){
        return  false;
    }

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