package java_solutions.presidio;

public class SearchInsertPosition {
    
    public static int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target)return m;
            else if(nums[m]<target)l=m+1;
            else r=m-1;

        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=5;
        System.out.println(searchInsert(nums,target));

    }
}
