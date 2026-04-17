package java_solutions.Array;

import java.util.*;


class Solution {
  
    public List<List<Integer>> threeSum(int[] arr, int n) {
  
        Set<List<Integer>> st = new HashSet<>();

  
        for (int i = 0; i < n; i++) {
            
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }


        return new ArrayList<>(st);
    }
}


public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        Solution obj = new Solution();
        List<List<Integer>> res = obj.threeSum(arr, n);

        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }
}

// int [] nums = {-1,0,1,2,-1,-4};