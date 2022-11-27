package cards;

import strategy.*;

public class Bonus extends Card {
    private String cardName = "Bonus";
    private int bonusPoints;

    /* check if bonusPoints = 200 or 300 or 400 or 500*/
    private boolean validBonusPoints(int bonusPoints) {
        if (bonusPoints != 200 || bonusPoints != 300 || bonusPoints != 400 || bonusPoints != 500 || bonusPoints == 600) {
            return false;
        } else {
            return true;
        }
    }

    /*not sure if check is needed for implementation... review when deck implementation is done*/
    public Bonus(int bonusPoints) {
        if (validBonusPoints(bonusPoints)) {
            this.bonusPoints = bonusPoints;
        } else {
            throw Error("Entered Bonus Points are Invalid");
        }

        /*create instance of CardStrategy corresponding to this.bonusPoints*/
        if (this.bonusPoints == 200) {
            this.Strategy = new BonusStrategy200();
        }
        if (this.bonusPoints == 300) {
            this.Strategy = new BonusStrategy300();
        }
        if (this.bonusPoints == 400) {
            this.Strategy = new BonusStrategy400();
        }
        if (this.bonusPoints == 500) {
            this.Strategy = new BonusStrategy500();
        }
        if (this.bonusPoints == 600) {
            this.Strategy = new BonusStrategy600();
        }
    }
    @Override
    public void display() {
        System.out.println(cardName);
        System.out.println(bonusPoints);
        return;
    }
}
