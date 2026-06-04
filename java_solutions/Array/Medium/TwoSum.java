package java_solutions.Array.Medium;
import java.util.Arrays;
// import java.util.Arrays;
import java.util.HashMap;
// import java.util.List;
import java.util.Map;

public class TwoSum {
    // Checks every pair of elements to see whether their sum equals the target.
    // Returns YES as soon as a valid pair is found.
    public static String bruteforce(int[] arr,int target){
        int n = arr.length;
        // Outer loop picks one element at a time
        for (int i = 0; i < n; i++) {
            // Inner loop searches for another element that complements arr[i]
            for (int j = i + 1; j < n; j++) {
                // If sum equals target, return "YES"
                if (arr[i] + arr[j] == target) {
                    return "YES";
                }
            }
        }
        // No pair found that sums to target
        return "NO";


    }
    // Stores each number's index in a HashMap and looks for target - current.
    // When the needed value already exists, the pair of indices is returned.
    public static int[] betterSolution(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    // Sorts the array and uses two pointers from both ends to find the target sum.
    // Moving the pointers adjusts the sum until the pair is found or exhausted.
    public static int[] optimalSolu(int[] arr,int target){
        Arrays.sort(arr);
        int l=0,r=arr.length-1;
        while(l<r){
            int suma=arr[l]+arr[r];
            if(suma>target){
                r--;
            }
            if(suma<target){
                l++;
            }
            if(suma==target){
                return new int[]{arr[l],arr[r]};
            }

        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int  arr[] = {2,6,5,8,11}, target = 14;
        System.out.println(bruteforce(arr, target));
        System.out.println(Arrays.toString(betterSolution(arr, target)));
        System.out.println(Arrays.toString(optimalSolu(arr, target)));
    }
}
