import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TurnLogicTest {
    // I need this variable for the helper method of the playerWantsToContinue test method.
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

    @Test
    void playTurn() {
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