package java_solutions.Binary_search;
import java.util.*;
public class AggresiveCows {

    public static boolean canweplace(int[] stalls,int dist,int cows){
        int count=1,l=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-l>=dist){
                count++;
                l=stalls[i];

            }
            if (count>=cows)return true;
            
            
        }
        return false;
    }
    public static int agressivecow(int[] stalls,int k){
        Arrays.sort(stalls);
        int n=stalls.length;
        int l=1,h=stalls[n-1]-stalls[0];
        while(l<=h){
            int m=(l+h)/2;
            if (canweplace(stalls, m, h)==true){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return h;
    }
    public static void main(String[] args) {
        int[] stalls= {0,3,4,7,10,9};
        // Number of cows
        int cows = 4;
        int solution =agressivecow(stalls, cows);
        System.out.println(solution);
    }
}
