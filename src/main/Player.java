public class Player {
    private int points = 0;
    private String name;

    public Player() {
        this.points = 0;
        this.name = inputName();
    }

    // Let user input his name
    private String inputName() {
        //ask user about name of playerX and use input as name
    }

    public void updatePoints (int turnPoints) {
        //add or subtract turnPoints to points
    }

    public int getPoints() {
        return points;
    }
}
