import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

class TuttoGameTest {

    TuttoGame testGame = new TuttoGame();

    @BeforeEach
    void setUp(){
    }

    @Test
    void main() {

    }

    @Test
    void playGame() {
    }

    @Test
    void endGame() {
    }

    /*@Test
    void maxPointsReachedTrue() {
        String input = "jim\nbob\njack\ntim";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ArrayList<Player> playerListTest = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            playerListTest.add(new Player(i+1));
        }
        playerListTest.get(0).updatePoints(6000);
        playerListTest.get(1).updatePoints(3000);
        playerListTest.get(2).updatePoints(1000);
        playerListTest.get(3).updatePoints(5000);

        assertTrue(testGame.(playerListTest, 6000));
    }*/

    @Test
    void maxPointsReachedFalse() {
    }



}