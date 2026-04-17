package java_solutions.Binary_search;

public class row_withMax1 {
    public static int lowerBound(int[] arr,int n,int x){
        int l=0,h=n-1;
        int ans=n;
        while(l<=h){
            int m=(l+h)/2;
            if (arr[m]>=x){
                ans=m;
                h=m-1;

            }
            else{
                l=m+1;
            }
        }
        return ans;

    }
    public static int matrixfinding(int[][] arr ,int n,int m){
        int cnt_ma=0;
        int indx=-1;
        for (int i=0;i<n;i++){
            int cnt_one=m-lowerBound(arr[i], cnt_ma, indx);
            if(cnt_one>cnt_ma){
                cnt_ma=cnt_one;
                indx=i;
            }

        }
        return indx;
    }
    public static void main(String[] args) {
        int n=3,m=3;
        int[][]  mat ={{1,1,1},{0,0,1},{0,0,0}};
        System.out.println(matrixfinding(mat, n, m));
    }
}
