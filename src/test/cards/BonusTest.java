package cards;

import org.junit.jupiter.api.Test;
import strategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    Bonus bonus200 = new Bonus("Bonus",200);
    Bonus bonus300 = new Bonus("Bonus", 300);
    Bonus bonus400 = new Bonus("Bonus", 400);
    Bonus bonus500 = new Bonus("Bonus", 500);
    Bonus bonus600 = new Bonus("Bonus", 600);

    List<Bonus> bonusInstances = Arrays.asList(bonus200, bonus300, bonus400, bonus500, bonus600);
    List<Integer> bonusPoints = Arrays.asList(200, 300, 400, 500, 600);
    BonusStrategy BonusStrategy200 = new BonusStrategy200();
    BonusStrategy BonusStrategy300 = new BonusStrategy300();
    BonusStrategy BonusStrategy400 = new BonusStrategy400();
    BonusStrategy BonusStrategy500 = new BonusStrategy500();
    BonusStrategy BonusStrategy600 = new BonusStrategy600();

    List<BonusStrategy> strategies = Arrays.asList(BonusStrategy200, BonusStrategy300, BonusStrategy400, BonusStrategy500, BonusStrategy600);

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
    void testDisplay() {
        Bonus testBonus = new Bonus("Bonus", 200);
        String output = testBonus.display();
        assertEquals("Bonus (200)", output);
    }

    /*@Test
    void testInvokedStrategy() {
        BonusStrategy invoked = bonus600.Strategy;
        BonusStrategy600 yes = new BonusStrategy600();
        BonusStrategy is = invoked.getClass();
        System.out.println(is);
        System.out.println(invoked);
        System.out.println(yes);
    }*/
}