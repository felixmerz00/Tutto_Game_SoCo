package strategy;

public class CloverleafStrategyUI extends StrategyUI implements StrategyInterfaceUI{

    // cant stop rolling the dice
    @Override
    public boolean rollAgain(){
        return true;
    }

}
