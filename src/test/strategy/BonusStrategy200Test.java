package strategy;

import dice.DiceCollectionInterface;
import dice.MockDiceCollectionFactory;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BonusStrategy200Test {

    @Test
    void RolledNullTest() throws NoSuchFieldException,IllegalAccessException{
        int[] values = {2, 3, 4, 6, 2, 3};
        DiceCollectionInterface aMockDiceCollection = MockDiceCollectionFactory.MockDiceCollectionCreate(values);

        BaseStrategy aStrat = new BonusStrategy200();

        //injection
        Field DiceCollection = BaseStrategy.class.getDeclaredField("aDiceCollection");
        DiceCollection.setAccessible(true);
        DiceCollection.set(aStrat, aMockDiceCollection);


        NullTuple result = aStrat.executeStrategy();
        assertTrue(result.Null);

    }
}
