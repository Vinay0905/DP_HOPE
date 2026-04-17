package java_solutions.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class SorttheMatrixDiagonally {
    

    public static  int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.putIfAbsent(i-j,new PriorityQueue<>());
                map.get(i-j).offer(mat[j][i]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[j][i]=map.get(i-j).poll();
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};  
        int[][] ans=diagonalSort(mat);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
