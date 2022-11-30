import cards.Card;
import strategy.BaseStrategy;
import strategy.CardStrategyInterface;
import strategy.Tuple;

public class Context {
    private CardStrategyInterface aStrategy;
    public Context() {
    }
    public void setStrategy(CardStrategyInterface strategy){
        aStrategy = strategy;
    }
    public Tuple doSomething(){
        return aStrategy.executeStrategy();
    }
}
