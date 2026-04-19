package java_solutions.Array;

public class moveZerostoEnd {
    public static void moveZero(int[] arr){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
            if(j==-1)return;
            for(int i=j+1;i<arr.length;i++){
                if(arr[i]!=0){
                    int t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                    j++;
                }
            }

    }
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZero(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
