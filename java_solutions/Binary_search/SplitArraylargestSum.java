package java_solutions.Binary_search;
import java.util.*;
public class SplitArraylargestSum {

    
    public int countPartitions(int[] a ,int maxsum){
        int part=1;
        int subarr=0;


        for(int num:a){
            if(subarr+num<=maxsum){
                subarr+=num;
            }
            else{
                part++;
                subarr=num;
            }
            
        }
        return part;
    }
    public int largestSubarray(int[] a,int k){
        int l=Arrays.stream(a).max().getAsInt();
        int h=Arrays.stream(a).sum();
        while(l<=h){
            int m=(l+h)/2;
            int parti=countPartitions(a, m);
            if(parti>k)l=m+1;
            else h=m-1;
        }
        return l;
    }
    public static void main(String[] args) {
        int[] a={10,20,30,40};
        int k=2;
        SplitArraylargestSum sp=new SplitArraylargestSum();
        int ans=sp.largestSubarray(a, k);
        System.out.println(ans);
    }

}
