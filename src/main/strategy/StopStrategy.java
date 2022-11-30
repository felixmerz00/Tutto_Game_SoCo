package strategy;

public class StopStrategy extends BaseStrategy{
    @Override
    public NullTuple executeStrategy() {
        System.out.println("Stop Card, Bad Luck! Your turn ended.");
        return new NullTuple(0,false);
    }
}
