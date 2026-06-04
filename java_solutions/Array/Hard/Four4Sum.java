package java_solutions.Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Four4Sum {
    
    // Checks every possible group of four elements and tests whether their sum is zero.
    // Each valid quadruplet is sorted and stored in a set to avoid duplicates.
    public static List<List<Integer>> bruteforce(int[] arr){
        Set<List<Integer>> set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                    long sum=(long)arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==0){
                        List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        Collections.sort(temp);
                        set.add(temp);

                    }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> res=bruteforce(arr);
        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }

        System.out.println();
    }
}
