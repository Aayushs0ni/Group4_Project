/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;
/**
 *
 * @author Aayush Soni, Aryan Kachhiyapatel, Dev Patel, Tanish Vyas
 */

import java.util.ArrayList;
import java.util.List;

public class Hand {
    // List to hold the cards in the hand
    private List<Card> cards;

    /**
     * Constructs an empty hand.
     */
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Adds a card to the hand.
     * 
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Calculates the total value of the hand using the Strategy pattern.
     * 
     * @return The total value of the hand.
     */
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        // Iterate over each card to calculate the total value
        for (Card card : cards) {
            String rank = card.getRank();
            // Add values based on the rank of the card
            if ("2".equals(rank)) {
                value += 2;
            } else if ("3".equals(rank)) {
                value += 3;
            } else if ("4".equals(rank)) {
                value += 4;
            } else if ("5".equals(rank)) {
                value += 5;
            } else if ("6".equals(rank)) {
                value += 6;
            } else if ("7".equals(rank)) {
                value += 7;
            } else if ("8".equals(rank)) {
                value += 8;
            } else if ("9".equals(rank)) {
                value += 9;
            } else if ("10".equals(rank) || "Jack".equals(rank) || "Queen".equals(rank) || "King".equals(rank)) {
                value += 10;
            } else if ("Ace".equals(rank)) {
                value += 11;
                aceCount++;
            }
        }

        // Adjust the value if there are Aces and the total value exceeds 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    /**
     * Clears the hand by removing all cards.
     */
    public void clear() {
        cards.clear();
    }

    /**
     * Gets the list of cards in the hand.
     * 
     * @return The list of cards.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Returns a string representation of the hand.
     * 
     * @return A string representation of the hand.
     */
    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (Card card : cards) {
            handString.append(card.toString()).append("\n");
        }
        return handString.toString();
    }
}
