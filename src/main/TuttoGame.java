import java.util.ArrayList;

public class TuttoGame {

    private final int maxPoints;

    private Deck aDeck;

    private ArrayList<Player> playerList;

    public static void main(String[] args){
        TuttoGame aGame = new TuttoGame();
        aGame.setUpGame();
    }

    /* It is the constructors responsibility to set up the game.
     * Instantiate deck, players */
    public TuttoGame(){
        //set up game
        this.maxPoints = inputMaxPoints();
        int numberOfPlayers = inputNumberOfPlayers();
        // Add the number of players that were requested
        /*
        for(numberOfPlayersRequested) {
            playerList.add(new Player());
        }*/

        // Instantiate Deck
        this.aDeck = new Deck();

        // Instantiate TurnLogic with SINGLETON
    }

    // Ask for the number of players and validate the input
    private int inputNumberOfPlayers() {
        return 0;
    }

    // Ask for the max points and validate the input
    private int inputMaxPoints() {
        return 0;
    }

    public void playGame() {
        //apply rules and assign players to turn
        /* Get input if the player wants to take his turn (R) or display the scores (D) of all players
        * Let players take turns (delegated to TurnLogic)
        * Check maxPoints was reached. */
    }

    public void endGame() {
        // Compare scores of the players
        // Print Ranking
    }
}
