package java_solutions.Binary_search;
import java.util.*;
public class CapacitytoShipPackageswithinDDays {
    public static int daysReq(int[] arr,int cap){
        int day=1,load=0;
        
        for (int weight : arr) {  
        if (load + weight > cap) {
            day++;
            load = weight;
        } else {
            load += weight;
        }
        }
        return day;
    }
    public static int capacity_req(int[] arr,int day){
        int l = Arrays.stream(arr).max().orElse(0);  
        int h = Arrays.stream(arr).sum();
        while(l<=h){
            int m=(l+h)/2;
            int noofDays=daysReq(arr, m);
            if (noofDays<=day){
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return l;

    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int solution=capacity_req(weights, d);
        System.out.println(solution);


    }
}
