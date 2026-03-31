package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.util.*;
public class RemovesDuplicateUsingStringBuilder {
   public static void main(String args[]) {
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter any string : ");
	   String str=sc.nextLine();
	   System.out.println("String after removing duplicates is "+removeDuplicates(str));
	   sc.close();
   }
   public static String removeDuplicates(String str) {
	   StringBuilder sb=new StringBuilder();
	   HashSet<Character> map=new HashSet<>();
	   for(int i=0;i<str.length();i++){
		    char ch=str.charAt(i);
		    if(!map.contains(ch)) {
		    	map.add(ch);
		    	sb.append(ch);
		    }
	   }
	   return  sb.toString();
   }
}
