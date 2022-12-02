package strategy;

public class CloverleafStrategy extends BaseStrategy{
//Has to play dice till 2 tuttos, when reached wins the game, else nothing happens

    // cant stop rolling the dice
    @Override
    protected String rollAgain(){
        return "R";
    }

    @Override
    public NullTuple executeStrategy(){
        System.out.println("""
                Cloverleaf: You have to try to accomplish a “TUTTO” twice in a row on this turn
                and may not stop before you do. If you roll a null, you don’t score any points. But
                if you succeed, the game ends immediately, and you win – no matter what score
                you have!""");
        //first dice game
        Tuple result = super.executeStrategy();
        if(result.success){
            System.out.println("One Tutto to go! ");
            //second dice game
            Tuple result1 = super.executeStrategy();
            if(result1.success){
                System.out.println("Congrats, you got the second Tutto! ");
                return new NullTuple(10000,true);
            }
            else return  new NullTuple(0,false);
        }
        else return  new NullTuple(0,false);
    }
}
