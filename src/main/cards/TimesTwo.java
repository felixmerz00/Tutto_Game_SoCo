package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;
import strategy.TimesTwoStrategy;

public class TimesTwo extends Card{
    /*Constructor creates instance of TimesTwoStrategy*/
    public TimesTwo(String name) {
        this.cardName = name;
        this.Strategy = new TimesTwoStrategy();
    }
}
