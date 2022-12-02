package cards;

import strategy.*;

public class Bonus extends Card {
    private final int bonusPoints;

    /* check if bonusPoints = 200 or 300 or 400 or 500*/
    /*private boolean validBonusPoints(int bonusPoints) {
        if (bonusPoints != 200 || bonusPoints != 300 || bonusPoints != 400 || bonusPoints != 500 || bonusPoints == 600) {
            return false;
        } else {
            return true;
        }
    }*/

    /*not sure if check is needed for implementation... review when deck implementation is done*/

    public Bonus(String name, int bonusPoints) {
        this.cardName = name;
        this.bonusPoints = bonusPoints;
        /*if (validBonusPoints(bonusPoints)) {
            this.bonusPoints = bonusPoints;
        } else {
            throw Error("Entered Bonus Points are Invalid");
        }*/

        /*create instance of CardStrategy corresponding to this.bonusPoints*/
        if (this.bonusPoints == 200) {
            this.strategy = new BonusStrategy200();
        }
        else if (this.bonusPoints == 300) {
            this.strategy = new BonusStrategy300();
        }
        else if (this.bonusPoints == 400) {
            this.strategy = new BonusStrategy400();
        }
        else if (this.bonusPoints == 500) {
            this.strategy = new BonusStrategy500();
        }
        else if (this.bonusPoints == 600) {
            this.strategy = new BonusStrategy600();
        }
    }
    @Override
    public String display() {
        return this.cardName + " (" + bonusPoints + ")";
    }
}
