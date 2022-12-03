package strategy;

public class BonusStrategy500 extends BonusStrategy{

    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                Bonus 500: If you accomplish a “TUTTO”, you get 500 bonus points
                in addition to the points you have rolled. If you stop and have not
                accomplished a “TUTTO”, you score only the points rolled without getting the
                bonus.""");
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points += bonusPoints();
            return result;
        }
        else if (result.Null) {
            result.points = 0;
            return result;
        }
        else return result;
    }
    @Override
    public int bonusPoints() {
        return 500;
    }
}