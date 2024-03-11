package T215数组总的第K个大最大的元素;

public class Solution02 {
    public static void main(String[] args) {
        int [] arr=new int[]{3,2,1,5,6,4};
        int k=2;
        int res = new Solution02().quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println(res);
    }
    public int findKthLargest(int[] nums, int k) {
        int i = quickSelect(nums, 0, nums.length - 1, k - 1);
        return i;
    }
    public int quickSelect(int[] arr, int l ,int r,int k){
        if(l==r) return 0;
        int i=l,j=r;
        while(i<j){
            while(i<j && arr[j]<=arr[l]) j--;
            while(i<j && arr[i]>=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        if (i<k){
            return quickSelect(arr, l,i-1,k);
        }else if(i>k){
            return quickSelect(arr, i+1,r,k);
        }else {
            return arr[k];
        }


    }
    public void swap(int[] arr,int a ,int b ){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
