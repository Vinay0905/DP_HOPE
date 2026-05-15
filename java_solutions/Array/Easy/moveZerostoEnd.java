package java_solutions.Array.Easy;

public class moveZerostoEnd {
    
        public static void bruteForce(int[] arr){
            int n=arr.length;
            int[] ne=new int[n];
            int cnt=0;
            
            for(int i=0;i<n;i++){
                if(arr[i]!=0){
                    ne[cnt]=arr[i];
                    cnt++;
                }
                
            }
            for(int i=0;i<cnt;i++){
                arr[i]=ne[i];
            }
            for(int i=cnt;i<n;i++){
                arr[i]=0;
            }
        
        }

    public static void OptimalSolution(int[] arr){
        int j=-1;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
            {
                j=i;
                break;
            }
        }
        if(j==-1)return;
        for(int i=j+1;i<n;i++){
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
        OptimalSolution(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        bruteForce(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
