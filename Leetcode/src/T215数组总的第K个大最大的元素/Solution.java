package T215数组总的第K个大最大的元素;

class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,1,5,6,4};
        new Solution().findKthLargest(arr,2);

    }
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0 ,nums.length-1);
        for (int a :nums) {
            System.out.print(a+" ");
        }
        return nums[k-1];
    }
    public void quickSort(int[] arr,int l ,int r){
        if(l>=r) return;
        int i=l,j=r;
        while(i<j){
            while(i<j && arr[j]<=arr[l]) j--;
            while(i<j && arr[i]>=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        quickSort(arr, l,i-1);
        quickSort(arr, i+1,r);
    }

    public void swap(int[] arr,int a ,int b ){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
