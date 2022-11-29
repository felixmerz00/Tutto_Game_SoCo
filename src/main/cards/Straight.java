package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;
import strategy.StraightStrategy;

public class Straight extends Card{
    /*Constructor creates instance of StraightStrategy*/
    public Straight(String name) {
        this.cardName = name;
        this.Strategy = new StraightStrategy();
    }
}
