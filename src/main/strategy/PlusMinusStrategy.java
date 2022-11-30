package strategy;

public class PlusMinusStrategy extends BaseStrategy{
    //cant stop rolling, if tutto, then 1000 points, else 0

    @Override
    protected String rollAgain(){
        return "R";
    }

    @Override
    public NullTuple executeStrategy() {
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points = 1000;
        }
        else result.points = 0;
        return result;
    }
}