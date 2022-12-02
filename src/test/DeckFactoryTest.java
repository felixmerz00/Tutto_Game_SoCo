import cards.Bonus;
import cards.Cloverleaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckFactoryTest {

    @Test
    void testGetCards() {
        Cloverleaf cloverleaf1 = (Cloverleaf)DeckFactory.getCards("Cloverleaf");
        Cloverleaf cloverleaf2 = (Cloverleaf)DeckFactory.getCards("Cloverleaf");
        Cloverleaf cloverleaf3 = new Cloverleaf("Cloverleaf");
        assertSame(cloverleaf1, cloverleaf2);
        assertNotSame(cloverleaf1, cloverleaf3);
        assertNotSame(cloverleaf2, cloverleaf3);
    }

    @Test
    void getBonusCards() {
        Bonus bonus200_1 = DeckFactory.getBonusCards(200);
        Bonus bonus200_2 = DeckFactory.getBonusCards(200);
        Bonus bonus300_1 = DeckFactory.getBonusCards(300);
        Bonus bonus300_2 = DeckFactory.getBonusCards(300);
        Bonus bonus400_1 = DeckFactory.getBonusCards(400);
        Bonus bonus400_2 = DeckFactory.getBonusCards(400);
        Bonus bonus500_1 = DeckFactory.getBonusCards(500);
        Bonus bonus500_2 = DeckFactory.getBonusCards(500);
        Bonus bonus600_1 = DeckFactory.getBonusCards(600);
        Bonus bonus600_2 = DeckFactory.getBonusCards(600);
        Bonus bonus600_3 = DeckFactory.getBonusCards(600);

        Bonus bonus600 = new Bonus("Bonus", 600);
        Bonus bonus500 = new Bonus("Bonus", 500);
        Bonus bonus400 = new Bonus("Bonus", 400);
        Bonus bonus300 = new Bonus("Bonus", 300);
        Bonus bonus200 = new Bonus("Bonus", 200);

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