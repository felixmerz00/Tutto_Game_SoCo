package strategy;

public class PlusMinusStrategyUI extends StrategyUI implements StrategyInterfaceUI{

    //cant stop rolling, if tutto, then 1000 points, else 0
    @Override
    public boolean rollAgain(){
        return true;
    }

}
