import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface implements UserInputInterface {

    public int userInputNumberOfPlayers(){
        System.out.println("Please enter the amount of player (min: 2, max: 4): "); // Ask user about input
        boolean validInput = false;
        int intValue = 0;
        Scanner scan = new Scanner(System.in);  // Create a Scanner object

        // ask for new input until valid one appears
        while (!validInput) {
            String input = scan.nextLine();

            //check that input is of type int
            try {
                intValue = Integer.parseInt(input);

                // check that int lies between 2 and 4
                if (intValue < 2 || intValue > 4) {
                    System.out.println("Only 2 up to 4 players allowed!\n" +
                            "Try again with valid amount of players: ");
                } else {
                    validInput = true;

                }
            }catch(NumberFormatException e){
                    System.out.println("Input must be an integer! \nTry again:");
                }
            }

        System.out.println("\n----------------------------\n");
        System.out.println("Game with " + intValue + " players initiated, have fun!");  // Output user input
        System.out.println("\n----------------------------\n");

        return intValue;
    }

    public int userInputMaxPoints(){
        System.out.println("Please enter the winning points between 5000 and 10000: "); // Ask user about input
        boolean validInput = false;
        int intValue = 0;
        Scanner scan = new Scanner(System.in);  // Create a Scanner object

        // ask for new input until valid one appears
        while (!validInput) {
            String input = scan.nextLine();

            //check that input is of type int
            try {
                intValue = Integer.parseInt(input);

                // check that int lies between 2 and 4
                if (intValue < 5000 || intValue > 10000) {
                    System.out.println("Input must be between 5000 and 10000!\nPlease enter new number: ");
                } else {
                    validInput = true;

                }
            }catch(NumberFormatException e){
                System.out.println("Input must be an integer between 5000 and 10000! \nTry again:");
            }
        }

        System.out.println("\n----------------------------\n");
        System.out.println("First player to reach " + intValue + " points will be the winner!");  // Output user input
        System.out.println("\n----------------------------\n");
        return intValue;
    }

    public boolean userInputDisplayPoints() {
        String r = "R";
        String d = "D";
        boolean validInput = false;
        System.out.print("press R to roll dices\npress D to display scores\n");
        boolean displayScores = false;
        Scanner scan = new Scanner(System.in);
        while (!validInput) {
            String line = scan.nextLine();
            if (line.length() == 1) { // check that input is only one char
                if (line.equals(r) || line.equals(d)) { //check that this char is either R or D
                    validInput = true;
                    if (line.equals(d)) {
                        displayScores = true;
                    }
                }
                else {
                    System.out.println("Just enter one upper case letter (either D or R)!\n" +
                            "Try again: ");
                }
            }
            else {
                System.out.println("Input must be one character long (either D or R)!\nTry again: ");
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
            if (playerName.length() > 0){ //minimum one character long
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
    public void userOutputWinByDoubleTutto(String winner) {
        System.out.println("\n" +
                "████████╗██╗░░░██╗████████╗████████╗░█████╗░\n" +
                "╚══██╔══╝██║░░░██║╚══██╔══╝╚══██╔══╝██╔══██╗\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░╚██████╔╝░░░██║░░░░░░██║░░░╚█████╔╝\n" +
                "   Player "+ winner +" wins with a double tutto\n" +
                "████████╗██╗░░░██╗████████╗████████╗░█████╗░\n" +
                "╚══██╔══╝██║░░░██║╚══██╔══╝╚══██╔══╝██╔══██╗\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░██║░░░██║░░░██║░░░░░░██║░░░██║░░██║\n" +
                "░░░██║░░░╚██████╔╝░░░██║░░░░░░██║░░░╚█████╔╝\n" );
    }

    @Override
    public void userOutputWinByPoints(String winner) {
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
