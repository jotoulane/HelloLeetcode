package Offer40最小的K个数字;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,1};
        new Solution().quickSort(arr,0,arr.length-1);
        for (int a :arr) {
            System.out.print(a+" ");
        }
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length-1);
        return Arrays.copyOf(arr,k);
    }
    public void quickSort(int[] arr, int l ,int r) {
        if (l>=r) return;
        int i=l;
        int j=r;
        while(i<j){
            while (i<j && arr[j]>=arr[l]) j--;
            while (i<j && arr[i]<=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,l,i);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
    public void swap(int[] arr,int a,int b){
        int temp =arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
