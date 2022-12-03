package strategy;

public class FireworksStrategy extends BaseStrategy{

    //roll till null, put back all dice available
    @Override
    protected Boolean putAnotherDiceBack(){
        return true;
    }
    @Override
    protected String rollAgain(){
        return "R";
    }


    @Override
    public NullTuple executeStrategy() {
        System.out.println("""
                Fireworks: You have to keep throwing the dice until you roll a null. After each roll,
                you need to keep all valid single dice and triplets. If you accomplish a “TUTTO”,
                you have to continue without revealing a new card. Your turn ends only when you
                roll a null. However, you score all points you have rolled on this turn.\s""");
        int points = 0;
        NullTuple result =  new NullTuple(0,true);
        while(!result.Null){
            result = super.executeStrategy();
            points += result.points;
        }
        result.points = points;
        return result;
    }
}
