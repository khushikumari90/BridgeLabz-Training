//Problem no. 387
package dsa_leetcode;
public class FirstUniqueCharacterInString {
	public static void main(String args[]) {
		String str="kkhusshii";
		System.out.println(firstUniqChar(str));
	}

	public static int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            boolean flag=true;
            for(int j=0;j<s.length();j++){
                if(i!=j && s.charAt(i)==s.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag==true)return i;
        }
        return -1;
    }
}
