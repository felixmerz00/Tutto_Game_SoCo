import cards.Card;
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

        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck2 deck = new StubDeck2();
        deckField.set(aTurnLogic, deck);
        aTurnLogic.playTurn(testPlayer);

        assertEquals(1, testPlayer.getPoints());
    }

    // Test branch where player rolls Tutto
    @Test
    void playTurn3() throws NoSuchFieldException, IllegalAccessException {
        String input = "Olaf\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck3 deck = new StubDeck3();
        deckField.set(aTurnLogic, deck);
        input = "0";    // In this branch the code will ask the user for input, so I must provide the input.
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        aTurnLogic.playTurn(testPlayer);

        assertEquals(1, testPlayer.getPoints());
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
            StubCard1 aStubCard = new StubCard1();
            return aStubCard;
        }
    }
    static class StubCard1 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            CardStrategyInterface StubCardStrategy = new StubCardStrategy1();
            return StubCardStrategy;
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
            StubCard2 aStubCard = new StubCard2();
            return aStubCard;
        }
    }

    static class StubCard2 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            CardStrategyInterface StubCardStrategy = new StubCardStrategy2();
            return StubCardStrategy;
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
            StubCard3 aStubCard = new StubCard3();
            return aStubCard;
        }
    }

    static class StubCard3 extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            CardStrategyInterface StubCardStrategy = new StubCardStrategy3();
            return StubCardStrategy;
        }
    }

    static class StubCardStrategy3 implements CardStrategyInterface{
        @Override
        public Tuple executeStrategy() {
            return new Tuple(1, true);
        }
    }
}