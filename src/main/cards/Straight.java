package cards;

import strategy.StraightStrategy;

public class Straight extends Card{
    /*Constructor creates instance of StraightStrategy*/
    public Straight() {
        this.cardName = "Straight";
        this.strategy = new StraightStrategy();
    }
}
