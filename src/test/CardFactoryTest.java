import cards.Bonus;
import cards.Cloverleaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    @Test
    void testGetCards() {
        Cloverleaf cloverleaf1 = (Cloverleaf) CardFactory.getCards("Cloverleaf");
        Cloverleaf cloverleaf2 = (Cloverleaf) CardFactory.getCards("Cloverleaf");
        Cloverleaf cloverleaf3 = new Cloverleaf();
        assertSame(cloverleaf1, cloverleaf2);
        assertNotSame(cloverleaf1, cloverleaf3);
        assertNotSame(cloverleaf2, cloverleaf3);
    }

    @Test
    void testGetBonusCards() {
        Bonus bonus200_1 = CardFactory.getBonusCards(200);
        Bonus bonus200_2 = CardFactory.getBonusCards(200);
        Bonus bonus300_1 = CardFactory.getBonusCards(300);
        Bonus bonus300_2 = CardFactory.getBonusCards(300);
        Bonus bonus400_1 = CardFactory.getBonusCards(400);
        Bonus bonus400_2 = CardFactory.getBonusCards(400);
        Bonus bonus500_1 = CardFactory.getBonusCards(500);
        Bonus bonus500_2 = CardFactory.getBonusCards(500);
        Bonus bonus600_1 = CardFactory.getBonusCards(600);
        Bonus bonus600_2 = CardFactory.getBonusCards(600);
        Bonus bonus600_3 = CardFactory.getBonusCards(600);

        Bonus bonus600 = new Bonus(600);
        Bonus bonus500 = new Bonus( 500);
        Bonus bonus400 = new Bonus(400);
        Bonus bonus300 = new Bonus(300);
        Bonus bonus200 = new Bonus(200);

        assertSame(bonus200_1, bonus200_2);
        assertSame(bonus300_1, bonus300_2);
        assertSame(bonus400_1, bonus400_2);
        assertSame(bonus500_1, bonus500_2);
        assertSame(bonus600_1, bonus600_2);
        assertSame(bonus600_1, bonus600_3);

        assertNotSame(bonus200_1, bonus300_1);
        assertNotSame(bonus300_2, bonus400_2);
        assertNotSame(bonus400_1, bonus500_1);
        assertNotSame(bonus500_2, bonus600_2);
        assertNotSame(bonus600, bonus200_2);
        assertNotSame(bonus500, bonus500_1);
        assertNotSame(bonus400, bonus400_1);
        assertNotSame(bonus300, bonus300_1);
        assertNotSame(bonus200, bonus200_1);
    }
}