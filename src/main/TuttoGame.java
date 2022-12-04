import java.util.ArrayList;

public class TuttoGame {

    private final UserInterface userInteraction;

    private final int maxPoints;

    private final int numberOfPlayers;

    private final ArrayList<Player> playerList;

    private static TurnLogic turn;

    public static void main(String[] args){
        System.out.println("Have fun playing Tutto!");
        System.out.println("\n----------------------------\n");

        TuttoGame aGame = new TuttoGame();
        aGame.playGame();
    }


    /* It is the constructors responsibility to set up the game.
     * Instantiate deck, players */
    public TuttoGame(){ //constructor
        //set up game
        userInteraction = new UserInterface();
        maxPoints = userInteraction.userInputMaxPoints(); // Ask for the max points and validate the input
        numberOfPlayers = userInteraction.userInputNumberOfPlayers(); // Ask for the number of players and validate the input
        playerList = new ArrayList<Player>();
        turn = new TurnLogic(); //one turn per Game -> why not initiate in


        // Add and create players to playerList
        for (int i = 0; i < numberOfPlayers; i++){
            playerList.add(new Player(i+1));
        }

    }


    public void playGame() { //copy this into TuttoGame


        boolean gameEnd = false;
        while (!gameEnd) {
            playRound();
            // Check maxPoints was reached.
            if (maxPointsReached()) {
                gameEnd = endGame();
            }
        }
    }

    private void playRound() {
        //apply rules and assign players to turn for a round
        for (int player = 0; player < numberOfPlayers; player++) {

            //inform player that it is his turn
            System.out.println("\n----------------------------\n");
            System.out.println("It's your turn " + playerList.get(player).getName() + "!\n");

            //Get input if the player wants to take his turn (R) or display the scores (D) of all players
            boolean displayScores = userInteraction.userInputDisplayPoints();

            if (displayScores) {
                userInteraction.printScoreBoard(playerList);
            }

            // Let players take turns (delegated to TurnLogic)
            int finishCondition;
            finishCondition = turn.playTurn(playerList.get(player));

            if (finishCondition == 2){ // Player achieves 2 tutto in a row and instantly wins
                playerList.get(player).updatePoints(maxPoints-playerList.get(player).getPoints()+1000000); //make a more clever solution
                break;
            }

            if (finishCondition == 1){ //Player successful with plusMinus --> the best player gets deducted 1000points
                int bestPlayerPoints = 0;
                for (int idx = 0; idx < numberOfPlayers; idx++) {
                    if (playerList.get(idx).getPoints() > bestPlayerPoints){
                        bestPlayerPoints = playerList.get(idx).getPoints();
                    }
                }
                for (int idx = 0; idx < numberOfPlayers; idx++) {
                    if (playerList.get(idx).getPoints() == bestPlayerPoints && player != idx){
                        playerList.get(idx).updatePoints(-1000);
                    }
                }
            }
        }
    }

    public boolean endGame() {
        Player topPlayer = null;
        int currentMax = 0;
        for (Player player: playerList) {
            if (player.getPoints() >= currentMax){
                topPlayer = player;
                currentMax = player.getPoints();
            }
        }
        if (currentMax > 900000){
            userInteraction.userOutputWinByDoubleTutto(topPlayer.getName()); //print winner
        }
        else{
            userInteraction.userOutputWinByPoints(topPlayer.getName()); // print winner
        }
        return true;
    }

    private boolean maxPointsReached(){
        boolean maxPointsReached = false;
        for (Player player: playerList){
            if (player.getPoints() >= maxPoints) {
                maxPointsReached = true;
                break;
            }
        }
        return maxPointsReached;
    }


}
