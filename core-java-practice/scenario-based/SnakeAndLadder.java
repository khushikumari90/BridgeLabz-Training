package extrascenariobased;

import java.util.Random;

public class SnakeAndLadder {

    // Constants
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WINNING_POSITION = 100;

    // Random object
    static Random rand = new Random();

    // Method to roll dice (UC1)
    static int rollDice() {
        return rand.nextInt(6) + 1; // 1 to 6
    }

    // Method to get option: No Play, Ladder, Snake (UC2)
    static int getOption() {
        return rand.nextInt(3); // 0,1,2
    }

    public static void main(String[] args) {

        int player1Position = 0;
        int player2Position = 0;

        int diceCount = 0;
        boolean isPlayer1Turn = true;

        System.out.println("Welcome to Snake and Ladder Game");

        // UC3–UC7: Game continues till one player wins
        while (player1Position < WINNING_POSITION &&
               player2Position < WINNING_POSITION) {

            int dice = rollDice();
            int option = getOption();
            diceCount++;

            if (isPlayer1Turn) {
                System.out.println("\nPlayer 1 rolls dice: " + dice);

                player1Position = movePlayer(player1Position, dice, option);
                System.out.println("Player 1 position: " + player1Position);

                // If ladder, player gets another chance
                if (option != LADDER) {
                    isPlayer1Turn = false;
                }

            } else {
                System.out.println("\nPlayer 2 rolls dice: " + dice);

                player2Position = movePlayer(player2Position, dice, option);
                System.out.println("Player 2 position: " + player2Position);

                // If ladder, player gets another chance
                if (option != LADDER) {
                    isPlayer1Turn = true;
                }
            }
        }

        // Winner announcement
        if (player1Position == WINNING_POSITION) {
            System.out.println("\n🎉 Player 1 WON the game!");
        } else {
            System.out.println("\n🎉 Player 2 WON the game!");
        }

        System.out.println("Total Dice Rolls: " + diceCount);
        System.out.println("Thank You");
    }

    // Method to move player (UC2–UC5)
    static int movePlayer(int position, int dice, int option) {

        switch (option) {
            case NO_PLAY:
                System.out.println("Option: No Play");
                break;

            case LADDER:
                System.out.println("Option: Ladder");
                position += dice;
                break;

            case SNAKE:
                System.out.println("Option: Snake");
                position -= dice;
                break;
        }

        // UC4: Position should not go below 0
        if (position < 0) {
            position = 0;
        }

        // UC5: Ensure exact winning position
        if (position > WINNING_POSITION) {
            position -= dice;
        }

        return position;
    }
}

