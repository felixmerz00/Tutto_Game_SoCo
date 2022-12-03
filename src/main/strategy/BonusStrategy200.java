package strategy;

import dice.DiceCollection;
import dice.DiceCollectionInterface;

public class BonusStrategy200 extends BonusStrategy{

    //consider create abstract class with individual bonuses as subclasses (BONUS IF TIME LEFT)
    public BonusStrategy200(){
        this.aDiceCollection = new DiceCollection();
    }
    public BonusStrategy200(DiceCollectionInterface aDiceCollectionInterface){
        this.aDiceCollection = aDiceCollectionInterface;
    }

    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                Bonus 200: If you accomplish a “TUTTO”, you get 200 bonus points
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
    public int bonusPoints(){
        return 200;
    }

}
