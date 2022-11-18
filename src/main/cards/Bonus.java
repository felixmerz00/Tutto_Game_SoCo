package cards;

public class Bonus extends Card{

    private int bonusPoints;

    public Bonus(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    @Override
    public void name() {

    }

    public int getBonusPoints() {
        return bonusPoints;
    }
}
