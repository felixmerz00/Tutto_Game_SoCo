import cards.Card;
import cards.Cloverleaf;
import cards.PlusMinus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.CardStrategyInterface;
import strategy.Tuple;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TurnLogicTest {
    TurnLogic aTurnLogic = new TurnLogic();
    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in; // backup System.in to restore it later
    }

    @AfterEach
    void tearDown() {
        // optionally, reset System.in to its original
        System.setIn(sysInBackup);
    }

    // Test branch where player rolls a null
    @Test
    void playTurn1() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        // Replace the deck in the TurnLogic with a StubDeck
        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck1 deck = new StubDeck1();
        deckField.set(aTurnLogic, deck);

        aTurnLogic.playTurn(testPlayer);
        assertEquals(0, testPlayer.getPoints());
    }

    // Test branch where player does roll neither a null nor a Tutto
    @Test
    void playTurn2() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        // Replace the deck in the TurnLogic with a StubDeck
        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck2 deck = new StubDeck2();
        deckField.set(aTurnLogic, deck);

        aTurnLogic.playTurn(testPlayer);
        assertEquals(1, testPlayer.getPoints());
    }

    // Test branch where player rolls Tutto with any card except the PlusMinus or Cloverleaf card.
    @Test
    void playTurn3() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        // Replace the deck in the TurnLogic with a StubDeck
        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck3 deck = new StubDeck3();
        deckField.set(aTurnLogic, deck);

        input = "0";    // In this branch the code will ask the user for input, so I must provide the input.
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        aTurnLogic.playTurn(testPlayer);
        assertEquals(1, testPlayer.getPoints());
    }

    // Test branch where player rolls Tutto the PlusMinus card.
    @Test
    void playTurn4() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        // Replace the deck in the TurnLogic with a StubDeck
        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck4 deck = new StubDeck4();
        deckField.set(aTurnLogic, deck);

        Field strategyField = Card.class.getDeclaredField("strategy");
        strategyField.setAccessible(true);
        StubCardStrategy4 aStubStrategy = new StubCardStrategy4();
        strategyField.set(deck.aCard, aStubStrategy);

        input = "0";    // In this branch the code will ask the user for input, so I must provide the input.
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(1, aTurnLogic.playTurn(testPlayer));
        assertEquals(1000, testPlayer.getPoints());
    }

    // Test branch where player rolls Tutto the Cloverleaf card.
    @Test
    void playTurn5() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        // Replace the deck in the TurnLogic with a StubDeck
        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck5 deck = new StubDeck5();
        deckField.set(aTurnLogic, deck);

        Field strategyField = Card.class.getDeclaredField("strategy");
        strategyField.setAccessible(true);
        StubCardStrategy4 aStubStrategy = new StubCardStrategy4();
        strategyField.set(deck.aCard, aStubStrategy);

        input = "0";    // In this branch the code will ask the user for input, so I must provide the input.
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(2, aTurnLogic.playTurn(testPlayer));
        assertEquals(0, testPlayer.getPoints());    // For the Cloverleaf card, players points should not be updated in the TurnLogic class.
    }

    /* Test if the method TurnLogic.playerWantsToContinuePlaying returns false if the
    * player enters a zero 0. */
    @Test
    void playerWantsToContinue1() {
        String input = "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertFalse(playerWantsToContinuePlaying());
    }

    /* Test if the method TurnLogic.playerWantsToContinuePlaying returns true if the
     * player enters a zero 1. */
    @Test
    void playerWantsToContinue2() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(playerWantsToContinuePlaying());
    }

    /* Test a wrong input type.*/
    @Test
    void playerWantsToContinue3(){
        String input = "Hallo\n0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertFalse(playerWantsToContinuePlaying());
    }

    /* Test wrong value for integer. */
    @Test
    void playerWantsToContinue4(){
        String input = "2\n0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertFalse(playerWantsToContinuePlaying());
    }

    // Helper method to make the UUT accessible (see chapter 5.7)
    private boolean playerWantsToContinuePlaying(){
        try{
            Method method = TurnLogic.class.getDeclaredMethod("playerWantsToContinuePlaying");
            method.setAccessible(true);
            return (boolean) method.invoke(aTurnLogic);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * In the following code a number of stub classes are defined which I use to test the TurnLogic class.
    * */
    static class StubDeck1 implements DeckInterface{
        public Card drawCard(){
            return new StubCard1();
        }
    }
    static class StubCard1 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            return new StubCardStrategy1();
        }
    }

    static class StubCardStrategy1 implements CardStrategyInterface{

        @Override
        public Tuple executeStrategy() {
            return new Tuple(0, false);
        }
    }

    static class StubDeck2 implements DeckInterface{
        public Card drawCard(){
            return new StubCard2();
        }
    }

    static class StubCard2 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            return new StubCardStrategy2();
        }
    }

    static class StubCardStrategy2 implements CardStrategyInterface{
        @Override
        public Tuple executeStrategy() {
            return new Tuple(1, false);
        }
    }

    static class StubDeck3 implements DeckInterface{
        public Card drawCard(){
            return new StubCard3();
        }
    }

    static class StubCard3 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            return new StubCardStrategy3();
        }
    }

    static class StubCardStrategy3 implements CardStrategyInterface{
        @Override
        public Tuple executeStrategy() {
            return new Tuple(1, true);
        }
    }

    static class StubDeck4 implements DeckInterface{
        public Card aCard = new PlusMinus("PlusMinus");
        public Card drawCard(){
            return aCard;
        }
    }

    static class StubCardStrategy4 implements CardStrategyInterface{
        @Override
        public Tuple executeStrategy() {
            return new Tuple(1, true);
        }
    }

    static class StubDeck5 implements DeckInterface{
        public Card aCard = new Cloverleaf("Cloverleaf");
        public Card drawCard(){
            return aCard;
        }
    }
}