package java_solutions.Array.Easy;

// import java.util.HashSet;
// import java.util.Set;

public class removeDuplicates {
    // Uses two pointers to overwrite duplicates in-place in a sorted array.
    // The returned length tells how many unique values are now at the front.
    public static int removeduplicates(int[] nums) {
        if(nums.length==0)return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;

    }
    public static void main(String[] args) {
        int[] arr={1,1,3,3,4,5,7,2,2,1};
        int ans=removeduplicates(arr);
        for(int i=0;i<ans;i++){
            System.out.print(arr[i]+" ");

        }

        
        
    }
}
