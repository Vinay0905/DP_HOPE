package java_solutions.recursion;
import java.util.Arrays;
public class Basic {
    


    public static void PrintName(String name,int n){
        if(n==0){
            return ;
        }
        
        System.out.println(name);
        PrintName(name, n-1);
    }

    public static void printNLinearly(int n){
        if(n<=0){
            return ;
        }
        printNLinearly(n-1);
        System.out.print(n+" ");
        

    }
    public static void printN(int i,int n){

        if(i<1){
            return;
        }
        printN(i-1, n);
        System.out.print (i+" ");


    }
    public static void SUmofFirstNnumbers(int n,int sum){
        //parametrized
        if(n<=0){
            // return ;
            System.out.println(sum);
            return ;

        }
        SUmofFirstNnumbers(n-1, sum+n);

    }

    public static int sumOFFIRSTNUMBERS(int n){
        if(n==0){
            return 0;
        }
        return n+sumOFFIRSTNUMBERS(n-1);
    }

    public static int factorial(int n){
        if (n==1 || n==0 )return 1;
        return n*factorial(n-1);
    }

    public static void reverserAArray(int[] arr,int l,int r){

        if(l>=r)return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverserAArray(arr, l+1, r-1);
    }
    
    public static boolean CheckPalindrome(String s,int start,int end){


        if(start>=end){
            return true;
        }
        if(s.charAt(start)!=s.charAt(end)){
            return false;
        }
        return CheckPalindrome(s, start+1, end-1);

    }

    
    public static void main(String[] args) {
        // PrintName("Naga", 10);

        printNLinearly(10);
        System.out.println();
        printN(3, 3);
        System.out.println();
        SUmofFirstNnumbers(10, 0);
        System.out.println(sumOFFIRSTNUMBERS(10));
        System.out.println(factorial(5));
        int[] arr={1,2,3,4,5,6};
        reverserAArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        String s="madam";
        System.out.println(CheckPalindrome(s, 0,s.length()-1));
    }
}
