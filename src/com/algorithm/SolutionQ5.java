package com.algorithm;

public class SolutionQ5 {
    //求最长公共子串
    public static String longestPalindrome(String s){
        if (s.equals(""))
            return "";
        String reverse=new StringBuffer(s).reverse().toString();
        int [][]a=new int[s.length()][s.length()];
        int max=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        a[i][j]=1;
                    }
                    else{
                        a[i][j]=a[i-1][j-1]+1;
                    }
                }
                if(a[i][j]>max){
                    max=a[i][j];
                    end=i;
                }

            }
        }
        return s.substring(end+max-1,end+1);
    }
    //反转字符串，求最大公共子序列
    public static String longestPalindrome2(String s){
        if (s.equals(""))
            return "";
        String reverse=new StringBuffer(s).reverse().toString();
        int [][]a=new int[s.length()][s.length()];
        int max=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        a[i][j]=1;
                    }
                    else{
                        a[i][j]=a[i-1][j-1]+1;
                    }
                }
                if(a[i][j]>max){
                    int pre_posi=s.length()-1-j;
                    if(i==pre_posi+a[i][j]-1){
                        max=a[i][j];
                        end=i;
                    }

                }

            }
        }
        return s.substring(end-max+1,end+1);
    }
    //对function2进行空间优化
    public static String longestPalindrome3(String s){
        if (s.equals(""))
            return "";
        String reverse=new StringBuffer(s).reverse().toString();
        int []a=new int[s.length()];
        int max=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=0;j--){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        a[j]=1;
                    }
                    else{
                        a[j]=a[j-1]+1;
                    }
                }
                else{
                    a[j]=0;
                }
                if(a[j]>max){
                    int pre_posi=s.length()-1-j;
                    if(i==pre_posi+a[j]-1){
                        max=a[j];
                        end=i;
                    }

                }

            }
        }
        return s.substring(end-max+1,end+1);
    }
//动态规划求
    public static String longestPalindrome4(String s){
        int [][]a= new int[s.length()][s.length()];
        int maxLength=0;
        String longestSubString="";
        for(int i=0;i<s.length();i++){
            a[i][i]=1;
            maxLength=1;
            longestSubString=s.substring(i,i+1);
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                a[i][i+1]=2;
                longestSubString=new StringBuffer(s.substring(i,i+2)).toString();
                int cc=0;}

        }
        for(int len=2;len<s.length();len++){
            for(int start=0;start<s.length();start++){
                if(start+len>=s.length())
                    break;
                if(s.charAt(start)==s.charAt(start+len)){
                    if(a[start+1][start+len-1]!=0){
                        a[start][start+len]=a[start+1][start+len-1]+2;
                        if(len+1>=maxLength) {
                            longestSubString = s.substring(start, start + len+1);
                            maxLength=len+1;
                        }}

                }
            }
        }
        return longestSubString;
    }
    //优化动态规划
    public static String longestPalindrome5(String s){
        String res="";
        boolean [][]dp=new boolean[s.length()][s.length()];
        for(int len=0;len<s.length();len++){
            for(int start=0;start<s.length();start++){
                if(start+len>=s.length())
                    break;
                dp[start][start+len]=(len==0||len==1||dp[start+1][start+len-1])&&s.charAt(start)==s.charAt(start+len);
                if(dp[start][start+len]&&len+1>=res.length()){
                    res=s.substring(start,start+len+1);
                }
            }
        }
        return res;
    }
    public static String longestPalindrome6(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    public static String longestPalindrome7(String s){
        if(s=="")
            return "";
        int len=0;
        String sub="";
        for(int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len3=Math.max(len1,len2);
            if(len<len3){
                len=len3;
            sub=s.substring(i-(len-1)/2,i+len/2+1);}

        }
        return sub;
    }

    public static int expandAroundCenter(String s, int center1, int center2){
        int L=center1;
        int R=center2;
        while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

}
