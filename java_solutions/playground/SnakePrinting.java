package java_solutions.playground;

public class SnakePrinting {
    
    public static int[] snakePrint(int[][] mat,int n,int m){
        ///expected output: 1 6 2 3 5 7 8 4 9
        int[] result = new int[n * m];
        int idx = 0;

       
        for (int d = 0; d < n + m - 1; d++) {

            if (d % 2 == 0) {
                
                int i = Math.min(d, n - 1);
                int j = d - i;

                while (i >= 0 && j < m) {
                    result[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {
                
                int j = Math.min(d, m - 1);
                int i = d - j;

                while (j >= 0 && i < n) {
                    result[idx++] = mat[i][j];
                    i++;
                    j--;
                }
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) {
        int n=4;
        int m=4;
        // int[][] mat={{1,6,7},{2,5,8},{3,4,9}};
        int[][] mat={{1,2,3,4},{5,6,7,8},{1,2,3,4},{5,6,7,8}};
        int[] ans=snakePrint(mat,n,m);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }   
}
