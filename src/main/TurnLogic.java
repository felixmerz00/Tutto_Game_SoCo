import cards.Card;
import dice.DiceCollection;

import java.util.Scanner;

public class TurnLogic {
    private int turnPoints; // Question to my future self: Do I need this field or can I just a local variable in the playTurn() method without storing it.
    private Player currentPlayer;   // Question to my future self: Do I need this field or can I just use the passed parameter from  the playTurn() method without storing it.
    private DiceCollection aDiceCollection;

    public TurnLogic() {
        this.aDiceCollection = new DiceCollection();
    }

    public void playTurn(Player currPlayer) {
        this.currentPlayer = currPlayer;    // Tell the TurnLogic which player is playing right now.
        this.turnPoints = 0;
        boolean turnUnfinished = true;  // The turn is unfinished as long as the player keeps rolling Tutto, except if he decides to finish his turn.
        Tuple resultFromRoll;
        while(turnUnfinished) {
            // draw card from deck, --> To do this I need access to the deck. I asked Andre on teams if we can store the deck in this class instead of the TuttoGame class
            Card currentCard = Deck.drawCard();
            // tell user what card, --> I asked Melea if she can implement a display() method
            currentCard.display();
            /* forward dice roll and result, apply card logic to current turn (access the correct card
             * logic based how the STRATEGY pattern was implemented), sum up points, update points of the currentPlayer */
            // I need two the following information: How many points were achieved? Can the player continue playing? (He can continue if he accomplished Tutto)?
            resultFromRoll = currentCard.callStrategy();
            turnPoints += resultFromRoll.points;
            if(resultFromRoll.points == 0) { // This means the roll was a Null. All points get deleted and the turn is over.
                turnPoints = 0;
            }
            if(resultFromRoll.achievedTutto){ // If player achieved Tutto, ask him if he wants to continue
                // Ask player if he wants to continue and update turnUnfinished based on his response
                turnUnfinished = playerWantsToContinuePlaying();
            }
        }
        // Add scored points from this turn to the players total points
        currentPlayer.updatePoints(turnPoints);
    }

    /* Ask player if he wants to draw another card and continue playing.
    * This method is called if a player achieved Tutto. */
    private boolean playerWantsToContinuePlaying(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to draw another card and continue playing?");
            System.out.println("Enter \"1\" for Yes, enter \"0\" for No.");
            if(scan.hasNextInt()){
                if(scan.nextInt() == 1){
                    return true;
                }else if(scan.nextInt() == 0){
                    return false;
                }else{
                    System.out.print("Your input was invalid. Please try again.");
                }
            }
        }
    }

}
