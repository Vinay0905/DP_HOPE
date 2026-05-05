package java_solutions.Array;

public class moveZerostoEnd {
    public static void moveZero(int[] arr){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
            if(j==-1)return;
            for(int i=j+1;i<arr.length;i++)
                if(arr[i]!=0){
                    int t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                    j++;
                }
        }
        public static int[] bruteForce(int[] arr){
            int n=arr.length;
            int[] ne=new int[n];
            int cnt=0;
            
            for(int i=0;i<n;i++){
                if(arr[i]!=0){
                    ne[cnt]=arr[i];
                    cnt++;
                }
                
            }
        return ne;
        }

            
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZero(nums);
        // for(int i=0;i<nums.length;i++){
        //     System.out.print(nums[i]+" ");
        // }
        int[] new1=bruteForce(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(new1[i]+" ");
        }
    }
}
