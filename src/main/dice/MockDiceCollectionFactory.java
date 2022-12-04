package dice;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MockDiceCollectionFactory {

    //reSet values?
    public static DiceCollectionInterface mockDiceCollectionCreate(int[] values) throws NoSuchFieldException, IllegalAccessException{
        //DiceCollectionInterface tDiceCollection = new DiceCollection();

        ArrayList<Dice> Dice = new ArrayList<>();
        //create the dices & put dice with values in ArrayList
        for(int a: values){
            Dice.add(setEyes(a));
        }
        DiceCollectionInterface aMockDiceCollection = new MockDiceCollection();
        Field DiceAccess = MockDiceCollection.class.getSuperclass().getDeclaredField("TheDice") ;
        DiceAccess.setAccessible(true);
        DiceAccess.set(aMockDiceCollection, Dice);

        return aMockDiceCollection;
    }

    public static Dice setEyes(int value) throws NoSuchFieldException, IllegalAccessException {
        Dice aDice = new Dice();
        Field eyes = Dice.class.getDeclaredField("eyes");
        eyes.setAccessible(true);
        eyes.set(aDice, value);
        return aDice;
    }

}
