package cards;

import strategy.CloverleafStrategy;

public class Cloverleaf extends Card {

    /*Constructor creates instance of CloverleafStrategy*/
    public Cloverleaf() {
        this.cardName = "Cloverleaf";
        this.strategy = new CloverleafStrategy();
    }
}
