package com.algorithm;

public class SolutionQ300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int []dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]&&dp[j]>max)
                    max = dp[j];
            }
            dp[i]=max+1;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(max<dp[i])
                max = dp[i];
        }
        return max;
    }
}
