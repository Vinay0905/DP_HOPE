package java_solutions.Array;

import java.util.HashMap;
import java.util.Map;

public class LargestSumwithSubarrayK {
    public static int bruteforce(int[] arr,int targ){
        int len=0;
        for (int start = 0; start < arr.length; start++) {
            int sumation=0;
            for (int end = start; end < arr.length; end++) {
                
                
                sumation+=arr[end];
                if (sumation==targ){
                    len=Math.max(len,end-start+1);
                }
                
            }
        }
        return len;
    }
    // Prefix Sum
    public static int betterSolution(int[] arr ,int targ){
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==targ)maxLen=Math.max(i+1,maxLen);
            int rem=sum-targ;
            if(map.containsKey(rem)){
                int len=i-map.get(rem);
                maxLen=Math.max(maxLen,len);


            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }


        }


        return maxLen;
    }
    // Two pointer
    public static int optimalSolu(int[] arr, int targ){
        int i=0;
        int maxLen=0;
        int sumation=0;
        for(int j=0;j<arr.length;j++){
            sumation+=arr[j];

            while(i<=j && sumation>targ){
                sumation-=arr[i];
                i++;
            }

            if(sumation==targ){
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int targ=15;
        System.out.println(bruteforce(arr, targ));
        int[] arr1 = {1, 2, 3, 1, 1, 1, 1};
        int targ1 = 6;

        System.out.println(betterSolution(arr1, targ1)); // 3

    }
}
