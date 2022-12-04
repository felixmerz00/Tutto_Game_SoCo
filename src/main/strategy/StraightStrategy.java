package strategy;

public class StraightStrategy extends BaseStrategy{
    //cant stop, new rule for is valid
    public StraightStrategy(){
        this.UserInterface = new StraigthStrategyUI();
    }

    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                Straight: Attention! This card changes the rules for valid dice. You have to try to
                accomplish a “Straight” and may not stop before you do. A “Straight” consists of all
                six numbers. As usual, you have to keep at least one valid die
                after each roll. In this case, a valid die is a die that shows a number that you have not
                yet put aside. If the roll doesn’t contain any valid die, it counts as a null and you don’t
                score any points. But if you accomplish a “Straight”, you score 2,000 points for it. A
                “Straight” is considered a “TUTTO” – consequently, you may continue if you want.""");
        NullTuple result = super.executeStrategy();
        if(result.success){
            result.points = 2000;
        }
        else result.points = 0;

        return result;
    }
}