package java_solutions.Array.Easy;

public class maxConsecutiveOnes {

    // Counts the current streak of 1s and resets it whenever a 0 appears.
    // The maximum streak seen during the scan is returned.
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
    // Scans the array while counting consecutive 1s and resetting the counter on 0.
    // This keeps track of the longest block of 1s found so far.
    public static int bruteforce(int[] arr){
        int max=0;
        int cnter=0;
        for(int i:arr){
            if(i==1){
                cnter++;
                max=Math.max(max,cnter);
            }
            else{
                cnter=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};        
        int ans=bruteforce(nums);
        System.err.println(ans);

    }
}
