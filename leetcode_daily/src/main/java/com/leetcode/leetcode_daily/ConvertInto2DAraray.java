package com.leetcode.leetcode_daily;

import java.util.*;

public class ConvertInto2DAraray {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
//
//			The 2D array should contain only the elements of the array nums.
//			Each row in the 2D array contains distinct integers.
//			The number of rows in the 2D array should be minimal.
//			Return the resulting array. If there are multiple answers, return any of them.
//
//			Note that the 2D array can have a different number of elements on each row.
//
//			 
//
//			Example 1:
//
//			Input: nums = [1,3,4,1,2,3,1]
//			Output: [[1,3,4,2],[1,3],[1]]
//			Explanation: We can create a 2D array that contains the following rows:
//			- 1,3,4,2
//			- 1,3
//			- 1

	}

}


// Mysolution 
class Solution2 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Map<Integer,Integer> check =new HashMap<>();
        for(int num : nums){
            int index = check.getOrDefault(num,0);
            if(index >= res.size())
            {
                res.add(new ArrayList<Integer>());
            }
            res.get(index).add(num);
            check.put(num,++index);
        }
return res;
    }
}

//Optimal solution
class Solution1 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}