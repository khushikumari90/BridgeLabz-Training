//Create a program to find the shortest, tallest, and mean height of players present in a football team.
package methods;

public class HeightOfPlayer {

	public static void main(String[] args) {

        // Create heights array for 11 players
        int[] heights = generateHeights(11);

        // Display player heights
        System.out.println("Heights of Football Team Players (in cm):");
        for (int h : heights) {
            System.out.print(h + " ");
        }

        // Display results
        System.out.println("\n\nMean Height = " + findMeanHeight(heights));
        System.out.println("Shortest Height = " + findShortestHeight(heights));
        System.out.println("Tallest Height = " + findTallestHeight(heights));

	}
	 // Method to generate random heights between 150 cm and 250 cm
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];

        for (int i = 0; i < heights.length; i++) {
            // 3-digit random height between 150 and 250
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    // Method to find sum of all heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double findMeanHeight(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int findShortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

}
