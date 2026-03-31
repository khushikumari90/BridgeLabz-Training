//Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a player or a computer will win. Show the stats of player and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.
package strings;
import java.util.Scanner;
public class RockPaperScissiors {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int games = sc.nextInt();
        sc.nextLine(); // clear buffer

        String[][] gameResults = new String[games][3];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {

            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();

            // Capitalize first letter for consistency
            userChoice = userChoice.substring(0, 1).toUpperCase() +
                         userChoice.substring(1).toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(gameResults, stats);

        sc.close();

	}
	
	// Method to get computer choice using Math.random()
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    // Method to find winner of a single game
    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    // Method to calculate win count and percentage
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent) + "%";

        return stats;
    }

    // Method to display game results and final statistics
    public static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\t\tComputer\tWinner");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    gameResults[i][0] + "\t\t" +
                    gameResults[i][1] + "\t\t" +
                    gameResults[i][2]
            );
        }

        System.out.println("\nFinal Statistics:");
        System.out.println("Player\tWins\tWinning Percentage");
        System.out.println("-----------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                    stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2]
            );
        }
    }


}
