//Write a Java program to compare two strings lexicographically (dictionary order) without using built-in compare methods.
package extras;
public class CompareStrings {

	public static void main(String[] args) {
		    String s1 = "apple";
	        String s2 = "banana";

	        int len = Math.min(s1.length(), s2.length());
	        boolean decided = false;

	        for (int i = 0; i < len; i++) {
	            if (s1.charAt(i) < s2.charAt(i)) {
	                System.out.println("\"apple\" comes before \"banana\"");
	                decided = true;
	                break;
	            } else if (s1.charAt(i) > s2.charAt(i)) {
	                System.out.println("\"banana\" comes before \"apple\"");
	                decided = true;
	                break;
	            }
	        }

	        if (!decided && s1.length() != s2.length()) {
	            System.out.println("Shorter string comes first");
	        }

	}

}
