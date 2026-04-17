package java_solutions.Binary_search;

public class KthMissingPositive {
    
    public static int findKthPositive(int[] arr, int k) {
        if (arr.length == 0 || arr[0] > k) return k;
        
        int n=arr.length;
        int l=0,h=n-1;
        while (l<=h) {
            int m=(l+h)/2;
            int missing=arr[m]-(m+1);
            if(missing<k){
                l=m+1;
            }
            else{
                h=m-1;
            }

        }
        return h+1+k;
    }

    public static void main(String[] args) {
        int[] vec={4,7,9,10};
        int  k = 4;
        int solution=findKthPositive(vec, k);
        System.out.println(solution);
    }
}
