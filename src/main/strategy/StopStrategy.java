package strategy;

public class StopStrategy extends BaseStrategy{

    @Override
    public NullTuple executeStrategy() {
        System.out.println("Stop: Tough luck! You have to end your turn, and the next Player has his turn.");
        return new NullTuple(0,false);
    }
}
