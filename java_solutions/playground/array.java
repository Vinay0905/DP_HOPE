package java_solutions.playground;

public class array {
    public static void reverse(int[] arr){
        int start=0;
        int mid=(arr.length+1)/2;

        for(int i=0;i<mid/2;i++){

            int temp=arr[start];

            arr[start]=arr[mid-1-i];

            arr[mid-1-i]=temp;

            start++;
            
        }
    }

    public static void main(String[] args) {
        int n=30;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        reverse(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
