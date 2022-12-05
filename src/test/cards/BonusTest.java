package cards;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    Bonus bonus200 = new Bonus(200);
    Bonus bonus300 = new Bonus(300);
    Bonus bonus400 = new Bonus(400);
    Bonus bonus500 = new Bonus(500);
    Bonus bonus600 = new Bonus( 600);

    List<Bonus> bonusInstances = Arrays.asList(bonus200, bonus300, bonus400, bonus500, bonus600);
    List<Integer> bonusPoints = Arrays.asList(200, 300, 400, 500, 600);

    @Test
    void testCreateBonus() {
        for (int i=0; i<5; i++) {
            String name = bonusInstances.get(i).cardName;
            Integer points = Integer.parseInt(bonusInstances.get(i).display().substring(7,10));
            assertEquals("Bonus", name);
            assertEquals(bonusPoints.get(i), points);
        }
    }

    @Test
    void testDisplay200() {
        String output = bonus200.display();
        assertEquals("Bonus (200)", output);
    }
    @Test
    void testDisplay300() {
        String output = bonus300.display();
        assertEquals("Bonus (300)", output);
    }
    @Test
    void testDisplay400() {
        String output = bonus400.display();
        assertEquals("Bonus (400)", output);
    }
    @Test
    void testDisplay500() {
        String output = bonus500.display();
        assertEquals("Bonus (500)", output);
    }
    @Test
    void testDisplay600() {
        String output = bonus600.display();
        assertEquals("Bonus (600)", output);
    }
}