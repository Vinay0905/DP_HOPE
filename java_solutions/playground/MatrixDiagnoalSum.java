package java_solutions.playground;

public class MatrixDiagnoalSum {
    
    public static int diagnoalSum(int[][] mat){


        int n=mat.length;
        int m=mat[0].length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=mat[i][i];
        }
        for(int i=0;i<n;i++){
            sum=sum+mat[i][m-1-i];
        }
        if(n%2!=0){
            sum=sum-mat[n/2][m/2];
        }
        return sum;
    }
    public static void main(String[] args) {
        // int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat={{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int ans=diagnoalSum(mat);
        System.out.println(ans);
    }
}
