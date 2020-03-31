package com.algorithm;

public class SolutionQ11 {
    public static int maxArea(int[] height){
        int maxArea = 0;
        for(int i=0;i<height.length-1;i++){
            int temp=0;
            for(int j=i+1;j<height.length;j++){
                if(height[i]>height[j]){
                    temp = height[j]*(j-i);
                }
                else temp = height[i]*(j-i);
                maxArea = Math.max(maxArea,temp);
            }

        }
        return maxArea;
    }
    public static int maxArea2(int [] height){
        int i=0;
        int j=height.length-1;
        int maxArea = 0;
        int temp = 0;
        while(i<j){
            temp = (j-i)*Math.min(height[i],height[j]);
            maxArea = Math.max(maxArea,temp);
            if(height[i]<height[j])
                i++;
            else j--;
        }
        return maxArea;
    }
}
