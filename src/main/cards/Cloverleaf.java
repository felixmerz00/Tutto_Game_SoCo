package cards;

import strategy.CloverleafStrategy;

public class Cloverleaf extends Card {

    /*Constructor creates instance of CloverleafStrategy*/
    public Cloverleaf(String name) {
        this.cardName = name;
        this.strategy = new CloverleafStrategy();
    }
}
