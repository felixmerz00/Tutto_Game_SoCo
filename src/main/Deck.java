import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();
    private int index;  // Index where we are at with drawing cards. If index == deck.length(), then the deck is empty.

    public Deck() {
        // Instantiate all cards with FLYWEIGHT dp. See: https://refactoring.guru/design-patterns/flyweight maybe use Factory class and other classes
        // Put cards in deck

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
