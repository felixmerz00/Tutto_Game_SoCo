import cards.Card;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class DeckTest {
    //create Deck with getDeck method
    Deck deck = Deck.getDeck();

    //method to use in Tests where we check if correct amount of cards are in deck
    private List<Card> getList(String name) {
        Map<String, List<Card>> cardDict = new HashMap<>();

        //map -> then for loop map(topCard.display).add(topCard)
        //return map(name)

        for (int i=0; i<56; i++) {
            Card topCard = deck.drawCard();
            String topCardName; topCard.display();
            //since Bonus Cards display with their bonusPoints we need if else statement to set topCardName
            if (topCard.display().startsWith("Bonus")) {topCardName = "Bonus";}
            else {topCardName = topCard.display();}
            //check if topCard Key is already in dictList
            //if not in dictList, create new ArrayList and add it under Key topCardName
            if (cardDict.get(topCardName) == null) {
                List<Card> dictList = new ArrayList<>();
                dictList.add(topCard);
                cardDict.put(topCardName, dictList);}

            //if topCardName already as Key in dictList, add topCard to its Arraylist
            else {cardDict.get(topCardName).add(topCard);}
        }
        return cardDict.get(name);
    }

    //check if Singleton works; do we get the same deck with Deck.getDeck()?
    @Test
    void testGetDeck() {
        Deck deck1 = Deck.getDeck();
        assertEquals(deck1, deck);
    }

    //check if deck has 56 cards
    @Test
    void checkDeckSize() {
        int size = getList("Cloverleaf").size() + getList("Fireworks").size() + getList("Stop").size() +
                getList("Straight").size() + getList("PlusMinus").size() + getList("x2").size() + getList("Bonus").size();
        assertEquals(56, size);
    }

    //Test to check if all 56 cards are in the deck with correct amount (e.g. 10 Stop cards):
    //check if deck contains 1 cloverleaf card
    @Test
    void cloverleafInDeck() {
        List<Card> cards = getList("Cloverleaf");
        assertEquals(1, cards.size());
    }

    //check if deck contains 5 fireworks cards
    @Test
    void fireworksInDeck() {
        List<Card> cards = getList("Fireworks");
        assertEquals(5, cards.size());
    }

    //check if deck contains 10 Stop Cards
    @Test
    void stopInDeck() {
        List<Card> cards = getList("Stop");
        assertEquals(10, cards.size());
    }

    //check if deck contains 5 straight cards
    @Test
    void straightInDeck() {
        List<Card> cards = getList("Straight");
        assertEquals(5, cards.size());
    }

    //check if deck contains 5 plus/minus cards
    @Test
    void plusMinusInDeck() {
        List<Card> cards = getList("PlusMinus");
        assertEquals(5, cards.size());
    }

    //check if deck contains 5 x2 cards
    @Test
    void timesTwoInDeck() {
        List<Card> cards = getList("x2");
        assertEquals(5, cards.size());
    }

    //check if deck contains 25 Bonus cards, 5 for each bonusPoints 200, 300, 400, 500, 600
    @Test
    void bonusInDeck() {
        int cnt200 = 0;
        int cnt300 = 0;
        int cnt400 = 0;
        int cnt500 = 0;
        int cnt600 = 0;
        List<Card> allcards = getList("Bonus");
        for (int i=0; i<25; i++) {
            if (allcards.get(i).display().equals("Bonus (200)")) {cnt200++;}
            if (allcards.get(i).display().equals("Bonus (300)")) {cnt300++;}
            if (allcards.get(i).display().equals("Bonus (400)")) {cnt400++;}
            if (allcards.get(i).display().equals("Bonus (500)")) {cnt500++;}
            if (allcards.get(i).display().equals("Bonus (600)")) {cnt600++;}
        }
        assertEquals(25, allcards.size());
        assertEquals(5, cnt200);
        assertEquals(5, cnt300);
        assertEquals(5, cnt400);
        assertEquals(5, cnt500);
        assertEquals(5, cnt600);
    }

    //even if Deck.isEmpty method is indirectly tested by other Test Methods in TestDeck,
    //we make a test for isEmpty function to test it in isolation
    //we create helper method using metaprogramming, so we can bypass the access restriction of private keyword in Deck.isEmpty method
    private boolean isEmpty() {
        try {
            Method method = Deck.class.getDeclaredMethod("isEmpty");
            method.setAccessible(true);
            return (boolean) method.invoke(deck);

        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testIsEmpty() {
        try {
            Field index = Deck.class.getDeclaredField("index");
            index.setAccessible(true);
            index.set(deck, 56);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //with index set to 56 isEmpty should now return true
        assertTrue(isEmpty());
        //when drawing a new card, the deck is reshuffled and index is set to 0, so isEmpty should return false
        deck.drawCard();
        assertFalse(isEmpty());
    }

    //check if Deck.shuffle works
    @Test
    void testShuffle() {
        List<Card> copyDeck = new ArrayList<>();
        for (int i=0; i<56; i++) {
            copyDeck.add(deck.drawCard());
        }
        int cntSameCards = 0;
        for (int i=0; i<56; i++) {
            Card copyCard = copyDeck.get(i);
            Card shuffledDeckCard = deck.drawCard();
            if (copyCard == shuffledDeckCard) {cntSameCards++;}
        }
        assertNotEquals(56, cntSameCards);
    }
}