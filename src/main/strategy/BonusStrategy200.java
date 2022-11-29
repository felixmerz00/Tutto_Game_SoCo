package strategy;

public class BonusStrategy200 extends BonusStrategy{

    //consider create abstract class with individual bonuses as subclasses (BONUS IF TIME LEFT)

    @Override
    public Tuple executeStrategy() {
        Tuple result = super.executeStrategy();
        if(result.success){
            result.points += bonusPoints();
        }
        return result;
    }

    @Override
    public int bonusPoints(){
        return 200;
    }

}
