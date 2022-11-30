import cards.Card;
import dice.DiceCollection;
import strategy.*;

import java.util.Scanner;

public class TurnLogic {
    private DiceCollection aDiceCollection;
    private Deck aDeck;
    private Context aContext;

    public TurnLogic() {
        aDiceCollection = new DiceCollection();
        aDeck = new Deck();
        aContext = new Context();
    }

    public void playTurn(Player currPlayer) {
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
            CardStrategyInterface aStragey = currentCard.getStrategy();
            aContext.setStrategy(aStragey);
            resultFromRoll = aContext.doSomething();
            turnPoints += resultFromRoll.points;
            if(resultFromRoll.points == 0) { // This means the roll was a Null. All points get deleted and the turn is over.
                turnPoints = 0;
            }
            if(resultFromRoll.success){
                // Implement behavior for cloverleaf: Problem: I cannot end the game, this is done in the TuttoGame class.
                // Implement behavior for plus/minus card: Problem: I cannot access the other Players, this is done in the TuttoGame class.
                // If the player achieved Tutto, ask player if he wants to continue playing
                turnUnfinished = playerWantsToContinuePlaying();
            }
        }
        // Add scored points from this turn to the players total points
        currPlayer.updatePoints(turnPoints);
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
            }
        }
    }

}
