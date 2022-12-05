package cards;

import strategy.*;

public class Bonus extends Card {
    private final int bonusPoints;

    public Bonus(int bonusPoints) {
        this.cardName = "Bonus";
        this.bonusPoints = bonusPoints;

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
