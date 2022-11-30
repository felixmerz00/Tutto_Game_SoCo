import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

class PlayerTest {
    Player playerTest;
    @BeforeEach
    void setUp() {
        String nameInput = "Tommy";
        System.setIn(new ByteArrayInputStream(nameInput.getBytes()));
        this.playerTest = new Player(1);
    }
    @Test
    void PlayerName() {
        String nameInput = "Timmy";
        System.setIn(new ByteArrayInputStream(nameInput.getBytes()));
        Player playerTest = new Player(2);
        assertEquals(nameInput, playerTest.getName());
    }

    @Test
    void PlayerWrongName() { //not done...
        String nameInput = "";
        System.setIn(new ByteArrayInputStream(nameInput.getBytes()));
        String nameInput1 = "Ab";
        System.setIn(new ByteArrayInputStream(nameInput1.getBytes()));
        Player playerTest = new Player(3);
        assertEquals("Ab", playerTest.getName());
    }

    @Test
    void PlayerPoints() {
        assertEquals(0, playerTest.getPoints());
    }

    @Test
    void updatePoints() {
        playerTest.updatePoints(1550);
        playerTest.updatePoints(300);
        playerTest.updatePoints(-200);
        assertEquals(1650, playerTest.getPoints());
    }

    @Test
     void updateNegPoints() {
        playerTest.updatePoints(-200);
        playerTest.updatePoints(-100);
        playerTest.updatePoints(-50);
        assertEquals(-350, playerTest.getPoints());
    }
}