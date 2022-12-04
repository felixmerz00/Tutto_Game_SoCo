package strategy;

public class FireworksStrategyUI extends StrategyUI implements StrategyInterfaceUI{

    //roll till null, put back all dice available
    @Override
    public boolean putAnotherDiceBack(){
        return true;
    }
    @Override
    public boolean rollAgain(){
        return true;
    }
}
