package java_solutions.Array;

public class RotateArrayRight {
    public static int[] rightroataionbyOne(int[] arr){
        int temp=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;
        return arr;
    }

    public static void rotateArrayRight(int[] arr,int k){
        
        while(k>0){
            arr=rightroataionbyOne(arr);
            k--;    
        }
        
    }
    public static void rotateArrayRightOpti(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    public static void reverse(int [] arr, int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        rotateArrayRight(nums,k);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }    
    }

}
