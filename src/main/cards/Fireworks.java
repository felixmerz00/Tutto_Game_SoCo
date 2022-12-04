package cards;

import strategy.FireworksStrategy;

public class Fireworks extends Card {

    /*constructor creates new instance of FireworksStrategy*/

    public Fireworks() {
        this.cardName = "Fireworks";
        this.strategy = new FireworksStrategy();
    }
}
