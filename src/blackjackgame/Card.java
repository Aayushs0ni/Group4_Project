/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

/**
 *
 * @author Aayush Soni, Aryan Kachhiyapatel, Dev Patel, Tanish Vyas
 */

public class Card {
    // The suit of the card (e.g., Hearts, Spades, Diamonds, Clubs)
    private final String suit;
    // The rank of the card (e.g., 2, 3, 4, ..., Jack, Queen, King, Ace)
    private final String rank;

    /**
     * Constructs a card with a specified suit and rank.
     * 
     * @param suit The suit of the card.
     * @param rank The rank of the card.
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the suit of the card.
     * 
     * @return The suit of the card.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Gets the rank of the card.
     * 
     * @return The rank of the card.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns a string representation of the card in the format "Rank of Suit".
     * 
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
