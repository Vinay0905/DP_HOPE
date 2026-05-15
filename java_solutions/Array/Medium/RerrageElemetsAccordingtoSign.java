package java_solutions.Array.Medium;
public class RerrageElemetsAccordingtoSign {
    public static int[] bruteForce(int[] arr){
        int n=arr.length;
        int[] newarr=new int[n];
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int cp=0,cn=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                pos[cp]=arr[i];
                cp++;
            }
            if(arr[i]<0){
                neg[cn]=arr[i];
                cn++;
            }
        }
        int ncp=0,ncn=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                newarr[i]=pos[ncp];
                ncp++;
            }
            if(i%2!=0){
                newarr[i]=neg[ncn];
                ncn++; 
            }
        }

        // return new int[]{-1,-1};
        return newarr;
    }
    public static int[] optimalSolution(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        int posI=0;
        int negI=1;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                ans[negI]=arr[i];
                negI+=2;
            }
            else{
                ans[posI]=arr[i];
                posI+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] newArr=bruteForce(nums);
        for(int i:newArr){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] newAltArr=optimalSolution(nums);
        for(int i:newAltArr){
            System.out.print(i+" ");
        }
    }
}
