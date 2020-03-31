package com.sort;

public class Sort {
    public static int [] mergeSort(int [] array,int low,int high){
        int mid = (low+high)/2;
        if(low<high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid+1, high);
        }
        return array;
    }
    public static int[] merge(int [] array,int left,int mid,int right){
        int flag2 = mid;
        int flag1 = right;
        int len = right-left+1;
        int [] mergearray = new int[len];
        int i=0;
        while(left<flag2&&mid<=right){
            if(array[left]<array[mid]){
                mergearray[i++]=array[left++];
            }
            else mergearray[i++]=array[mid++];
        }
        while(left<flag2)
            mergearray[i++]=array[left++];
        while (mid<=right)
            mergearray[i++]=array[mid++];
        for(int j=0;j<len;j++){
            array[flag1--]=mergearray[--i];
        }
        return array;
    }
}
