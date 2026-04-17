package java_solutions.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class largest_divisible {
    
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        Arrays.sort(nums);
        List<List<Integer>> dp=new ArrayList<>();
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp.get(j).size()>temp.size())
                        temp=new ArrayList<>(dp.get(j));
                }
            }
            temp.add(nums[i]);
            dp.add(temp);

            if(temp.size()>res.size()){
                res=temp;
            }

        }
        return res;


    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(largestDivisibleSubset(nums));
    }

}
