import java.util.Scanner;

public class Player {
    private int points;
    private final String name;


    public Player(int playerCount) {
        UserInterface inputValidation = new UserInterface();
        points = 0;
        name = inputValidation.inputName(playerCount);
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void updatePoints (int turnPoints) {
        points += turnPoints; //add or subtract turnPoints to points
    }

}


