package cards;

import strategy.TimesTwoStrategy;

public class TimesTwo extends Card{
    /*Constructor creates instance of TimesTwoStrategy*/
    public TimesTwo() {
        this.cardName = "x2";
        this.strategy = new TimesTwoStrategy();
    }
}
