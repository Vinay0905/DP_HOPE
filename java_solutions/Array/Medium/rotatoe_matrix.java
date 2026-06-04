package java_solutions.Array.Medium;
public class rotatoe_matrix {
    // Rotates a square matrix by first transposing it and then reversing each row.
    // Together, these two steps produce a 90-degree clockwise rotation.
    public static void rotate(int[][] matrix, int n, int m) {

    // Step 1: Transpose
    for (int i = 0; i < n; i++) {
        for (int j = i; j < m; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < n; i++) {
        int left = 0, right = m - 1;
        while (left < right) {
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            left++;
            right--;
        }
    }
}
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int n=3,m=3;
        rotate(mat,n,m);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();

        }
        
    }
}
