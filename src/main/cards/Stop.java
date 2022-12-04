package cards;

import strategy.StopStrategy;

public class Stop extends Card{
    /*Constructor creates instance of StopStrategy*/
    public Stop() {
        this.cardName = "Stop";
        this.strategy = new StopStrategy();
    }
}
