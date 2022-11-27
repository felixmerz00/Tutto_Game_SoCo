package cards;

public class Straight extends Card{

    private String cardName = "Straight";

    @Override
    public void display() {
        System.out.println(cardName);
        return;
    }

}
