package dice;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MockDiceCollectionFactory {

    //reRoll values?
    public static DiceCollection MockDiceCollectionCreate(int[] values) throws NoSuchFieldException, IllegalAccessException{
        DiceCollectionInterface tDiceCollection = new DiceCollection();

        ArrayList<Dice> Dice = new ArrayList<>();
        //create the dices & put dice with values in ArrayList
        for(int a: values){
            Dice.add(setEyes(a));
        }

        //set theDice from DiceCollection as the created arraylist
        Field DiceAccess = DiceCollection.class.getDeclaredField("TheDice");
        DiceAccess.setAccessible(true);
        DiceAccess.set(tDiceCollection, Dice);

        //create MockDiceCollection
        MockDiceCollection aMockDiceCollection = new MockDiceCollection();

        //set refill Values to new refill in MockDiceCollection

        //set the MockDiceCollection as the created DiceCollection
        Field DiceCollectionField = MockDiceCollection.class.getSuperclass().getDeclaredField("TheDice") ;
        DiceCollectionField.setAccessible(true);
        DiceCollectionField.set(aMockDiceCollection, tDiceCollection.TheDice);
        //put dices in ArrayList

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
