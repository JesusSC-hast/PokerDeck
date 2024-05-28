package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            String color = suit.equals("Corazones") || suit.equals("Diamantes") ? "Rojo" : "Negro";
            for (String value : values) {
                cards.add(new Card(suit, color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("No hay más cartas en el deck.");
            return;
        }
        Card card = cards.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("No hay más cartas en el deck.");
            return;
        }
        Card card = cards.remove((int) (Math.random() * cards.size()));
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas para una mano.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }
}
