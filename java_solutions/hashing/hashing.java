package java_solutions.hashing;
//import java.util.HashMap;
public class hashing {
    //private static HashMap<String, Integer> hashTable = new HashMap<>();

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5,4,6,7,8,9,10};
        int[] freq=new int[256];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                System.out.println(i+" : "+freq[i]);
                freq[arr[i]]=0;
                
            }
        }
    }
}

    


