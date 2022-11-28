package diceTest;


import dice.DiceCollection;
import org.junit.Test;

public class DiceCollectionTest {
    @Test
    public void PutDiceAwayTest(){
        DiceCollection aDiceCollection = new DiceCollection();
        aDiceCollection.printDiceCollection();
        aDiceCollection.putDiceAway(1,false);
        aDiceCollection.putDiceAway(5,false);
        aDiceCollection.printDiceCollection();
    }
    @Test
    public void rollDiceTest(){
        DiceCollection aDiceCollection = new DiceCollection();
        aDiceCollection.printDiceCollection();
        aDiceCollection.rollDices();
        aDiceCollection.printDiceCollection();
    }
    @Test
    public void PutTripletAwayTest(){
        DiceCollection aDiceCollection = new DiceCollection();
        aDiceCollection.printDiceCollection();
        while(!aDiceCollection.hasTriplet(1)){
            aDiceCollection.rollDices();
        }
        aDiceCollection.printDiceCollection();
        aDiceCollection.putDiceAway(1,true);
        aDiceCollection.printDiceCollection();

    }
}
