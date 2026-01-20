//Problem no. 217
package dsa_leetcode;
import java.util.*;
public class ContainsDuplicate {
	public static void main(String args[]) {
		int nums[]= {1,2,2,3,4,4,5};
		System.out.println(containsDuplicate(nums));
	}
  
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
