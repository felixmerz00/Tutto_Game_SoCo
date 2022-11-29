package cards;

import strategy.CardStrategyInterface;

public abstract class Card {
    private String cardName;

    /*not sure that we can define CardStrategyInterface as Type*/
    CardStrategyInterface Strategy;

    public void display() {
        System.out.println(this.cardName);
    }
    public void callStrategy() {
        /*check if Strategy has value (one of 11 concreteCardStrategy) */
        this.Strategy.executeStrategy();
        return;
    }
}
