package java_solutions.Array;

public class KadaneAlgo {
    

    public static int bruteForce(int[] nums){
        int n=nums.length;
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for (int k = i; k <= j; k++) {
                    sum+=nums[k];
                
                }
                

                maxL=Math.max(maxL,sum);
                
            }
        }
        return maxL;

    }
    public static int betterSolution(int[] nums){
        int n=nums.length;
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                
                
                    sum+=nums[j];
                
                
                

                maxL=Math.max(maxL,sum);
                
            }
        }
        return maxL;
    }
    // Kadanes Algorithm
    public static int optimalSolution(int[] arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum<0)sum=0;
            sum+=arr[i];
            max=Math.max(max, sum);

        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, -2, 7, -4}; 
        int s=bruteForce(nums);
        System.out.println(s);
        System.out.println(betterSolution(nums));
        System.out.println(optimalSolution(nums));
        
    }
}
