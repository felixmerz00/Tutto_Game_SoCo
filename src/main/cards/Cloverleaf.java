package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;

public class Cloverleaf extends Card {
    private String cardName = "Cloverleaf";

    /*Constructor creates instance of CloverleafStrategy*/
    public Cloverleaf() {
        this.Strategy = new CloverleafStrategy();
    }
}
