package skillrack;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the total number of integers
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        // Populate the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        // Process and print each element
        for (int i = 0; i < n; i++) {
            int prevUnitDigit;
            
            if (i == 0) {
                // First element multiplies with the unit digit of the last element
                prevUnitDigit = arr[n - 1] % 10;
            } else {
                // Other elements multiply with the unit digit of the previous element
                prevUnitDigit = arr[i - 1] % 10;
            }
            
            System.out.print((arr[i] * prevUnitDigit) + " ");
        }
    }
}