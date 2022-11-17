import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public void shuffleAndCreate() {
        //add all carts to deck and shuffle them random
    }

    public void storeCard(Card aCard) {
        //store aCard to deck
    }

    public Card drawCard(){
        if (isEmpty()) {
            shuffleAndCreate();
            System.out.println("The deck has been created or reshuffled");
        }
        return deck.remove(deck.size()-1);
    }


}
