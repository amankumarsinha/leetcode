package com.leetcode.leetcode_daily;

import java.util.*;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        
	        int k =1;
	       for(int i=1;i<nums.length;i++){
	         if(nums[i]!=nums[i-1]){
	             nums[k]=nums[i];
	             //changin theoriginal array with the required alue in strtig
	             k++;
	         }
	       }
	        return k;
	    }
	}

}
