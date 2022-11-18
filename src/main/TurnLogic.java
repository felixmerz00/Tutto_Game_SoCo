import dice.DiceCollection;

public class TurnLogic {
    private int turnPoints;
    private Player currentPlayer;
    private DiceCollection aDiceCollection;

    public TurnLogic() {
        this.aDiceCollection = new DiceCollection();
    }

    public void playTurn(Player currPlayer) {
        this.currentPlayer = currPlayer;    // Tell the TurnLogic which player is playing right now.
        this.turnPoints = 0;
        // draw card from deck,
        // tell user what card,
        // tell user what he's allowed to do,
        /* forward dice roll and result, apply card logic to current turn (access the correct card
        * logic based how the STRATEGY pattern was implemented), sum up points, update points of the currentPlayer */

    }

    public void addPoints(int points) {
        turnPoints += points;
    }
}
