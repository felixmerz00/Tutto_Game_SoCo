package strategy;
public class Tuple {
    /* This class exists, because tuples do not exist in Java. So the concrete strategy can
    * return "new Tuple(0, false)" for example. In the TurnLogic I can then use this information.
    *
    * The TurnLogic calls a concrete Strategy which handles rolling dice. From this class
    * TurnLogic needs the following Information:
    * How many points were achieved? Because TurnLogic must update the score in the Player object.
    * Did the player achieve Tutto? Because if he did, he can draw another card and roll the dice again. */
    public int points;
    public boolean achievedTutto;

    public Tuple(int points, boolean achievedTutto){
        this.points = points;
        this.achievedTutto = achievedTutto;
    }
}
