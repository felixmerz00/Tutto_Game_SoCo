package strategy;

public class TimesTwoStrategy extends BaseStrategy{
    //if tutto double points, if null 0 points, if player ended turn then he gets the points

    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                x2: If you accomplish a “TUTTO”, all points you have rolled so far on this turn\040
                are doubled. If you stop and have not accomplished a “TUTTO”, you score only the
                points rolled.""");
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