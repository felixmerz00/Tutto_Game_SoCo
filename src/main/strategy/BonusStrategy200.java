package strategy;

public class BonusStrategy200 extends BonusStrategy{

    //consider create abstract class with individual bonuses as subclasses (BONUS IF TIME LEFT)

    @Override
    public NullTuple executeStrategy() {
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
    public int bonusPoints(){
        return 200;
    }

}
