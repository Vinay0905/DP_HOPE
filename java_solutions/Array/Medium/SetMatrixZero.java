package java_solutions.Array.Medium;
public class SetMatrixZero {

    // Marks rows and columns with -1 whenever a zero is found.
    // A second pass converts those marks into actual zeroes.
    public static int[][] bruteforce(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i, m);
                    markColumn(arr, j, n);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    // Marks all non-zero cells in the given row with -1.
    // These marks are later changed to zero.
    private static void markRow(int[][] arr, int row, int m) {
        for (int j = 0; j < m; j++) {
            if (arr[row][j] != 0) {
                arr[row][j] = -1;
            }
        }
    }

    // Marks all non-zero cells in the given column with -1.
    // These marks are later changed to zero.
    private static void markColumn(int[][] arr, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i][col] != 0) {
                arr[i][col] = -1;
            }
        }
    }

    // Uses separate row and column arrays to remember which rows or columns contain zero.
    // Then zeroes every cell that belongs to a marked row or column.
    public static int[][] betterSolution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    // Uses the first row and first column as marker storage to avoid extra arrays.
    // Separate flags protect the original zero state of the first row and column.
    public static int[][] optimalSolu(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] ans = optimalSolu(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
