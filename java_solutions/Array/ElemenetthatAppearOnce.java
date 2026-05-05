package java_solutions.Array;

public class ElemenetthatAppearOnce {
    
    public static int bruteforce(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int nums=arr[i];
            int cnt=0;
            for(int j=0;j<n;j++){
                if(arr[j]==nums){
                    cnt++;
                }

            }
            if(cnt==1)return nums;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4};
        int ans=bruteforce(arr);
        System.out.println(ans);
    }
}
