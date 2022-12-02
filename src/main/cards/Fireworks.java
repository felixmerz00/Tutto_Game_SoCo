package cards;

import strategy.FireworksStrategy;

public class Fireworks extends Card {

    /*constructor creates new instance of FireworksStrategy*/

    public Fireworks(String name) {
        this.cardName = name;
        this.strategy = new FireworksStrategy();
    }
}
