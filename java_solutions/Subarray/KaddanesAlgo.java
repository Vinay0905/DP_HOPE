package java_solutions.Subarray;

public class KaddanesAlgo {
    public static int maxSubArray(int[] arr){
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int i=0;int j=0;
        int sum=0;
        while(i<n && j<n){
            if(sum+arr[i]<0){
                sum=0;
                i++;
                j=i;
            }
            else{
                sum+=arr[i];
                j=i;
                if(sum > max){    
                    max = sum;
                }
                i++;
            }
        }
        return max;
    }
    public static int[] maxSubArrayDisplayed(int[] arr){
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int i=0;int j=0;int k=0;
        int sum=0;
        int start=0;int end=0;
        int tempstart=0;
        while(i<n && j<n){
            if(sum+arr[i]<0){
                sum=0;
                i++;
                j=i;
                tempstart=i;
            }
            else{
                sum+=arr[i];
                j=i;
                if(sum > max){    
                    max = sum;
                    start = tempstart;
                    end = j;
                }
                i++;
            }
        }
        int[] result=new int[end-start+1];
        for(int m=start;m<=end;m++){
            result[k++]=arr[m];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArrayDisplayed(arr);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}
