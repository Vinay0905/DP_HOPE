package java_solutions.Array.Medium;
public class SortArraysZeroOneTwo {
    public static void bruteforce(int[] arr){
        int cnt0=0,cnt1=0,cnt2=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)cnt0++;
            else if(arr[i]==1)cnt1++;
            else cnt2++;
        }
        for(int i=0;i<cnt0;i++)arr[i]=0;
        for(int i=cnt0;i<cnt0+cnt1;i++)arr[i]=1;
        for(int i=cnt0+cnt1;i<n;i++)arr[i]=2;

    }
    public static void betterOrOptimalSolution(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;

            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};
        bruteforce(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
        int[] arr = {2, 0, 2, 1, 1, 0};
        System.out.println();
        betterOrOptimalSolution(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
