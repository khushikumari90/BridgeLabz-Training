package map_interface;
import java.util.*;

public class VotingSystem {

    // Store votes (Candidate -> Votes)
    static HashMap<String, Integer> voteMap = new HashMap<>();

    // Maintain insertion order of votes
    static LinkedHashMap<String, Integer> insertionOrderMap = new LinkedHashMap<>();

    // Display results in sorted order (by candidate name)
    static TreeMap<String, Integer> sortedResultMap = new TreeMap<>();

    // Cast a vote
    static void castVote(String candidate) {

        // Update HashMap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap (insertion order)
        insertionOrderMap.put(candidate, voteMap.get(candidate));

        // Update TreeMap (sorted order)
        sortedResultMap.put(candidate, voteMap.get(candidate));
    }

    // Display votes in insertion order
    static void displayInsertionOrder() {
        System.out.println("Votes in insertion order:");
        for (Map.Entry<String, Integer> entry : insertionOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display sorted results
    static void displaySortedResults() {
        System.out.println("Votes in sorted order:");
        for (Map.Entry<String, Integer> entry : sortedResultMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display final results (from HashMap)
    static void displayFinalResults() {
        System.out.println("Final vote count:");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {

        castVote("Alice");
        castVote("Bob");
        castVote("Alice");
        castVote("Carol");
        castVote("Bob");
        castVote("Alice");

        System.out.println();

        displayInsertionOrder();
        System.out.println();

        displaySortedResults();
        System.out.println();

        displayFinalResults();
    }
}
