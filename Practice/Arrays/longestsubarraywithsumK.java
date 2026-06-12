package Practice.Arrays;

import java.util.HashMap;

public class longestsubarraywithsumK {
    
    public static void main(String[] args) {
        int[] arr={2,5,1,7,10}; int k=14;
        System.out.println(brute(arr, k));
        System.out.println(bettter(arr, k));

    }
    public static int brute(int[] arr,int k){
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum<=k){
                    maxLen=Math.max(maxLen, j-i+1);
                }
            }
        }   
        return maxLen;
    }

    public static int bettter(int[] arr,int k){
        int l=0,sum=0,maxLen=0;
        for(int r=0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>k){
                l++;
                sum=sum-arr[l];
            }
            maxLen=Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
    

public static int optimal(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if (sum == k) {
            maxLen = Math.max(maxLen, i + 1);
        }

        int remaining = sum - k;

        if (map.containsKey(remaining)) {
            int len = i - map.get(remaining);
            maxLen = Math.max(maxLen, len);
        }

        if (!map.containsKey(sum)) {
            map.put(sum, i);
        }
    }

    return maxLen;
}
}
