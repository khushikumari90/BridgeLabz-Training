package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.util.*;
public class ReverseStringUsingStringBuilder {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String : ");
		String input=sc.nextLine();
		System.out.println("String reversed is "+reverseInput(input));
		sc.close();
	}
    public static String reverseInput(String input) {
    	StringBuilder sb=new StringBuilder();
    	sb.append(input);
    	sb.reverse();
    	return sb.toString();
    }
}
