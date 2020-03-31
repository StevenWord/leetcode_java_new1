package com.algorithm;

public class SolutionQ14 {
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean flag = true;
        if(strs.length==0)
            return "";
        for(;i<strs[0].length();i++){
            int j=0;
            while(flag==true&&j<strs.length&&i<strs[j].length()){
                if(strs[0].charAt(i)!=strs[j].charAt(i)){
                    flag = false;
                    break;
                }
                else j++;
            }
            if(j<strs.length&&i>=strs[j].length())
                flag = false;
            if(flag == false)
                break;
        }
        return strs[0].substring(0,i);
    }
}
