package strategy;

public class TimesTwoStrategy extends BaseStrategy{
    //if tutto double points, if null 0 points, if player ended turn then he gets the points
    @Override
    public NullTuple executeStrategy() {
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points = result.points*2;
            return result;
        }
        else if (result.Null) {
            result.points = 0;
            return result;
        }
        else return result;
    }
}