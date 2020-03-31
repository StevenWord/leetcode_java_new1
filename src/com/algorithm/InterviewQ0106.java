package com.algorithm;

public class InterviewQ0106 {
    public String compressString(String S) {
        if (S.equals(""))
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        char temp = S.charAt(0) ;
        int num = 1;
        for(int i=1;i<S.length();i++){
            if(temp==S.charAt(i)){
                num++;
            }
            else {
                stringBuilder.append(temp);
                stringBuilder.append(num);
                temp=S.charAt(i);
                num=1;
            }
        }
        stringBuilder.append(temp);
        stringBuilder.append(num);
        String str = stringBuilder.toString();
        if(str.length()>=S.length())
            return S;
        else return str;
    }
}
