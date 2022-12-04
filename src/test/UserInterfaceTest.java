import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    UserInterface testUserInterface = new UserInterface();
    //check all possible invalid iputs aswell as possible ones
    @Test
    void testUserInputNumberOfPlayers() {
        String input = "hello\n0\n2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(2, testUserInterface.userInputNumberOfPlayers());

    }

    @Test
    void userInputMaxPoints() {
        String input = "hello\n0\n1000000\n5000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(5000, testUserInterface.userInputMaxPoints());
    }

    @Test
    void userInputDisplayPoints() {
        String input = "hello\n0\n1000\nr\nD";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(testUserInterface.userInputDisplayPoints());
    }

    @Test
    void userInputNotDisplayPoints() {
        String input = "hello\n0\n1000\nd\nR";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertFalse(testUserInterface.userInputDisplayPoints());
    }

    @Test
    void printScoreBoard() {
    }

    @Test
    void userOutputWinByDoubleTutto() { //nothing to test at it only prints
    }

    @Test
    void userOutputWinByPoints() { //nothing to test at it only prints
    }

}