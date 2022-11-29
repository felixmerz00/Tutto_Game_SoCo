package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;

public class Cloverleaf extends Card {

    /*Constructor creates instance of CloverleafStrategy*/
    public Cloverleaf(String name) {
        this.cardName = name;
        this.Strategy = new CloverleafStrategy();
    }
}
