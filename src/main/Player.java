import java.util.Scanner;

public class Player {
    private int points = 0;
    private String name;

    public Player(int playerCount) {
        this.points = 0;
        this.name = inputName(playerCount);
    }

    // Let user input his name
    private String inputName(int playerCount) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username for player " + playerCount);

        String playerName = myObj.nextLine();  // Read user input
        System.out.println("Username of player "+ playerCount +" is: " + playerName);  // Output user input
        return playerName;
    }

    public void updatePoints (int turnPoints) {
        this.points += turnPoints; //add or subtract turnPoints to points
    }

    public int getPoints() {
        return this.points;
    }
}