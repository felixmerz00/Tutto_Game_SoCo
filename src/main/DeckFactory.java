import cards.*;

import java.util.HashMap;

public class DeckFactory {
    private static final HashMap deckMap = new HashMap();

    public static Card getCards(String name) {
        /*when passed name is Cloverleaf, instantiate Cloverleaf Card*/
        if (name.equals("Cloverleaf")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Cloverleaf(name);
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Fireworks, instantiate Fireworks Card*/
        else if (name.equals("Fireworks")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Fireworks(name);
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is PlusMinus, instantiate PlusMinus Card*/
        else if (name.equals("PlusMinus")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new PlusMinus(name);
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Straight, instantiate Straight Card*/
        else if (name.equals("Straight")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new Straight(name);
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is x2, instantiate TimesTwo Card*/
        else if (name.equals("x2")) {
            Card card = (Card) deckMap.get(name);

            if (card == null) {
                card = new TimesTwo(name);
                deckMap.put(name, card);
            }
            return card;
        }
        /*when passed name is Stop, instantiate Stop Card*/

        Card card = (Card) deckMap.get(name);

        if (card == null) {
            card = new Stop(name);
            deckMap.put(name, card);
        }
        return card;

    }

    public static Bonus getBonusCards(Integer bonusPoints) {
        Card card = (Card) deckMap.get(bonusPoints);

        if (card == null) {
            card = new Bonus("Bonus", bonusPoints);
            deckMap.put(bonusPoints, card);
        }
        return (Bonus) card;
    }
}
