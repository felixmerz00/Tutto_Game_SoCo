package strategy;

public class PlusMinusStrategy extends BaseStrategy{
    //cant stop rolling, if tutto, then 1000 points, else 0

    @Override
    protected boolean rollAgain(){
        return true;
    }

    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                Plus/Minus: You must try to accomplish a “TUTTO” and may not stop before
                you do. If you roll a null, you don’t score any points. But if you succeed, you score
                exactly 1,000 points, irrespective of the number of points you have rolled. Besides
                this, the leading player has 1,000 points deducted.
                If more than one player is leading with the same number of points, each of them
                has 1,000 points deducted. Nevertheless, you, as the player who is currently rolling
                the dice, score 1,000 points only once. If it is the leading player who reveals this
                card, naturally he doesn’t have to deduct any points from his score when he
                accomplishes a “TUTTO”,""");
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points = 1000;
        }
        else result.points = 0;
        return result;
    }
}