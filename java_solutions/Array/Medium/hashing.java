package java_solutions.Array.Medium;
import java.util.HashMap;
import java.util.Map;
public class hashing {

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

        creatHash(null, 0);
        creatHash("Trt", 0);
        creatHash("NEWTRr", 0);

        frequencyOfElements(arr);
        System.out.println(157237491%9);
    }

    public static void creatHash(String value, int key){
        HashMap<Integer,String> hashTable = new HashMap<>();

        
        hashTable.put(key,value);
        System.out.println(hashTable.get(key));
    }
    public static void frequencyOfElements(int[] arr){
        HashMap<Integer,Integer> hassh=new HashMap<>();
        for(int i:arr){
            hassh.put(i,hassh.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> ent:hassh.entrySet()){
            System.out.println(ent.getKey()+" -> "+ent.getValue());
        }
        

    }
    public static void prefixSum(int[] n){
        int a[]=new int[n.length];
        int prefix[]=new int[n.length];
        for(int i=0;i<n.length;i++){
            prefix[i]=a[i]+prefix[i-1];
        }

    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int c=0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                c+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;

    }


}

    


