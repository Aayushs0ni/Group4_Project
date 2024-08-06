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
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    // Singleton instance of the Deck
    private static Deck instance;

    // Private constructor to prevent instantiation from outside the class
    private Deck() {
        cards = new ArrayList<>();
        build();
        shuffle();
    }

    /**
     * Gets the single instance of the Deck.
     * 
     * @return The singleton instance of Deck.
     */
    public static Deck getInstance() {
        // Lazy initialization: Instance is created only when needed
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    /**
     * Builds a standard deck of 52 cards.
     */
    public void build() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        // Create all combinations of suits and ranks
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deals a card from the deck.
     * Rebuilds and reshuffles if the deck is empty.
     * 
     * @return The dealt card.
     */
    public Card deal() {
        // Check if the deck is empty
        if (cards.isEmpty()) {
            build();
            shuffle();
        }
        // Remove and return the top card
        return cards.remove(cards.size() - 1);
    }
}
