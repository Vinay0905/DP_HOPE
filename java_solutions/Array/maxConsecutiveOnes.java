package java_solutions.Array;

public class maxConsecutiveOnes {

    public static int function(int[] arr){

        int counter=0;
        int max=0;
        for(int i:arr){
            if(i==1){
                counter++;
                max=Math.max(max, counter);
            }
            else
                counter=0;
        }
        return max;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};        
        int ans=function(nums);
        System.err.println(ans);

    }
}
