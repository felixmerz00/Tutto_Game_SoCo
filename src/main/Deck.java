import cards.*;

import java.util.ArrayList;
import java.util.List;

public class Deck implements DeckInterface {
    private final List<Card> deck = new ArrayList<>();
    private int index;  // Index where we are at with drawing cards. If index == deck.length(), then the deck is empty.

    //Apply Singleton Design Pattern to create Instance of Deck; because we never initialize a new deck
    //(use indexing to check if deck is empty), we want to be sure, that we have only one deck in the game

    //make private static initializer, which creates new deck instance -> is thread save
    private final static Deck uniqueDeck = new Deck();

    //make Constructor Private
    private Deck() {
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
            Bonus bonus200 = DeckFactory.getBonusCards(200);
            deck.add(bonus200);
            Bonus bonus300 = DeckFactory.getBonusCards(300);
            deck.add(bonus300);
            Bonus bonus400 = DeckFactory.getBonusCards(400);
            deck.add(bonus400);
            Bonus bonus500 = DeckFactory.getBonusCards(500);
            deck.add(bonus500);
            Bonus bonus600 = DeckFactory.getBonusCards(600);
            deck.add(bonus600);
        }

        shuffle();  // Shuffle deck
    }

    //public method to get (already) created instance of deck
    public static Deck getDeck() {
        return uniqueDeck;
    }

    //we check if deck is empty; check index, we do not remove cards from the deck
    private boolean isEmpty(){
        return index >= deck.size();
    }

    //when deck is initialized or empty, we (re)shuffle it and set the index to 0
    private void shuffle() {
        // reorder all carts random and set index to zero
        int len = deck.size();
        for (int i=0; i<len; i++) {
            /*generate random number between 0 and 56 (56 exclusive) */
            int randomIndex = i + (int) ((len-i)*Math.random());

            /*swap deck[i] with deck[randomIndex]*/
            Card iPlace = deck.get(i);
            Card randPlace = deck.get(randomIndex);
            deck.remove(i);
            deck.add(i, randPlace);
            deck.remove(randomIndex);
            deck.add(randomIndex, iPlace);
        }
        index = 0;
    }

    //to draw a card, we return the topCard of the deck and add +1 to the index
    public Card drawCard(){
        if (isEmpty()) {
            shuffle();
            System.out.println("You've drawn all 56 cards. The deck has been reshuffled");
        }
        this.index++;
        Card topCard = deck.get(index-1);
        /*display Card name and then return Card*/
        System.out.println(topCard.display());
        return topCard;
    }
}
