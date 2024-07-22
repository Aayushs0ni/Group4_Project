/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjackgame;
/**
 *
 * @author Aayush Soni,Aryan Kachhiyapatel,Dev Patel,Tanish Vyas|
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {
    private Deck deck;
    private List<Hand> playerHands;
    private Hand dealerHand;

    public BlackJackGame() {
        deck = new Deck();
        playerHands = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            playerHands.add(new Hand());
        }
        dealerHand = new Hand();
    }

    public void dealInitialCards() {
        for (Hand playerHand : playerHands) {
            playerHand.addCard(deck.deal());
            playerHand.addCard(deck.deal());
        }
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }

    public void playerHit(Hand playerHand) {
        playerHand.addCard(deck.deal());
    }

    public void dealerHit() {
        dealerHand.addCard(deck.deal());
    }

    public boolean playerBusted(Hand playerHand) {
        return playerHand.getValue() > 21;
    }

    public boolean dealerBusted() {
        return dealerHand.getValue() > 21;
    }

    public void play() {
        for (int round = 1; round <= 4; round++) {
            System.out.println("Round " + round);
            deck.shuffle();
            dealInitialCards();
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < playerHands.size(); i++) {
                Hand playerHand = playerHands.get(i);
                boolean playerTurn = true;

                while (playerTurn && !playerBusted(playerHand)) {
                    System.out.println("Player " + (i + 1) + "'s hand:");
                    System.out.println(playerHand);
                    System.out.println("Player " + (i + 1) + "'s hand value: " + playerHand.getValue());

                    System.out.println("Dealer's visible card:");
                    System.out.println(dealerHand.getCards().get(0));
                    System.out.println("Do you want to hit or stand? (hit/stand)");
                    String decision = scanner.nextLine();

                    if ("hit".equalsIgnoreCase(decision)) {
                        playerHit(playerHand);
                    } else if ("stand".equalsIgnoreCase(decision)) {
                        playerTurn = false;
                    } else {
                        System.out.println("Invalid input. Please type 'hit' or 'stand'.");
                    }
                }

                if (playerBusted(playerHand)) {
                    System.out.println("Player " + (i + 1) + " busts!");
                }

                System.out.println("Player " + (i + 1) + "'s final hand:");
                System.out.println(playerHand);
                System.out.println("Player " + (i + 1) + "'s final hand value: " + playerHand.getValue());
            }

            while (dealerHand.getValue() < 17) {
                dealerHit();
            }

            System.out.println("Dealer's final hand:");
            System.out.println(dealerHand);
            System.out.println("Dealer's final hand value: " + dealerHand.getValue());

            ///

            for (Hand playerHand : playerHands) {
                playerHand.clear();
            }
            dealerHand.clear();
        }
    }

    public static void main(String[] args) {
        BlackJackGame game = new BlackJackGame();
        game.play();
    }
}