package com.algorithm;

public class SolutionQ9 {
    public boolean isPalindrome(int x){
        String str = String.valueOf(x);
        char [] chars = str.toCharArray();
        int i = 0, j = str.length()-1;
        while(i<j){
            if(chars[i]==chars[j]){
                i++;
                j--;
            }
            else break;
        }
        if(i>=j)
            return true;
        else
            return false;
    }

    public boolean isPalindrome2(int x){
        String reversedStr = (new StringBuilder(String.valueOf(x)).reverse()).toString();
        return reversedStr.equals(String.valueOf(x));
    }

    public static boolean isPalindrome3(int x){
        if(x<0) return false;
        int div = 1;
        while((x/div)>=10)div*=10;
        while(x>0){
            int left = x/div;
            int right = x%10;
            if(left!=right) return false;
            x=(x%div)/10;
            div/=100;
        }
        return true;
    }
}
