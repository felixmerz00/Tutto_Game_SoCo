import cards.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Card> cloList = new ArrayList<>();
        List<Card> fwList = new ArrayList<>();
        List<Card> sList = new ArrayList<>();
        List<Card> strList = new ArrayList<>();
        List<Card> pmList = new ArrayList<>();
        List<Card> x2List = new ArrayList<>();
        List<Card> bonList = new ArrayList<>();

        for (int i=0; i<56; i++) {
            Card topCard = deck.drawCard();
            if (topCard.display().equals("Cloverleaf")) {cloList.add(topCard);}
            if (topCard.display().equals("Fireworks")) {fwList.add(topCard);}
            if (topCard.display().equals("Stop")) {sList.add(topCard);}
            if (topCard.display().equals("Straight")) {strList.add(topCard);}
            if (topCard.display().equals("PlusMinus")) {pmList.add(topCard);}
            if (topCard.display().equals("x2")) {x2List.add(topCard);}
            if (topCard.display().equals("Bonus (200)") || topCard.display().equals("Bonus (300)") || topCard.display().equals("Bonus (400)") ||
                    topCard.display().equals("Bonus (500)") || topCard.display().equals("Bonus (600)")) {
                bonList.add(topCard);}
        }

        return switch (name) {
            case "Cloverleaf" -> cloList;
            case "Fireworks" -> fwList;
            case "Stop" -> sList;
            case "Straight" -> strList;
            case "PlusMinus" -> pmList;
            case "x2" -> x2List;
            case "Bonus" -> bonList;
            default -> null;
        };
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

    //no test needed for isEmpty method; is tested in Tests above
    @Test
    void isEmpty() {
    }

    @Test
    void testDrawCard(){}
}