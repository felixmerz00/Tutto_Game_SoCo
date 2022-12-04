package testStrategy;

import dice.DiceCollectionInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;

import dice.MockUI;
import dice.MockDiceCollectionFactory;
import org.junit.jupiter.api.Test;
import strategy.*;

import static org.junit.jupiter.api.Assertions.*;


public class BonusStrategy200Test {

    @Test
    void RolledNullTest() throws NoSuchFieldException,IllegalAccessException{
        int[] values = {2, 3, 4, 6, 2, 3};
        MockDiceCollectionFactory m = new MockDiceCollectionFactory();
        DiceCollectionInterface aMockDiceCollection = m.mockDiceCollectionCreate(values);

        BaseStrategy aStrat = new BonusStrategy200();

        //injection
        Field DiceCollection = BaseStrategy.class.getDeclaredField("aDiceCollection");
        DiceCollection.setAccessible(true);
        DiceCollection.set(aStrat, aMockDiceCollection);

        NullTuple result = aStrat.executeStrategy();
        assertTrue(result.Null);

    }
    @Test
    void Rolled300with2Ones2FivesStopPuttingBack() throws NoSuchFieldException, IllegalAccessException {
        int[] values = {1,1,5,5,3,4};
        DiceCollectionInterface aMockDiceCollection = MockDiceCollectionFactory.mockDiceCollectionCreate(values);
        MockUI MockU = new MockUI();

        ArrayList<Integer> inputOneFiveTriplet = new ArrayList<>();
        inputOneFiveTriplet.add(1);
        inputOneFiveTriplet.add(1);
        inputOneFiveTriplet.add(5);
        inputOneFiveTriplet.add(5);

        ArrayList<Boolean> inputStopRolling = new ArrayList<>();
        inputStopRolling.add(false);

        ArrayList<Boolean>  inputStopPuttingBack = new ArrayList<>();
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);

        ArrayList<Boolean> asTriplet = new ArrayList<>();

        MockU.setInput(inputOneFiveTriplet, inputStopRolling, inputStopPuttingBack, asTriplet);

        BonusStrategy aStrat = new BonusStrategy200();

        //inject diceCollection to strat
        Field aDiceCollection = BaseStrategy.class.getDeclaredField("aDiceCollection");
        aDiceCollection.setAccessible(true);
        aDiceCollection.set(aStrat, aMockDiceCollection);

        //inject ui to strat
        Field aUI = BaseStrategy.class.getDeclaredField("UserInterface");
        aUI.setAccessible(true);
        aUI.set(aStrat, MockU);

        Tuple result = aStrat.executeStrategy();
        assertEquals(300, result.points);
    }

    //not rolling again because everything is put back at the start
    @Test
    void RolledTuttoWithoutTriplets() throws NoSuchFieldException, IllegalAccessException {
        int[] values = {5,1,1,1,5,1};
        DiceCollectionInterface aMockDiceCollection = MockDiceCollectionFactory.mockDiceCollectionCreate(values);
        MockUI MockU = new MockUI();

        ArrayList<Integer> inputOneFiveTriplet = new ArrayList<>();
        inputOneFiveTriplet.add(1);
        inputOneFiveTriplet.add(1);
        inputOneFiveTriplet.add(5);
        inputOneFiveTriplet.add(5);
        inputOneFiveTriplet.add(1);
        inputOneFiveTriplet.add(1);

        ArrayList<Boolean> inputStopRolling = new ArrayList<>();

        ArrayList<Boolean>  inputStopPuttingBack = new ArrayList<>();
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);
        inputStopPuttingBack.add(true);

        ArrayList<Boolean> asTriplet = new ArrayList<>();
        asTriplet.add(false);
        asTriplet.add(false);
        asTriplet.add(false);
        asTriplet.add(false);
        asTriplet.add(false);
        asTriplet.add(false);

        MockU.setInput(inputOneFiveTriplet, inputStopRolling, inputStopPuttingBack, asTriplet);

        BonusStrategy aStrat = new BonusStrategy200();


        //inject mockDiceCollection to strat
        Field aDiceCollection = BaseStrategy.class.getDeclaredField("aDiceCollection");
        aDiceCollection.setAccessible(true);
        aDiceCollection.set(aStrat, aMockDiceCollection);

        //inject mockUI to strat
        Field aUI = BaseStrategy.class.getDeclaredField("UserInterface");
        aUI.setAccessible(true);
        aUI.set(aStrat, MockU);

        Tuple result = aStrat.executeStrategy();
        assertEquals(700, result.points);
    }
}
