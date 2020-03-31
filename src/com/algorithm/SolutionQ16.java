package com.algorithm;

import java.util.Arrays;

public class SolutionQ16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int result = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while(i<nums.length-2){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int temp = target-nums[i]-nums[left]-nums[right];
                if(temp>0){
                    if(result>temp){
                        result = temp;
                        ans = nums[i]+nums[left]+nums[right];
                    }
                    left++;
                }
                else if(temp<0){
                    if(result>-temp){
                        result = -temp;
                        ans = nums[i]+nums[left]+nums[right];
                    }
                    right--;
                }
                else return target;
            }
            i++;
        }
        return ans;
    }
    public static int getLeft(int i,int [] nums){
        return ++i;
    }
    public static int getRight(int i,int [] nums){
        return --i;
    }
}
