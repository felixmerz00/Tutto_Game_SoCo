package cards;

import strategy.CardStrategyInterface;

import java.util.Arrays;
import java.util.List;

public abstract class Card {
    public String cardName;

    /*not sure that we can define CardStrategyInterface as Type*/
    protected CardStrategyInterface Strategy;

    /*constructor deleted, maybe add again -> conflicts with Bonus Card, cannot override a constructor
    public Card(String name) {
        cardName = name;
    }*/

    public void display() {
        System.out.println(this.cardName);
    }

    /*check what to return in this method -> tuple*/
    public void callStrategy() {
        /*check if Strategy has value (one of 11 concreteCardStrategy) */
        this.Strategy.executeStrategy();
        return;
    }
}
