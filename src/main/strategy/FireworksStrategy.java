package strategy;

public class FireworksStrategy extends BaseStrategy{
    //roll till null, put back all dice available
    @Override
    protected Boolean putAnotherDiceBack(){
        return true;
    }
    @Override
    protected String rollAgain(){
        return "R";
    }


    @Override
    public NullTuple executeStrategy() {
        int points = 0;
        NullTuple result =  new NullTuple(0,true);
        while(!result.Null){
            result = super.executeStrategy();
            points += result.points;
        }
        result.points = points;
        return result;
    }
}
