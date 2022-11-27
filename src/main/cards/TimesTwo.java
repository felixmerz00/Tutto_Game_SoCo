package cards;

import strategy.CardStrategyInterface;
import strategy.TimesTwoStrategy;

public class TimesTwo extends Card{
    private String cardName = "x2";

    /*Constructor creates instance of TimesTwoStrategy*/
    public TimesTwo() {
        this.Strategy = new TimesTwoStrategy();
    }
}
