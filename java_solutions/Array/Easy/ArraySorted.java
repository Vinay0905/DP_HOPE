package java_solutions.Array.Easy;

public class ArraySorted {
    
    // Checks every adjacent pair to confirm the array never decreases.
    // If any previous element is greater than the current one, the array is not sorted.
    public static boolean sortedorNot(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i])return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        boolean ans=sortedorNot(arr);
        System.out.println(ans);
    }
}


