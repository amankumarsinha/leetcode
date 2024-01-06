package com.leetcode.leetcode_daily;

import java.util.*;

class jobScheduling {
	
	/// least optimise still DP approach 
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int T[] = new int[profit.length];
        Job jobs[] = new Job[profit.length];
        for(int i=0;i<profit.length;i++){
            jobs[i]=new Job(startTime[i],endTime[i],profit[i]);
           
        }
         FinishTimeComparator comparator = new FinishTimeComparator();
        Arrays.sort(jobs, comparator);
        
        T[0] = jobs[0].profit;
        for(int i=1; i < jobs.length; i++){
            T[i] = Math.max(jobs[i].profit, T[i-1]);
            for(int j=i-1; j >=0; j--){
                if(jobs[j].end <= jobs[i].start){
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                    break;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int val : T) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;

        
    }
    class FinishTimeComparator implements Comparator<Job>{

    @Override
    public int compare(Job arg0, Job arg1) {
        if(arg0.end <= arg1.end){
            return -1;
        }else{
            return 1;
        }
    }
    
}

    class Job{
        public int start;
        public int end;
        public int profit;

        public Job(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;           
        }

    }
}
