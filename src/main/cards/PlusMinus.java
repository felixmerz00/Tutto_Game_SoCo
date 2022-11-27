package cards;

import strategy.CardStrategyInterface;
import strategy.PlusMinusStrategy;

public class PlusMinus extends Card{
    private String cardName = "Plus/Minus";

    /*Constructor creates instance of PlusMinusStrategy*/
    public PlusMinus() {
        this.Strategy = new PlusMinusStrategy();
    }
}
