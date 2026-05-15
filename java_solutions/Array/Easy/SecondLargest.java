package java_solutions.Array.Easy;

public class SecondLargest {
    public static int Secondlargest(int[] arr){

        int largest=0;
        for(int i:arr){
            largest=Math.max(largest,i);

        }
        int secondlargest=-1;
        for(int i:arr){
            if(i>secondlargest && i<largest)secondlargest=i;
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,5,4,3,2,1};
        int ans=Secondlargest(arr);
        System.out.println(ans);
    }
}
