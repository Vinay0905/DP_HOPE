package java_solutions.Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class pascalTrianglePrintAnygivenRow {
    public static long Finder(int r,int c){
        r = r - 1;
        c = c - 1;
        long res=1;
        for(int i=0;i<c;i++){
            res=res*(r-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void bruteforce(int r) {
        for (int c = 1; c <= r; c++) {
            System.out.print(Finder(r, c) + " ");
        }
    }
    public static  List<Long> getNthRow(int N) {
        // Result list to store the row
        List<Long> row = new ArrayList<>();
        
        // First value of the row is always 1
        long val = 1;
        row.add(val);
        
        // Compute remaining values using the relation:
        // C(n, k) = C(n, k-1) * (n-k) / k
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }
        
        return row;
    }
    public static void main(String[] args) {
    int n=5;
    
    bruteforce(n);      
    System.out.println();
    List<Long> ans=getNthRow(n);
    for(long sn:ans){
        System.out.print(sn+" ");
    }
    }
}
