package java_solutions.Binary_search;

public class search2dArray {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 )return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0,h=(n*m)-1;
        while(l<=h){
            int mid=(l+(h-l)/2);
            if(matrix[mid/m][mid%m]==target){
                return true;
            }
            if(matrix[mid/m][mid%m]<target){
                l=mid+1;
            }
            else h=mid-1;
        }
        return false;


    }
    public static void main(String[] args) {
        int[][] mat={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.print(searchMatrix(mat,8));

    }    
}
