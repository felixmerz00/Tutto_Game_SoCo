package cards;

import strategy.PlusMinusStrategy;

public class PlusMinus extends Card{
    /*Constructor creates instance of PlusMinusStrategy*/
    public PlusMinus(String name) {
        this.cardName = name;
        this.strategy = new PlusMinusStrategy();
    }
}
