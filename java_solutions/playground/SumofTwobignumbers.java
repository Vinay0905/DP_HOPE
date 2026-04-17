package java_solutions.playground;

public class SumofTwobignumbers {
    
    public static int[] addtwonumbers(int[] n1,int[] n2){
        int maxLen=Math.max(n1.length,n2.length);
        int[] dp=new int[maxLen+1];
        
        int carry=0;
        for(int i=0;i<maxLen;i++){
            int sum=carry;

            if (i<n1.length){
                sum+=n1[n1.length-1-i];
            }
            if (i<n2.length){
                sum+=n2[n2.length-1-i];
            }
            dp[maxLen-i]=sum%10;
            carry=sum/10;
        }
        if(carry>0){
            dp[0]=carry;
        }
        return dp;

    }
    public static void main(String[] args) {
        //int a=12;
        int[] n1={9,2,8,1,3,5,6,7,3,1,1,6};
        //int b=9;
        int[] n2={7,8,4,6,2,1,9,9,7};
        int[] sum = addtwonumbers(n1, n2);
        System.out.print("Sum of the two numbers: ");
        int startIndex = (sum[0] == 0) ? 1 : 0;  // Skip leading zero
        for (int i = startIndex; i < sum.length; i++) {
            System.out.print(sum[i]);
        }   

    }
}
