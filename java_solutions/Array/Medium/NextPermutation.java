package java_solutions.Array.Medium;
import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

     // Recursively builds all possible permutations by choosing unused elements.
     // This helper supports the brute force method.
     private static void generatePermutations(
            int[] arr,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> ans
    ) {
        if (current.size() == arr.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                current.add(arr[i]);
                used[i] = true;

                generatePermutations(arr, used, current, ans);

                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
    // Generates all permutations of the array and prints them.
    // This demonstrates the brute force idea before choosing the next arrangement.
    public static void bruteforce(int[] arr){
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used=new boolean[arr.length];
        generatePermutations(arr,used,new ArrayList<>(),ans);
        System.out.println(ans);

    }



    // Finds the first decreasing position from the right, swaps it with the next bigger value,
    // then reverses the suffix to create the next lexicographical permutation.
    public static void optimalSolution(int[] arr){
        int idx=-1;
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        if (idx == -1) {
        reverse(arr, 0, n - 1);
        return;
    }
        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[idx]){
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                break;
            }
        }
        reverse(arr, idx + 1, n - 1);

    }
    // Reverses the selected part of the array in-place using two pointers.
    // This is used to make the suffix as small as possible after the swap.
    private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
    public static void main(String[] args) {
        int Arr[] = {3,2,1};
        optimalSolution(Arr);
        for(int i:Arr){
            System.out.print(i+" ");
        }
    }
}
