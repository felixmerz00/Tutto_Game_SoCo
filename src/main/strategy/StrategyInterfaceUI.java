package strategy;

import dice.DiceCollectionInterface;

public interface StrategyInterfaceUI {
    boolean putAnotherDiceBack();
    boolean rollAgain();
    boolean isTriplet(int Number, DiceCollectionInterface aDiceCollection);
    Tuple putBackDice(DiceCollectionInterface aDiceCollection);

    boolean isNull(DiceCollectionInterface aDiceCollection);

}
