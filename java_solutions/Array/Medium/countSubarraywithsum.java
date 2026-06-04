package java_solutions.Array.Medium;

import java.util.HashMap;

public class countSubarraywithsum {
    
    // Tries every subarray and calculates its sum using a third loop.
    // Counts the subarrays whose sum equals the target.
    public static int bruteForce(int[] arr,int target){
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==target){
                    count++;
                }
            }
        }
        return count;

    }
    
    // Fixes a start index and extends the end index while maintaining a running sum.
    // This counts target-sum subarrays without recalculating the whole sum each time.
    public static int betterSolution(int[] arr,int target){
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
            
                if(sum==target){
                    count++;
                }
            }
        }
        return count;
    }

    // Uses prefix sums and counts how many earlier prefixes can form the target sum.
    // The HashMap stores how often each prefix sum has appeared.
    public static int optimalSolution(int[] arr,int target){
        //prefix sum concept
        HashMap<Integer,Integer> map=new HashMap<>();
        int presum=0,cnt=0;
        int n=arr.length;
        map.put(0, 1);
        for(int i=0;i<n;i++){
            presum+=arr[i];
            int otherSum=presum-target;
            if(map.containsKey(otherSum)){
                cnt+=map.get(otherSum);
            }
            map.put(presum,map.getOrDefault(presum, 0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int[] new1={1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(bruteForce(arr,target));
        System.out.println(betterSolution(arr, target));
        System.out.println(optimalSolution(new1, 3));

    }
}
