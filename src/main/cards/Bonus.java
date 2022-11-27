package cards;

public class Bonus extends Card{
    private String cardName = "Bonus";

    @Override
    public void display() {
        System.out.println(cardName);
        System.out.println(bonusPoints);
        return;
    }



    private int bonusPoints;

    public Bonus(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }
}
