package java_solutions.Array.Easy;

public class linear_search {
    
    // Checks each index one by one until the target value is found.
    // Returns the matching index, or -1 when the target is absent.
    public static int LinearSeach(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
        

}
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int t=3;

        int ans=LinearSeach(arr,t);
        if(ans==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: "+ans);
        }
    }
}
