import cards.*;

import java.util.HashMap;

public class CardFactory {
    private static final HashMap deckMap = new HashMap();

    public static Card getCards(String name) {
        /*when passed name is Cloverleaf, instantiate Cloverleaf Card*/
        if (name.equals("Cloverleaf")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Cloverleaf();
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Fireworks, instantiate Fireworks Card*/
        else if (name.equals("Fireworks")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Fireworks();
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is PlusMinus, instantiate PlusMinus Card*/
        else if (name.equals("PlusMinus")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new PlusMinus();
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Straight, instantiate Straight Card*/
        else if (name.equals("Straight")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Straight();
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is x2, instantiate TimesTwo Card*/
        else if (name.equals("x2")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new TimesTwo();
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Stop, instantiate Stop Card*/
        else if (name.equals("Stop")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Stop();
                deckMap.put(name, card);
            }
            return card;
        }
        return null;
    }

    public static Bonus getBonusCards(Integer bonusPoints) {
        Card card = (Card) deckMap.get(bonusPoints);

        if (card == null) {
            card = new Bonus(bonusPoints);
            deckMap.put(bonusPoints, card);
        }
        return (Bonus) card;
    }
}
