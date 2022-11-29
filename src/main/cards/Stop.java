package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;
import strategy.StopStrategy;

public class Stop extends Card{
    /*Constructor creates instance of StopStrategy*/
    public Stop(String name) {
        this.cardName = name;
        this.Strategy = new StopStrategy();
    }
}
