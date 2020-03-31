package com.algorithm;

public class SolutionQ12 {
    public static String intToRoman(int num) {
        StringBuilder s=new StringBuilder();
        if(num>=1000){
            int b=num/1000;
            for(;b>0;b--){
                s.append("M");
            }
            num = num%1000;
        }
        if(num>=100){
            int b=num/100;
            if(b==9)
                s.append("CM");
            else if(b>4){
                s.append("D");
                for(int i=b-5 ;i>0;i--){
                    s.append("C");
                }
            }
            else if(b==4)
                s.append("CD");
            else if(b<4){
                for(int i=b;i>0;i--)
                    s.append("C");
            }
            num=num%100;
        }
        if(num>=10){
            int b = num/10;
            if(b==9){
                s.append("XC");
            }
            else if(b>4){
                s.append("L");
                for(int i=b-5;i>0;i--){
                    s.append("X");
                }
            }
            else if(b==4)
                s.append("XL");
            else if(b<4){
                for(int i=b;i>0;i--){
                    s.append("X");
                }
            }
            num =num%10;
        }
        if(num>0){
            int b=num;
            if(b==9)
                s.append("IX");
            else if(b>4){
                s.append("V");
                for(int i=b-5;i>0;i--){
                    s.append("I");
                }
            }
            else if(b==4)
                s.append("IV");
            else if(b<4){
                for(int i=b;i>0;i--){
                    s.append("I");
                }
            }
        }
        return s.toString();
    }
    public static String intToRoman2(int num){
        int [] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int cursor = 0;
        StringBuilder s = new StringBuilder();
        while(cursor<13){
            while(num>=nums[cursor]){
                num = num-nums[cursor];
                s.append(strs[cursor]);
            }
            cursor++;
        }
        return s.toString();
    }
}
