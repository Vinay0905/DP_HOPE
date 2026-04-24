package java_solutions.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class UnionOfTwoSortedArrays {

    public static List<Integer> twosortedArray(int[] arr1,int[] arr2,int n ,int m){
        TreeMap<Integer,Integer> freq=new TreeMap<>();
        for(int i=0;i<n;i++){
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);

        }
        for(int i=0;i<m;i++){
            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
            
        }
        List<Integer> list=new ArrayList<>();
        for(int key:freq.keySet()){
            list.add(key);
        }
        return list ;

    }
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7,8,9,10};
        int[] arr2={2,3,4,4,5,11,12};
        int n=10;
        int m=7;
        List<Integer> Uninon=twosortedArray(arr1,arr2,n,m);
        for(int val:Uninon){
            System.err.print(val+" ");
        }

    }
}
