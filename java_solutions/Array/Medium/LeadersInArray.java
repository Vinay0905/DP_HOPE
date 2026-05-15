package java_solutions.Array.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    

    public static List<Integer> bruteforce(int[] arr){
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    leader=false;
                    break;
                }
            }

            if(leader==true)ans.add(arr[i]);
        }
        return ans;

    }
    public static List<Integer> optimalSolution(int[] arr){
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int max=arr[n-1];
        ans.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max=arr[i];
            }

        }
        Collections.reverse(ans);
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 0};
        List<Integer> lead=bruteforce(arr);
        System.out.println(lead);
        int[] nums={10,22,12,3,0,6};
        System.out.println(optimalSolution(nums));
    }

}
