import cards.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    //create Deck with getDeck method
    Deck deck = Deck.getDeck();

    //make one instance of each card
    /*Card cloverleaf = new Cloverleaf("Cloverleaf");
    Card bonus200 = new Bonus("Bonus",200);
    Card bonus300 = new Bonus("Bonus", 300);
    Card bonus400 = new Bonus("Bonus", 400);
    Card bonus500 = new Bonus("Bonus", 500);
    Card bonus600 = new Bonus("Bonus", 600);
    Card fireworks = new Fireworks("Fireworks");
    Card plusminus= new PlusMinus("PlusMinus");
    Card stop = new Stop("Stop");
    Card straight = new Straight("Straight");
    Card timestwo = new TimesTwo("x2");*/

    //method to use in Tests where we check if correct amount of cards are in deck
    private List<Card> getList(String name) {
        //create 7 List; one for each type of cards
        /*List<Card> cloList = new ArrayList<>();
        List<Card> fwList = new ArrayList<>();
        List<Card> sList = new ArrayList<>();
        List<Card> strList = new ArrayList<>();
        List<Card> pmList = new ArrayList<>();
        List<Card> x2List = new ArrayList<>();
        List<Card> bonList = new ArrayList<>();*/

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
            /*if (topCard.display().equals("Cloverleaf")) {cloList.add(topCard);}
            if (topCard.display().equals("Fireworks")) {fwList.add(topCard);}
            if (topCard.display().equals("Stop")) {sList.add(topCard);}
            if (topCard.display().equals("Straight")) {strList.add(topCard);}
            if (topCard.display().equals("PlusMinus")) {pmList.add(topCard);}
            if (topCard.display().equals("x2")) {x2List.add(topCard);}
            if (topCard.display().equals("Bonus (200)") || topCard.display().equals("Bonus (300)") || topCard.display().equals("Bonus (400)") ||
                    topCard.display().equals("Bonus (500)") || topCard.display().equals("Bonus (600)")) {
                bonList.add(topCard);}*/
        return cardDict.get(name);


        /*return switch (name) {
            case "Cloverleaf" -> cloList;
            case "Fireworks" -> fwList;
            case "Stop" -> sList;
            case "Straight" -> strList;
            case "PlusMinus" -> pmList;
            case "x2" -> x2List;
            case "Bonus" -> bonList;
            def*/
    }




    //create List (=Deck) for test methods with only one type of card
    //-> does not matter which type (we want to test if Deck.methods work)
    //List<Card> testDeck = new ArrayList<>();
    /*for (int i=0; i<56; i++) {
        Card stop = new Stop("Stop");
        testDeck.add(stop);
    }*/
    //index to
    //private int idx = 0;


    //check if Singleton works; do we get the same deck with Deck.getDeck()?
    @Test
    void getDeck() {
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

    //Test to check if all 56 cards have been displayed:
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

    //because the implementation of class Deck is a realization of FLYWEIGHT and its constructor is private,
    //we use metaprogramming to get around the pattern and create a duplicate of deck

    @Test
    void testDrawCard() {
        try {
            Constructor<Deck> constructor = Deck.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            Deck deck1 = constructor.newInstance();
            //we can now test, if deck1.drawCard returns the topCard
            System.out.println(deck1);

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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