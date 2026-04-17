package java_solutions.SlidingwWindow;

public class SlidingWindowMaximum {
    public static int Sumofslidingwindow(int[] nums,int k){
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int n=nums.length;

        for(int i=0;i<=n-k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(max<nums[j]){
                    max=nums[j];
                }

            }

            System.out.print(max + " ");
            
        }
        for(int i=0;i<=n-k;i++){
            int sum=Sumofslidingwindow(nums, k);
            System.out.println(sum + " ");
        }



    }
}
