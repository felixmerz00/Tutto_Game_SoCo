package cards;

import strategy.CardStrategyInterface;
import strategy.StopStrategy;

public class Stop extends Card{
    private String cardName = "Stop";

    /*Constructor creates instance of StopStrategy*/
    public Stop() {
        this.Strategy = new StopStrategy();
    }
}
