package java_solutions.Binary_search;

public class SearchInd2DMatrixII {
    
    public static boolean searchElement(int[][] mat,int target){
        int n=mat.length;
        int m=mat[0].length;
        int r=0,c=m-1;
        while(r<n && c>=0){
            if(mat[r][c]==target){
                return true;
            }
            else if (mat[r][c]<target){
                r++;
            }
            else{
                c--;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        
        boolean found = searchElement(matrix,99);
        System.out.println(found); // true    
    }
}   
