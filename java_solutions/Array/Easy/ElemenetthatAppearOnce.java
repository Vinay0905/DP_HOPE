package java_solutions.Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class ElemenetthatAppearOnce {
    
    // For each element, count its frequency by scanning the whole array.
    // The first element whose count is exactly one is the answer.
    public static int bruteforce(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int nums=arr[i];
            int cnt=0;
            for(int j=0;j<n;j++){
                if(arr[j]==nums){
                    cnt++;
                }

            }
            if(cnt==1)return nums;
        }
        return 0;
    }
    // Builds a frequency array using the maximum element as the size limit.
    // Then returns the value whose stored frequency is one.
    public static int betterSolution(int[] arr){
        int maxEle=0;
        for(int i :arr){
            maxEle=Math.max(i, maxEle);
        }
        int[] newarr=new int[maxEle+1];
        for(int i=0;i<arr.length;i++){
            newarr[arr[i]]++;
            
        }

        for (int i = 0; i < newarr.length; i++) {
        if (newarr[i] == 1) {
            return i;
        }
    }
        return 0;
        

    }
    // Stores frequencies in a HashMap so the method works without needing a fixed value range.
    // After counting, it scans the original array to return the element that appeared once.
    public static int optimalSolution(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==1){
                return arr[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4};
        int ans=betterSolution(arr);
        System.out.println(ans);
    }
}
