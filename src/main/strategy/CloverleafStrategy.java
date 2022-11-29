package strategy;

public class CloverleafStrategy extends BaseClass{
//Has to play dice till 2 tuttos, when reached wins the game, else nothing happens

    // cant stop rolling the dice
    @Override
    protected String rollAgain(){
        return "R";
    }

    @Override
    public Tuple executeStrategy(){
        System.out.println("Cloverleaf strat: ");
        //first dice game
        Tuple result = super.executeStrategy();
        if(result.success){
            System.out.println("One Tutto to go! ");
            //second dice game
            Tuple result1 = super.executeStrategy();
            if(result1.success){
                System.out.println("Congrats, you got the second Tutto! ");
                return new Tuple(10000,true);
            }
            else return  new Tuple(0,false);
        }
        else return  new Tuple(0,false);
    }
}

