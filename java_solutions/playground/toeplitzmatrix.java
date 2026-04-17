package java_solutions.playground;

public class toeplitzmatrix {
    
    public static  boolean isToeplitzMatrix(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // int[][] mat={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] mat={{1,2},{2,2}};
        boolean ans=isToeplitzMatrix(mat);
        System.out.println(ans);
    }
}
