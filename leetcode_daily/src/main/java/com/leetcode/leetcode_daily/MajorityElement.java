package com.leetcode.leetcode_daily;

import java.util.*;

public class MajorityElement {

	
	/*
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
	 * 
	 */
	
	// 1approach nlogn
	class Solution {
	    public int majorityElement1(int[] nums) {
	        Arrays.sort(nums);
	        int n = nums.length;
	        return nums[n/2];
	    }
	    
	    // 2 approach o(n)
	    public int majorityElement2(int[] nums) {
	        int n = nums.length;
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        for (int i = 0; i < n; i++) {
	            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
	        }
	        
	        n = n / 2;
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() > n) {
	                return entry.getKey();
	            }
	        }
	        
	        return 0;
	    }
	    
	    //3 is an alogrithm moore algo o(n) space complexity
	    public int majorityElement(int[] nums) {
	        int count = 0;
	        int candidate = 0;
	        
	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	            }
	            
	            if (num == candidate) {
	                count++;
	            } else {
	                count--;
	            }
	        }
	        
	        return candidate;
	    }

        
	}
}
