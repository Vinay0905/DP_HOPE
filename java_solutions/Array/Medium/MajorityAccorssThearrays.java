package java_solutions.Array.Medium;
import java.util.HashMap;
import java.util.Map;
public class MajorityAccorssThearrays {
    // Counts each element by comparing it with every other element.
    // Returns the first value whose frequency is more than n/2.
    public static int bruteForce(int[] arr){
        int count;
        int n=arr.length;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(arr[j]==arr[i])count++;
                if(count>(n/2))return arr[i];
            }
        }
        return -1;
    }
    // Uses a HashMap to count frequencies while traversing the array.
    // As soon as any count crosses n/2, that element is returned.
    public static int betterSolution(int[] arr){
        int n=arr.length;
        Map<Integer,Integer> ma=new HashMap<>();
        for(int i:arr){
            ma.put(i,ma.getOrDefault(i,0)+1);
            if(ma.get(i)>(n/2))return i;
        }
        return -1;

    }
    // Moore's Voting Algorithm keeps one candidate and cancels it against different values.
    // The final verification step confirms the candidate appears more than n/2 times.
    public static int optimalSolution(int[] arr){
        int count=0,element=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                element=arr[i];

            }
            else if(arr[i]==element){
                count++;
            }
            else{
                count--;
            }
        }
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==element)cnt1++;

        }
        if(cnt1>(n/2)){
            return element;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int n=bruteForce(nums);
        System.out.println(n);
        int m=betterSolution(nums);
        System.out.println(m);
        int[] arr={7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        int z=optimalSolution(arr);
        System.out.println(z);

    }
}
