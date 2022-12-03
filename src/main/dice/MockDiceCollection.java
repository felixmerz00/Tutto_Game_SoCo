package dice;

import java.util.ArrayList;

public class MockDiceCollection extends DiceCollection implements DiceCollectionInterface {

    //create 6 dices
    private ArrayList<DiceInterface> Values = new ArrayList<>();
    @Override
    public void rollDices(){
        //cant roll dices
    }
}
