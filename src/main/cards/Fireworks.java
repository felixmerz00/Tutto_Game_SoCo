package cards;

import strategy.CardStrategyInterface;
import strategy.FireworksStrategy;

public class Fireworks extends Card {
    private String cardName = "Fireworks";

    /*constructor creates new instance of FireworksStrategy*/
    public Fireworks() {
        this.Strategy = new FireworksStrategy();
    }
}
