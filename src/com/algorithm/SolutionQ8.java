package com.algorithm;

public class SolutionQ8 {
    public static int myAtoi(String str){
        boolean flag=true;
        int ret=0;
        boolean isBiggerThanZero=true;
        for(char c:str.toCharArray()){
            if(flag&&c==' ');
            else if(flag&&c=='-'){
                flag=false;
                isBiggerThanZero=false;
            }
            else if(flag&&c=='+'){
                flag=false;
            }
            else if(flag&&(c>='0'&&c<='9')){
                ret=c-'0';
                flag=false;
            }
            else if(!flag&&(c>='0'&&c<='9')){
                if((ret>Integer.MAX_VALUE/10&&isBiggerThanZero)||(ret==Integer.MAX_VALUE/10&&c>'7'&&isBiggerThanZero))return Integer.MAX_VALUE;
                if((ret>Integer.MAX_VALUE/10&&!isBiggerThanZero)||(ret==Integer.MAX_VALUE/10&&c>'8'&&!isBiggerThanZero))return Integer.MIN_VALUE;
                if(ret==Integer.MAX_VALUE/10&&c=='8'&&!isBiggerThanZero)return Integer.MIN_VALUE;
                ret=10*ret+c-'0';
            }
            else if(isBiggerThanZero)
                return ret;
            else return -ret;
        }
        if(isBiggerThanZero)
            return ret;
        else return -ret;

    }
}
