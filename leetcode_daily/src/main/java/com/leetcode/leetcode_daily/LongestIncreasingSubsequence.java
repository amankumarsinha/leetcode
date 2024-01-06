package com.leetcode.leetcode_daily;

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//dynamic sol O(n2)
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	        int n= nums.length;
	       int  dp[] = new int[n] ;
	       
	       Arrays.fill(dp,1);
	       if(nums==null || nums.length==0)
	       return 0;
	       for(int  i=1;i<nums.length;i++){
	           for(int j=0;j<i;j++){
	               if(nums[i]>nums[j]){
	                   dp[i] = Math.max(dp[i],dp[j]+1);
	               }
	           }
	       }
	       int max = Arrays.stream(dp).max().orElse(0);
	        return max;
	    }
	}
	
	
	//best sol usig binary serach 
	/*
	 * We can solve this problem efficiently using dynamic programming. The key idea is to maintain an array tails where tails[i] represents the smallest ending element of all increasing subsequences of length i+1. This array is crucial in determining where the current element x fits in the existing subsequences.

Initialize an array tails of the same length as nums to store the ending elements of increasing subsequences.

Initialize a variable size to keep track of the current length of the longest increasing subsequence.

Iterate through each element x in nums:

Use binary search to find the correct position for x in the tails array.

Update the corresponding position in tails with x.

If x is greater than all ending elements in tails, append it to the end and increment size.

The final value of size represents the length of the longest increasing subsequence.

Complexity
	 */
	class Solution2 {
	    public int lengthOfLIS(int[] nums) {
	        int[] tails = new int[nums.length];
	        int size = 0;
	        for (int x : nums) {
	            int i = 0, j = size;
	            while (i != j) {
	                int m = (i + j) / 2;
	                if (tails[m] < x)
	                    i = m + 1;
	                else
	                    j = m;
	            }
	            tails[i] = x;
	            if (i == size) ++size;
	        }
	        return size;
	    }
	}

}
