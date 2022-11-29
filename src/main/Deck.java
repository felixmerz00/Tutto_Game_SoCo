import cards.*;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();
    private int index;  // Index where we are at with drawing cards. If index == deck.length(), then the deck is empty.

    public Deck() {
        // Instantiate all cards with FLYWEIGHT dp. See: https://refactoring.guru/design-patterns/flyweight maybe use Factory class and other classes
        // Put cards in deck

        /*Instantiate 1 Cloverleaf Card Instance in deck*/
        Cloverleaf cloverleaf = (Cloverleaf)DeckFactory.getCards("Cloverleaf");
        deck.add(cloverleaf);

        /*Instantiate 1 Fireworks Card and put 5 References in deck
        * Instantiate 1 Straight Card and put 5 References in deck
        * Instantiate 1 PlusMinus Card and put 5 References in deck
        * Instantiate 1 TimesTwo Card and put 5 References in deck*/
        for (int i = 0; i<5; i++) {
            Fireworks fireworks = (Fireworks)DeckFactory.getCards("Fireworks");
            deck.add(fireworks);
            Straight straight = (Straight)DeckFactory.getCards("Straight");
            deck.add(straight);
            PlusMinus plusMinus = (PlusMinus)DeckFactory.getCards("PlusMinus");
            deck.add(plusMinus);
            TimesTwo timesTwo = (TimesTwo)DeckFactory.getCards("x2");
            deck.add(timesTwo);
        }

        /*Instantiate 1 Stop Card Instance and put 10 References in deck*/
        for (int i = 0; i<10; i++) {
            Stop stop = (Stop) DeckFactory.getCards("Stop");
            deck.add(stop);
        }

        /*Instantiate 5 Bonus Cards (200, 300, 400, 500, 600) and put 5 References each*/
        for (int i=0; i<5; i++) {
            Bonus bonus200 = (Bonus) DeckFactory.getBonusCards(200);
            deck.add(bonus200);
            Bonus bonus300 = (Bonus) DeckFactory.getBonusCards(300);
            deck.add(bonus300);
            Bonus bonus400 = (Bonus) DeckFactory.getBonusCards(400);
            deck.add(bonus400);
            Bonus bonus500 = (Bonus) DeckFactory.getBonusCards(500);
            deck.add(bonus500);
            Bonus bonus600 = (Bonus) DeckFactory.getBonusCards(600);
            deck.add(bonus600);
        }

        shuffle();  // Shuffle deck
        index = 0;
    }

    public boolean isEmpty(){
        //check index
        // if index > listlen return true;
        return deck.isEmpty();
    }

    private void shuffle() {
        // reorder all carts random and set index to zero
    }

    public Card drawCard(){
        if (isEmpty()) {
            shuffle();
            System.out.println("The deck has been created or reshuffled");
        }
        this.index++;
        return deck.get(index-1);
    }
}
