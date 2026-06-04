package java_solutions.Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class longestSubarrywithGivenSum {

  
    // Tracks prefix sums and stores their first positions in a HashMap.
    // If prefixSum - k already exists, the subarray between those positions sums to k.
    public static int betteroApproch(int[] arr,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(map.containsKey(prefixSum-k)){
                res=Math.max(res,i-map.get(prefixSum-k));

            }
            if(!map.containsKey(prefixSum))
                map.put(prefixSum,i);

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,7,1,9};
        int k=15;
        System.out.println(betteroApproch(arr, k));
        int[] nums={10,5,2,7,1,-10};
        int k1=15;
        System.out.println(betteroApproch(nums, k1));
    }
}
