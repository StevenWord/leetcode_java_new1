package com.algorithm;

public class SolutionQ4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        double []temp=new double[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i< nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp[k++]=nums1[i++];
            }
            else{
                temp[k++]=nums2[j++];
            }
        }
        if(i<nums1.length){
            for(;i<nums1.length;i++){
                temp[k++]=nums1[i];
            }
        }else{
            for(;j<nums2.length;j++){
                temp[k++]=nums2[j];
            }
        }
        System.out.println(k);
        if(k%2==1)
            return temp[k/2];
        else return (temp[k/2]+temp[k/2-1])/2;

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int n=nums1.length;
        int m=nums2.length;
        if(m<n) return findMedianSortedArrays2(nums2,nums1);
        int Lmax1=0,Rmin1=0,Lmax2=0,Rmin2=0,c1=0,c2=0,lo=0,hi=2*n;
        while(lo<=hi){
            c1=(lo+hi)/2;
            c2=m+n-c1;
            Lmax1=(c1==0) ?Integer.MIN_VALUE:nums1[(c1-1)/2];
            Rmin1=(c1==2*n)?Integer.MAX_VALUE:nums1[c1/2];
            Lmax2=(c2==0) ?Integer.MIN_VALUE:nums2[(c2-1)/2];
            Rmin2=(c2==2*m)?Integer.MAX_VALUE:nums2[c2/2];
            if(Lmax1>Rmin2)
                hi=c1-1;
            else if(Lmax2>Rmin1)
                lo=c1+1;
            else break;
        }
        double a=( Math.max(Lmax1,Lmax2)+ Math.min(Rmin1,Rmin2))/2.0;
        return a;

    }
}
