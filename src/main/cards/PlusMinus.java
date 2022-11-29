package cards;

import strategy.CardStrategyInterface;
import strategy.CloverleafStrategy;
import strategy.PlusMinusStrategy;

public class PlusMinus extends Card{
    /*Constructor creates instance of PlusMinusStrategy*/
    public PlusMinus(String name) {
        this.cardName = name;
        this.Strategy = new PlusMinusStrategy();
    }
}
