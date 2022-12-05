package cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import strategy.*;

class CardTest {
    //creat one instance of each card, so we don't have to repeat code in the tests
    Card cloverleaf = new Cloverleaf();
    Card fireworks = new Fireworks();
    Card plusMinus = new PlusMinus();
    Card stop = new Stop();
    Card straight = new Straight();
    Card timesTwo = new TimesTwo();
    //test for every card if display method works, except Bonus Cards -> test in BonusTest
    @Test
    void testDisplayCloverleaf() {
        assertEquals("Cloverleaf", cloverleaf.display());
    }
    @Test
    void testDisplayFireworks() {
        assertEquals("Fireworks", fireworks.display());
    }
    @Test
    void testDisplayPlusMinus() {
        assertEquals("PlusMinus", plusMinus.display());
    }
    @Test
    void testDisplayStop() {
        assertEquals("Stop", stop.display());
    }
    @Test
    void testDisplayStraight() {
        assertEquals("Straight", straight.display());
    }
    @Test
    void testDisplayTimesTwo() {
        assertEquals("x2", timesTwo.display());
    }

    @Test
    void testGetStrategyCloverleaf() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(cloverleaf.getStrategy(), cloverleaf.strategy);
    }
    @Test
    void testGetStrategyFireworks() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(fireworks.getStrategy(), fireworks.strategy);
    }
    @Test
    void testGetStrategyPlusMinus() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(plusMinus.getStrategy(), plusMinus.strategy);
    }
    @Test
    void testGetStrategyStop() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(stop.getStrategy(), stop.strategy);
    }
    @Test
    void testGetStrategyStraight() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(straight.getStrategy(), straight.strategy);
    }
    @Test
    void testGetStrategyTimesTwo() {
        //check if get strategy returns cloverleaf.strategy
        assertSame(timesTwo.getStrategy(), timesTwo.strategy);
    }
    @Test
    void testSetStrategyCloverleaf() {
        //check if correct strategy is set
        assertTrue(cloverleaf.strategy instanceof CloverleafStrategy);
    }
    @Test
    void testSetStrategyFireworks() {
        //check if correct strategy is set
        assertTrue(fireworks.strategy instanceof FireworksStrategy);
    }
    @Test
    void testSetStrategyPlusMinus() {
        //check if correct strategy is set
        assertTrue(plusMinus.strategy instanceof PlusMinusStrategy);
    }
    @Test
    void testSetStrategyStop() {
        //check if correct strategy is set
        assertTrue(stop.strategy instanceof StopStrategy);
    }
    @Test
    void testSetStrategyStraight() {
        //check if correct strategy is set
        assertTrue(straight.strategy instanceof StraightStrategy);
    }
    @Test
    void testSetStrategyTimesTwo() {
        //check if correct strategy is set
        assertTrue(timesTwo.strategy instanceof TimesTwoStrategy);
    }

}