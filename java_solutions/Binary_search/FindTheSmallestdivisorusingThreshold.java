package java_solutions.Binary_search;
public class FindTheSmallestdivisorusingThreshold {
    
    public static int sumofdivisor(int[] arr ,int div){
        int sum=0;
       
        for(int num:arr){
            sum += Math.ceil((double) num / div);
    
        }
        return sum;
    }
    public static int FindTheSmallestThreshold(int[] arr, int threshold){
        int l=0;
        int max1=0;
        for(int i=0;i<arr.length;i++){
            if (max1<arr[i]){
                max1=arr[i];
            }
        }
        int h=max1;
        while(l<=h){
            int m=(l+h)/2;
            if(sumofdivisor(arr, m)<=threshold){
                h=m-1;

            }
            else{
                l=m+1;
            }
        }
        return l;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int limit=8;
        int solution=FindTheSmallestThreshold(arr, limit);

        System.out.println(solution);
    }
}
