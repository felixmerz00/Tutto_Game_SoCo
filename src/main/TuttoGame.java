import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class TuttoGame {

    private final int maxPoints;

    private final int numberOfPlayers;

    private ArrayList<Player> playerList;

    private final TurnLogic turn;

    public static void main(String[] args){

        TuttoGame aGame = new TuttoGame();
        aGame.playGame();
    }


    /* It is the constructors responsibility to set up the game.
     * Instantiate deck, players */
    public TuttoGame(){
        //set up game
        maxPoints = inputMaxPoints();
        numberOfPlayers = inputNumberOfPlayers();
        playerList = new ArrayList<Player>();
        turn = new TurnLogic();

        // Add the number of players that were requested
        for (int i = 0; i < numberOfPlayers; i++){
            playerList.add(new Player(i+1));
        }
    }


    public void playGame() {
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

            //Get input if the player wants to take his turn (R) or display the scores (D) of all players
            String r = "R";
            String d = "D";
            boolean validInput = false;
            System.out.println("----------------------------\n");
            System.out.print("Enter R to play your turn or smack the D to display scores of all players: ");
            boolean displayScores = false;
            while (!validInput) {
                Scanner scan = new Scanner(System.in);
                String line = scan.nextLine();
                if (line.length() == 1) { // check that input is only one char
                    if (line.equals(r) || line.equals(d)) { //check that this char is either R or D
                        validInput = true;
                        if (line.equals(d)) {
                            displayScores = true;
                        }
                    }
                    else {
                        System.out.print("Is it so hard to enter one of these two upper case letter you twat?!\nTry again, but use your brain: ");
                    }

                } else {
                    System.out.print("Come on, only one character is needed, either R or D!\nTry again: ");
                }
            }

            if (displayScores) {
                printScoreBoard();
            }

            // Let players take turns (delegated to TurnLogic)
            System.out.println("\n----------------------------\n");
            System.out.println("It's your turn " + playerList.get(player).getName() + "!\n");
            turn.playTurn(playerList.get(player));
        }
    }



    // Ask for the number of players and validate the input
    private int inputNumberOfPlayers() {
        System.out.println("\n----------------------------\n");
        System.out.println("Please enter the amount of player (min: 2, max: 4): "); // Ask user about input

        boolean validInput = false;
        int numPlayer = 0;
        while (!validInput) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            if (scan.hasNextInt()) {
                numPlayer = scan.nextInt();
                if (numPlayer < 2 || numPlayer > 4) {
                    System.out.println("\n----------------------------\n");
                    System.out.print("Get some friends or play in two groups!\nTry again with valid amount of players: ");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.println("\n----------------------------\n");
                System.out.print("Between 2 and 4, that could be 2, 3 or 4 if you did not know that?\nTry again:");
            }

        }
        System.out.println("\n----------------------------\n");
        System.out.println("Game with " + numPlayer + " players initiated, have fun!");  // Output user input
        System.out.println("\n----------------------------\n");

        return numPlayer;
    }

    // Ask for the max points and validate the input
    private int inputMaxPoints() {
        System.out.println("Please enter the winning points: "); // Ask user about input

        boolean validInput = false;
        int winningPoints = 0;
        while (!validInput) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            if (scan.hasNextInt()) {
                winningPoints = scan.nextInt();
                if (winningPoints < 1000 || winningPoints > 10000) {
                    System.out.println("Input must be between 1000 and 10000! Please enter new number: ");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.println("Don't be silly, you know that a winning number must be an integer.\nTry again but make an effort:");
            }

        }
        System.out.println("\n----------------------------\n");
        System.out.println("First player to reach " + winningPoints + " points will be the winner!");  // Output user input
        return winningPoints;
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
        System.out.println("And the Winner is " + topPlayer.getName());
        return true;
    }

    private boolean maxPointsReached(){
        boolean maxPointsReached = false;
        for (Player player: playerList){
            if (player.getPoints() > maxPoints) {
                maxPointsReached = true;
                break;
            }
        }
        return maxPointsReached;
    }

    public void printScoreBoard(){
        System.out.println("----------------------------\n");
        System.out.println("Scoreboard:\n");
        int count = 1;
        for (Player player: playerList){
            System.out.println(count + ".  " + player.getName() + " has " + player.getPoints() + " points");
            count += 1;
        }
    }
}
