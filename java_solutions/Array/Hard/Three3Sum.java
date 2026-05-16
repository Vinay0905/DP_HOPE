package java_solutions.Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three3Sum {
    
    public static List<List<Integer>> bruteforce(int[] arr){
        Set<List<Integer>> set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);


                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

public static List<List<Integer>> betterSolu(int[] arr) {
    Set<List<Integer>> set=new HashSet<>();
    int n=arr.length;
    for(int i=0;i<n;i++){
        Set<Integer> hashset=new HashSet<>();
        for(int j=i+1;j<n;j++){
            int third=-(arr[i]+arr[j]);
            if(hashset.contains(third)){
                List<Integer> temp=Arrays.asList(arr[i],arr[j],third);
                Collections.sort(temp);
                set.add(temp);
            }
            hashset.add(arr[j]);

        }
    }
    return new ArrayList<>(set);

}
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = bruteforce(nums);

        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }

        System.out.println();

        List<List<Integer>> res1 = betterSolu(nums);

        for (List<Integer> triplet : res1) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }
}
