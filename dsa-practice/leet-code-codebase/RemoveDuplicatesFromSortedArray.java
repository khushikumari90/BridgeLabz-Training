//Problem no 26
package dsa_leetcode;
import java.util.*;
public class RemoveDuplicatesFromSortedArray {
	public static void  main(String args[]) {
		int nums[]= {1,2,2,4,5,4};
		System.out.println(removeDuplicates(nums));
	}
    
	public static int removeDuplicates(int[] nums) {
        HashSet<Integer>  set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            
        }
        return set.size();
        
    }
}
