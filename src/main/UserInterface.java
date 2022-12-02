import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface implements UserInputInterface {

    public int userInputNumberOfPlayers(){
        System.out.println("Please enter the amount of player (min: 2, max: 4): "); // Ask user about input
        boolean validInput = false;
        int numPlayer = 0;
        while (!validInput) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            if (scan.hasNextInt()) {
                numPlayer = scan.nextInt();
                if (numPlayer < 2 || numPlayer > 4) {
                    System.out.println("\n----------------------------\n");
                    System.out.print("Only two up to 4 players allowed!\n" +
                            "Try again with valid amount of players: ");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.println("\n----------------------------\n");
                System.out.print("Input must be an integer and between 2 and 4?\nTry again:");
            }

        }
        System.out.println("\n----------------------------\n");
        System.out.println("Game with " + numPlayer + " players initiated, have fun!");  // Output user input
        System.out.println("\n----------------------------\n");

        return numPlayer;
    }

    public int userInputMaxPoints(){
        System.out.println("Please enter the winning points: "); // Ask user about input
        boolean validInput = false;
        int winningPoints = 0;
        while (!validInput) {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            if (scan.hasNextInt()) {
                winningPoints = scan.nextInt();
                if (winningPoints < 5000 || winningPoints > 10000) {
                    System.out.println("Input must be between 5000 and 10000! Please enter new number: ");
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
        System.out.println("\n----------------------------\n");
        return winningPoints;
    }

    public boolean userInputChooseTurnPoints() {
        String r = "R";
        String d = "D";
        boolean validInput = false;
        System.out.print("press R to roll dices\npress D to display scores\n");
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
                    System.out.print("Is it so hard to enter one of these two upper case letter you twat?!\n" +
                            "Try again, but use your brain: ");
                }
            }
            else {
                System.out.print("Come on, only one character is needed, either R or D!\nTry again: ");
            }
        }
        return displayScores;
    }

    public String inputName(int playerCount) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username for player " + playerCount + ": ");
        String playerName = null;
        boolean validInput = false;
        while (!validInput) {
            playerName = myObj.nextLine();  // Read user input
            if (playerName.length() > 0){
                validInput = true;
            }
            else {
                System.out.println("Name must be at least on character long, try again: ");
            }
        }
        System.out.println("Username of player "+ playerCount +" is: " + playerName +"\n");  // Output user input
        return playerName;
    }

    @Override
    public void printScoreBoard(ArrayList<Player> playerList){ //move to UI class and pass tuttogame to be able to acess playerlis?
        System.out.println("----------------------------\n");
        System.out.println("Scoreboard:\n");
        int count = 1;
        for (Player player: playerList){
            System.out.println(count + ".  " + player.getName() + " has " + player.getPoints() + " points");
            count += 1;
        }
        System.out.println("\n----------------------------\n");
    }

    @Override
    public void userOutputWinByPoints(String winner) {
        System.out.println("\n" +
                "████████╗██╗░░░██╗████████╗████████╗░█████╗░\n" +
                "╚══██╔══╝██║░░░██║╚══██╔══╝╚══██╔══╝██╔══██╗\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░╚██████╔╝░░░██║░░░░░░██║░░░╚█████╔╝\n" +
                "   Player "+ winner +" winns with a double tutto\n" +
                "████████╗██╗░░░██╗████████╗████████╗░█████╗░\n" +
                "╚══██╔══╝██║░░░██║╚══██╔══╝╚══██╔══╝██╔══██╗\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░╚██████╔╝░░░██║░░░░░░██║░░░╚█████╔╝\n" );
    }

    @Override
    public void userOutputWinByDoubleTutto(String winner) {
        System.out.println("\n" +
                "░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗░\n" +
                "░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗\n" +
                "░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝\n" +
                "░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗\n" +
                "░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║\n" +
                "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝\n" +
                "          Player "+ winner + " wins by points\n" +
                "░██╗░░░░░░░██╗██╗███╗░░██╗███╗░░██╗███████╗██████╗░\n" +
                "░██║░░██╗░░██║██║████╗░██║████╗░██║██╔════╝██╔══██╗\n" +
                "░╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗░░██████╔╝\n" +
                "░░████╔═████║░██║██║╚████║██║╚████║██╔══╝░░██╔══██╗\n" +
                "░░╚██╔╝░╚██╔╝░██║██║░╚███║██║░╚███║███████╗██║░░██║\n" +
                "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝\n" );
    }
}
