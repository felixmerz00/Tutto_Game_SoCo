package strategy;

import dice.DiceCollection;
import dice.DiceCollectionInterface;

public class StopStrategy extends BaseStrategy{

    public StopStrategy(){
        this.aDiceCollection = new DiceCollection();
    }
    public StopStrategy(DiceCollectionInterface aDiceCollectionInterface){
        this.aDiceCollection = aDiceCollectionInterface;
    }
    @Override
    public NullTuple executeStrategy() {
        System.out.println("Stop: Tough luck! You have to end your turn, and the next Player has his turn.");
        return new NullTuple(0,false);
    }
}
