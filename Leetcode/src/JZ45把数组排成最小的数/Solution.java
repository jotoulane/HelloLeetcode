package JZ45把数组排成最小的数;

class Solution {
    public String minNumber(int[] nums) {
        String[] arr=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        quickSort(arr,0,arr.length-1);
        String res=new String();
        for (String  a: arr) {
            res+=a;
        }
        return res;
    }
    void quickSort(String[] arr, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        while(i < j) {
            while((arr[j] + arr[l]).compareTo(arr[l] + arr[j]) >= 0 && i < j) j--;
            while((arr[i] + arr[l]).compareTo(arr[l] + arr[i]) <= 0 && i < j) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    public void swap(String[] arr,int a,int b){
        String temp =arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
