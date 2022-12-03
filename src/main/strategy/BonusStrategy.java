package strategy;

import dice.DiceCollection;
import dice.DiceCollectionInterface;

public abstract class BonusStrategy extends BaseStrategy{

    public abstract int bonusPoints();

    public BonusStrategy(){
        this.aDiceCollection = new DiceCollection();
    }
    public BonusStrategy(DiceCollectionInterface aDiceCollectionInterface){
        this.aDiceCollection = aDiceCollectionInterface;
    }
}
