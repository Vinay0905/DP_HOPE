package java_solutions.Array.Easy;

public class findthemissingnumber {
    
    public static int missingnumber(int[] arr){

        // HashMap<Integer,Integer> freq=new HashMap<>();
        // for(int i=0;i<=arr.length;i++){
        //     int flag=0;
        //     for(int j=0;j<arr.length-1;j++){
        //         if(arr[j]==i){
        //             flag=1;
        //             break;
        //         }

        //     }
        // if(flag==0){
        //     return i;
        // }
        // }
        // return 0;
        int n=arr.length+1;
        int[] hash=new int[n+1];
        
        for(int i=0;i<n-1;i++){
            
                hash[arr[i]]++;
            
        }
        for(int i=1;i<=n;i++){
            if(hash[i]==0)return i;
        }

        return -1;
    }
    
    public static int bettersolution(int[] arr){
        int m=arr[0];
        int currsum=0;
        for(int i:arr){
            m=Math.max(i, m);
            currsum+=i;
        }

        int fullsum=m*(m+1)/2;
        int ans=fullsum-currsum;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,7};
        int ans=missingnumber(arr);
        System.err.println(ans);
    }
}
