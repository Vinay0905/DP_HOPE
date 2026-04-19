package java_solutions.Array;

public class RotateArrayLeft {

    public static int[] rotateArray(int[] arr ,int k){
        while(k>1){
            int temp=arr[0];
            for(int i=1;i<arr.length;i++){
                arr[i-1]=arr[i];

            }
            arr[arr.length-1]=temp;
            k--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        // rotateArray(nums);
        nums=rotateArray(nums,k);

       
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
