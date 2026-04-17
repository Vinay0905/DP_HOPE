package java_solutions.Binary_search;

public class MinimumDaystoMakeBouquet {
    public static boolean possible(int[] arr ,int d,int k,int m){
        int count=0;
        int numberof_Bouquet=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]<=d){
                count++;
            }
            else{
                numberof_Bouquet+=(count/k);
                count=0;

            }

        }
        numberof_Bouquet+=(count/k);
        return numberof_Bouquet>=m;
    }
    public static int daysTobloom(int[] arr,int k , int m){
        long required = (long) m * k;
        if (required > arr.length) return -1; // not enough flowers

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom day
        for (int bloom : arr) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        // binary search over days, not indices
        int l = minDay, h = maxDay, res = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2; // candidate day
            // note: possible expects k then m
            if (possible(arr, mid, k, m)) {
                res = mid; // possible to form bouquets, try earlier
                h = mid - 1;
            } else {
                l = mid + 1; // need more days
            }
        }
        return res;

    }
    public static void main(String[] args) {
        // int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
        // int k = 3;
        // int m = 2;
        int[] bloomDays={7,7,7,7,12,7,7};
        int k=3;
        int m=2;
        int result = daysTobloom(bloomDays, k, m);
        if (result == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + result);
    }
}
