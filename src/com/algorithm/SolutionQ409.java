package com.algorithm;

public class SolutionQ409 {
    public int longestPalindrome(String s) {
        int [] nums  = new int[52];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'a'>=0)
                nums[(s.charAt(i)-'a')+26]++;
            else nums[s.charAt(i)-'A']++;
        }
        int count = 0;
        int flag = 0;
        for(int i=0;i<52;i++){
            count+=(nums[i]/2)*2;
            if(nums[i]%2==1)
                flag=1;
        }
        count+=flag;
        return count;
    }
}
