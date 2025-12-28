//Write a program to create a deck of cards, initialize the deck, shuffle the deck, and distribute the deck of n cards to x number of players
package strings;
import java.util.Scanner;
public class Cards {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        // Define suits and ranks
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();

        // Distribute cards
        String[][] playerCards = distributeCards(deck, n, players);

        // Print result
        if (playerCards != null) {
            printPlayers(playerCards);
        }

        sc.close();


	}
    // Method to initialize the deck of cards
    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        // Create cards in the form "Rank of Suit"
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    // Method to shuffle the deck of cards
    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        // Shuffle using swapping technique
        for (int i = 0; i < n; i++) {

            // Generate random card number between i and n
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap current card with random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // Method to distribute n cards to x players
    public static String[][] distributeCards(String[] deck, int n, int players) {

        // Check if cards can be distributed equally
        if (n % players != 0) {
            System.out.println("Cards cannot be distributed equally among players.");
            return null;
        }

        int cardsPerPlayer = n / players;
        String[][] playerCards = new String[players][cardsPerPlayer];

        int cardIndex = 0;

        // Distribute cards
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return playerCards;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }


}
