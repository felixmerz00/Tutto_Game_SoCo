package cards;

import strategy.CardStrategyInterface;

public abstract class Card {
    protected String cardName;

    /*not sure that we can define CardStrategyInterface as Type*/
    protected CardStrategyInterface strategy;

    /*constructor deleted, maybe add again -> conflicts with Bonus Card, cannot override a constructor
    public Card(String name) {
        cardName = name;
    }*/

    public String display() {
        return cardName;
    }

    public CardStrategyInterface getStrategy() {
        return strategy;
    }
}
