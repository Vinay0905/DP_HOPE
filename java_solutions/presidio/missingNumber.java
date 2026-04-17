package java_solutions.presidio;

public class missingNumber {
    public static int MissingNumber(int[] nums){
        int n=nums.length;
        int sum=sumq(n);
        int mainsum=0;
        for(int i:nums){
            mainsum+=i;

        }
        return sum-mainsum;
    }
    public static int sumq(int n){
        if(n==0)return 0;
        return n+(sumq(n-1));
    }
    public static void main(String[] args) {
        int[] nums={9,6,4,2,3,5,7,0,1};
        System.out.println(MissingNumber(nums));
    }
}
