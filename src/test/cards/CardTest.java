package cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import strategy.CloverleafStrategy;

import java.lang.reflect.Field;

class CardTest {
    //test for every card if display method works, except Bonus Cards -> test in BonusTest
    @Test
    void testDisplayCloverleaf() {
        Card cloverleaf = new Cloverleaf();
        assertTrue(cloverleaf.display().equals("Cloverleaf"));
    }
    @Test
    void testDisplayFireworks() {
        Card fireworks = new Fireworks();
        assertTrue(fireworks.display().equals("Fireworks"));
    }
    @Test
    void testDisplayPlusMinus() {
        Card plusMinus = new PlusMinus();
        assertTrue(plusMinus.display().equals("PlusMinus"));
    }
    @Test
    void testDisplayStop() {
        Card stop = new Stop();
        assertTrue(stop.display().equals("Stop"));
    }
    @Test
    void testDisplayStraight() {
        Card straight = new Straight();
        assertTrue(straight.display().equals("Straight"));
    }
    @Test
    void testDisplayTimesTwo() {
        Card timesTwo = new TimesTwo();
        assertTrue(timesTwo.display().equals("x2"));
    }

    @Test
    void getStrategy() {
        //check if get strategy returns cloverleaf.strategy
        Cloverleaf cloverleaf = new Cloverleaf();
        assertTrue(cloverleaf.getStrategy() == cloverleaf.strategy);
    }
    @Test
    void testSetStrategy() {
        //check if correct strategy is set
        Cloverleaf cloverleaf = new Cloverleaf();
        assertTrue(cloverleaf.strategy instanceof CloverleafStrategy);
    }
}