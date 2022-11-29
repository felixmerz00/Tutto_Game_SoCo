import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringBufferInputStream;
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

    // Copy code from chapter 5.7 to test private method.
    @Test
    void playerWantsToContinue() {
        InputStream inStream = new StringBufferInputStream("0");
        System.setIn(inStream);
        assertTrue(playerWantsToContinuePlaying());
    }

    // Helper method to make the UUT accessible
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