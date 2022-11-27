package cards;

import strategy.CardStrategyInterface;
import strategy.StraightStrategy;

public class Straight extends Card{
    private String cardName = "Straight";

    /*Constructor creates instance of StraightStrategy*/
    public Straight() {
        this.Strategy = new StraightStrategy();
    }
}
