package com.leetcode.leetcode_daily;

import java.util.*;

public class MinOpsArrayEmpty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * You are given a 0-indexed array nums consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

Choose two elements with equal values and delete them from the array.
Choose three elements with equal values and delete them from the array.
Return the minimum number of operations required to make the array empty, or -1 if it is not possible.

 
		 */

	}
	
	class Solution {
	    public int minOperations(int[] nums) {
	        int k=0;
	        Map<Integer,Integer> freq= new HashMap<>();
	        for(int num : nums){
	            freq.put(num,freq.getOrDefault(num,0)+1);
	        }
	        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
	            if(e.getValue()==1)
	            return -1;

	            k+=e.getValue()/3;
	            if(e.getValue()%3!=0)
	            k++;

	        }

	        return k;
	    }
	}

}
