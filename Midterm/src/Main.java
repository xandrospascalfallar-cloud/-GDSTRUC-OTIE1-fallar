import java.util.Random;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 3 stacks
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(10);
        CardStack discardPile = new CardStack(10);

        // Create 30 cards
        Card[] cards = new Card[30];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card("Card " + (i + 1));
        }

        // Shuffle cards
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

        // Put all cards into the player deck
        for (Card card : cards) {
            playerDeck.push(card);
        }

        System.out.println("================================");
        System.out.println("       CARD STACK GAME");
        System.out.println("================================");

        // Game continues until player deck is empty
        while (!playerDeck.isEmpty()) {

            System.out.println("\n--------------------------------");
            System.out.println("           NEW TURN");
            System.out.println("--------------------------------");

            // Random command
            int command = random.nextInt(3);

            // Random amount from 1 to 5
            int amount = random.nextInt(5) + 1;

            if (command == 0) {

                // DRAW x CARDS
                System.out.println("Command: Draw " + amount + " cards");

                for (int i = 0; i < amount && !playerDeck.isEmpty(); i++) {
                    Card card = playerDeck.pop();
                    playerHand.push(card);

                    System.out.println("Drew: " + card);
                }

            } else if (command == 1) {

                // DISCARD x CARDS
                System.out.println("Command: Discard " + amount + " cards");

                if (playerHand.isEmpty()) {
                    System.out.println("Player hand is empty. Nothing to discard.");
                } else {

                    for (int i = 0; i < amount && !playerHand.isEmpty(); i++) {
                        Card card = playerHand.pop();
                        discardPile.push(card);

                        System.out.println("Discarded: " + card);
                    }
                }

            } else {

                // GET x CARDS FROM DISCARDED PILE
                System.out.println("Command: Get " + amount
                        + " cards from discarded pile");

                if (discardPile.isEmpty()) {
                    System.out.println("Discard pile is empty. Nothing to get.");
                } else {

                    for (int i = 0; i < amount && !discardPile.isEmpty(); i++) {
                        Card card = discardPile.pop();
                        playerHand.push(card);

                        System.out.println("Got: " + card);
                    }
                }
            }

            // Display info
            System.out.println("\n================================");
            System.out.println("         CURRENT STATUS");
            System.out.println("================================");

            System.out.println("\nPlayer Hand:");

            if (playerHand.isEmpty()) {
                System.out.println("(Empty)");
            } else {
                playerHand.printStack();
            }

            System.out.println("\nRemaining Cards in Deck: "
                    + playerDeck.size());

            System.out.println("Cards in Discard Pile: "
                    + discardPile.size());

            // Checks if game is over
            if (playerDeck.isEmpty()) {
                break;
            }

            // Wait for Enter
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }

        System.out.println("\n================================");
        System.out.println("         GAME OVER");
        System.out.println("================================");

        System.out.println("The player deck is empty.");

        System.out.println("\nFinal Player Hand:");
        if (playerHand.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            playerHand.printStack();
        }

        System.out.println("\nCards in Discard Pile: "
                + discardPile.size());

        scanner.close();
    }
}