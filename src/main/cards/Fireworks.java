package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;
import strategy.FireworksStrategy;

public class Fireworks extends Card {

    /*constructor creates new instance of FireworksStrategy*/

    public Fireworks(String name) {
        this.cardName = name;
        this.Strategy = new FireworksStrategy();
    }
}
