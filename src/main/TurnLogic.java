import cards.Card;
import cards.Cloverleaf;
import cards.PlusMinus;
import dice.DiceCollection;
import strategy.*;

import java.util.Scanner;

public class TurnLogic {
    private final Deck aDeck;
    private final Context aContext;

    public TurnLogic() {
        aDeck = new Deck();
        aContext = new Context();
    }

    /* Does the TuttoGame class need to handle something?
    * return 0 = nothing needs to be handled, 1 = handle PlusMinus card, 2 = handle Cloverleaf card */
    public int playTurn(Player currPlayer) {
        int turnPoints = 0;
        boolean turnUnfinished = true;  // The turn is unfinished as long as the player keeps rolling Tutto, except if he decides to finish his turn.
        Tuple resultFromRoll;
        while(turnUnfinished) {
            Card currentCard = aDeck.drawCard();    // draw card from deck
            currentCard.display();  // tell user what card was drawn
            /* Delegate dice roll, to the concrete Card Strategy.
            * I store the following information in a Tuple:
            * How many points were achieved?
            * Can the player continue playing? (He can continue if he accomplished Tutto.)? */
            CardStrategyInterface aStrategy = currentCard.getStrategy();
            aContext.setStrategy(aStrategy);
            resultFromRoll = aContext.doSomething();
            turnPoints += resultFromRoll.points;
            if(resultFromRoll.points == 0) { // This means the roll was a Null. All points get deleted and the turn is over.
                turnPoints = 0;
            }
            if(resultFromRoll.success){
                if(currentCard instanceof PlusMinus){
                    currPlayer.updatePoints(1000);
                    return 1;   // If the player was successful with his PlusMinus card, the TuttoGame object must deduct 1000 points from the leading player(s)
                }
                if(currentCard instanceof Cloverleaf){
                    return 2;   // If the player was successful with his Cloverleaf card, the TuttoGame object must immediately end the game and declare him as winner.
                }
                // If the player achieved Tutto with any other card, ask player if he wants to continue playing
                turnUnfinished = playerWantsToContinuePlaying();
            }
        }
        // Add scored points from this turn to the players total points
        currPlayer.updatePoints(turnPoints);
        return 0;
    }

    /* Ask player if he wants to draw another card and continue playing.
    * This method is called if a player achieved Tutto. */
    private boolean playerWantsToContinuePlaying(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to draw another card and continue playing?");
            System.out.println("Enter \"1\" for Yes, enter \"0\" for No.");
            if(scan.hasNextInt()){
                int input = scan.nextInt();
                if(input == 1){
                    return true;
                }else if(input == 0){
                    return false;
                }else{
                    System.out.print("Your input was invalid. Please try again.");
                }
            }else{
                scan.nextLine();
            }
        }
    }

}
