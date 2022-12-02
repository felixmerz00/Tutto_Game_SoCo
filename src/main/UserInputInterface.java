import java.util.ArrayList;

public interface UserInputInterface {

    int userInputNumberOfPlayers();

    int userInputMaxPoints();

    boolean userInputChooseTurnPoints();


    void printScoreBoard(ArrayList<Player> playerList);

    void userOutputWinByPoints(String winner);

    void userOutputWinByDoubleTutto(String winner);
}
