package java_solutions.Array.Medium;
import java.util.Arrays;
import java.util.HashSet;


public class LongestContinuousSequence {
    public static boolean LinearSearch(int[] arr,int num){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==num)return true;
            
        }
        return false;
    }
    public static int bruteforce(int[] arr ){
        
        
        int n=arr.length;
        int longest=1;
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            int x=arr[i];
            int cnt=1;
            while(LinearSearch(arr, x+1)==true){
                x+=1;
                cnt+=1;
            }
            longest=Math.max(longest, cnt);
        }
        return longest;
    }
    public static int bettersolution(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int count=0;
        int leastSmaller=Integer.MIN_VALUE;
        int longest=1;
        for(int i=0;i<n;i++){
            if(arr[i]-1==leastSmaller){
                count+=1;
                leastSmaller=arr[i];

            }
            else if(arr[i]!=leastSmaller){
                count=1;
                leastSmaller=arr[i];
            }
            longest=Math.max(longest,count);
        }
        return longest;

    }

    public static int optimalsolution(int[] arr){
        HashSet<Integer> hash=new HashSet<>();
        int n=arr.length;
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            hash.add(arr[i]);

        }
        int longest=1;
        for(int items:hash){
            if(!hash.contains(items-1)){
                int cnt=1;
                int x=items;
                while(hash.contains(x+1)){
                    x++;
                    cnt++;
                }
                longest=Math.max(cnt, longest);
            }

        }
        return longest;

    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(bruteforce(nums));
        System.out.println(bettersolution(nums));        
        System.out.println(optimalsolution(nums));        
        
    }
}
