package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionQ15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp =new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    lists.add(temp);
                    left = getLeftPlace(left,nums);
                }
                else if(nums[i]+nums[left]+nums[right]>0){
                    right = getRightPlace(right,nums);
                }
                else if(nums[i]+nums[left]+nums[right]<0){
                    left = getLeftPlace(left,nums);
                }
            }
            i = getLeftPlace(i,nums);
        }
        return lists;
    }
    public static int getLeftPlace(int i,int [] nums){
        while((i+1)<nums.length&&nums[i]==nums[i+1])
                i++;
        return i+1;

    }
    public static int getRightPlace(int i,int [] nums){
        while((i-1)>=0&&nums[i]==nums[i-1])
                i--;
        return i-1;
    }
}
