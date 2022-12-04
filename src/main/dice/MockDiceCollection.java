package dice;

import java.util.ArrayList;

public class MockDiceCollection extends DiceCollection implements DiceCollectionInterface {

    //create 6 dices
    private final ArrayList<DiceInterface> Values = new ArrayList<>();

    public MockDiceCollection() {
        super();
    }

    @Override
    public void rollDices(){
        //cant roll dices
    }

    //needs to override the reset method
    @Override
    public void reset() {
    }
}
