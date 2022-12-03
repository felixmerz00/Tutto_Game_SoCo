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
    // I need this variable for the helper method of the playerWantsToContinue test method.
    TurnLogic aTurnLogic = new TurnLogic();
    private InputStream sysInBackup;


    static class StubCard extends Card {
        public String cardName = "StubCard";

        public String display(){return cardName;}

        public CardStrategyInterface getStrategy(){
            CardStrategyInterface StubCardStrategy = new StubCardStrategy();
            return StubCardStrategy;
        }
    }

    static class StubCardStrategy implements CardStrategyInterface{

        @Override
        public Tuple executeStrategy() {
            return new Tuple(0, false);
        }
    }

    static class StubDeck implements DeckInterface{
        public Card drawCard(){
            StubCard aStubCard = new StubCard();
            return aStubCard;
        }
    }

    @BeforeEach
    void setUp() {
        sysInBackup = System.in; // backup System.in to restore it later
    }

    @AfterEach
    void tearDown() {
        // optionally, reset System.in to its original
        System.setIn(sysInBackup);
    }

    @Test
    void playTurn() throws NoSuchFieldException, IllegalAccessException {
        String input = "Player Name\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Player testPlayer = new Player(0);

        Field deckField = TurnLogic.class.getDeclaredField("aDeck");
        deckField.setAccessible(true);
        StubDeck deck = new StubDeck();
        deckField.set(aTurnLogic, deck);
        aTurnLogic.playTurn(testPlayer);

        assertEquals(0, testPlayer.getPoints());
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
}