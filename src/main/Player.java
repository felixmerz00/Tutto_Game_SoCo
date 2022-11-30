import java.util.Scanner;

public class Player {
    private int points;
    private final String name;


    public Player(int playerCount) {
        points = 0;
        name = inputName(playerCount);
    }

    // Let user input his name
    private String inputName(int playerCount) {
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

    public void updatePoints (int turnPoints) {
        points += turnPoints; //add or subtract turnPoints to points
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}


