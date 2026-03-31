package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
public class ConcatenateStringsUsingStringBuffer {
    public static void main(String args[]) {
    	String words[]= {"My"," ","name"," ","is"," ","Khushi"};
    	System.out.print("Strings after concatenation : "+ConcatenateStrings(words));
    	
    }
    public static String ConcatenateStrings(String words[]) {
    	StringBuffer sb=new StringBuffer();
    	for(String str:words) {
    		sb.append(str);
    	}
    	return sb.toString();
    }
}
