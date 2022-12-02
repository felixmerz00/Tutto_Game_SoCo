package cards;

import strategy.TimesTwoStrategy;

public class TimesTwo extends Card{
    /*Constructor creates instance of TimesTwoStrategy*/
    public TimesTwo(String name) {
        this.cardName = name;
        this.strategy = new TimesTwoStrategy();
    }
}
