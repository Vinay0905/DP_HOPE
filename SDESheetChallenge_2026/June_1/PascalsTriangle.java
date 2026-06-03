package SDESheetChallenge_2026.June_1;
import java.util.*;

// Class containing Pascal's Triangle row generation logic


public class PascalsTriangle {
    public static List<Long> getNthRow(int N) {
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
        int N = 5; // Example: 5th row
        
        List<Long> result = getNthRow(N);

        // Print the row
        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}
