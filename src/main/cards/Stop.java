package cards;

public class Stop extends Card{


    private String cardName = "Stop";

    @Override
    public void display() {
        System.out.println(cardName);
        return;
    }
}
