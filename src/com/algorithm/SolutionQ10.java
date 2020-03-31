package com.algorithm;

public class SolutionQ10 {
    public static boolean isMatch(String s,String p){
        if(p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty()&&(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.'));
        if(p.length()>=2&&p.charAt(1)=='*') return ((first_match&&isMatch(s.substring(1),p))||isMatch(s,p.substring(2)));
        else return first_match&&isMatch(s.substring(1),p.substring(1));
    }

    public static boolean isMatch2(String s,String p){
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i=s.length();i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                boolean first_match=i<s.length()&&j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
                if(first_match&&dp[i+1][j+1]==true)
                    dp[i][j]=true;
                else if((j+2)<=p.length()&&p.charAt(j+1)=='*')
                    dp[i][j]=dp[i][j+2]||(first_match&&dp[i+1][j+2])||(first_match&&dp[i+1][j]);
                else dp[i][j]=false;
            }
        }
        return dp[0][0];
    }
}
