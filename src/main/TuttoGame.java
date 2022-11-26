import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class TuttoGame {

    private final int maxPoints;

    private final int numberOfPlayers;

    private Deck aDeck;

    private ArrayList<Player> playerList;

    public static void main(String[] args){
        TuttoGame aGame = new TuttoGame();
    }

    /* It is the constructors responsibility to set up the game.
     * Instantiate deck, players */
    public TuttoGame(){
        //set up game
        this.maxPoints = inputMaxPoints();
        this.numberOfPlayers = inputNumberOfPlayers();

        // Add the number of players that were requested
        for (int i = 0; i < numberOfPlayers; i++){
            playerList.add(new Player(i+1));
        }

        // Instantiate Deck
        this.aDeck = new Deck();

        // Instantiate TurnLogic with SINGLETON
        playGame(numberOfPlayers);
    }

    // Ask for the number of players and validate the input
    private int inputNumberOfPlayers() {
        System.out.println("Please enter the amount of player (min: 2, max: 4): "); // Ask user about input

        boolean validInput = false;
        int numPlayer = 0;
        while (!validInput) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            if (scan.hasNextInt()) {
                numPlayer = scan.nextInt();
                if (numPlayer < 2 || numPlayer > 4) {
                    System.out.print("Get some friends or play in two groups!\nTry again with valid amount of players: ");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.print("Do I really need to explain the range from 2 to 4 to you?\nTry again:");
            }

        }
        System.out.println("Game with " + numPlayer + "initiated, have fun!");  // Output user input
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
                    System.out.print("Input must be between 1000 and 10000! Please enter new number: ");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.print("Don't be silly, you know that a winning number must be an integer.\nTry again but make an effort:");
            }

        }
        System.out.println("First player to reach " + winningPoints + " points will be the winner!");  // Output user input
        return winningPoints;
    }

    public void playGame(int numberOfPlayers) {
        boolean gameEnd = false;
        while (!gameEnd) {
            //apply rules and assign players to turn for a round
            for (int player = 0; player < numberOfPlayers; player++) {

                //Get input if the player wants to take his turn (R) or display the scores (D) of all players
                String r = "R";
                String d = "D";
                boolean validInput = false;
                System.out.print("Enter R to play your turn or smack the D to display scores of all players: ");
                boolean displayScores = false;
                while (!validInput) {
                    Scanner scan = new Scanner(System.in);
                    String line = scan.nextLine();
                    if (line.length() == 1) { // check that input is only one char
                        if (line.equals(r)) { //check that this char is either R or D
                            validInput = true;
                        }
                        if (line.equals(d)) {
                            displayScores = true;
                            validInput = true;
                        } else {
                            System.out.print("Such a challenge to hit the right key you twat?!\nTry again, but use your brain: ");
                        }

                    } else {
                        System.out.print("Come on, one character is needed, either R or D!\nTry again: ");
                    }
                }
                if (displayScores) {
                    printScoreBoard();
                }

                // Let players take turns (delegated to TurnLogic)
                TurnLogic turn = new TurnLogic();
                turn.playTurn(playerList.get(player));
            }
            // Check maxPoints was reached.
            if (maxPointsReached()) {
                gameEnd = endGame();
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
        System.out.print("And the Winner is Player " + playerList.indexOf(topPlayer) + 1);
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
        //prints scoreboard
    }
}
