package java_solutions.Array.Easy;

public class largestNumber {

    public static int largestNumer(int[] arr){

        int max=0;
        
        for(int i:arr){
            max=Math.max(max, i);

        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,5,4,3,2,1};
        int ans=largestNumer(arr);
        System.out.println(ans);
    }
}
