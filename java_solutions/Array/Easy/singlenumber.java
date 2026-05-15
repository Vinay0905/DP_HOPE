package java_solutions.Array.Easy;
public class singlenumber {
    public static int numers(int[] arr ){
        int rr=0;
        for(int i:arr){
            rr=rr^i;

        }
        return rr;
    }
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(numers(nums));
    }
}
