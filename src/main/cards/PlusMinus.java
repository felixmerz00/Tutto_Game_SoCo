package cards;

import strategy.PlusMinusStrategy;

public class PlusMinus extends Card{
    /*Constructor creates instance of PlusMinusStrategy*/
    public PlusMinus() {
        this.cardName = "PlusMinus";
        this.strategy = new PlusMinusStrategy();
    }
}
