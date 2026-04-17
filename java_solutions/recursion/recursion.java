package java_solutions.recursion;

public class recursion{

    public static int factorail(int c){
        if(c==0){
            return 1;
        }
        return c*factorail(c-1);
        
    }
    public static void main(String[] args) {
        //int c = 5;
        // factorail(c);
        // System.out.println(sumofN(c));
        // System.out.println(factorail(c));
        System.out.println(rec_power(5,3));
        System.out.println(sumofdigits(1756,0));
        System.out.println(reverseNumber(1764, 0));
        System.out.println(palindrome(121, 0, 121));
        int[] arr = {10, 20, 30, 40, 50};
        
        recursion_display(arr, 0);

    }
    public static int sumofN(int n){
        if(n==0){
            return 0;
        }
        return n+sumofN(n-1);
    }
    public static int rec_power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*rec_power(x,n-1);
    }
    public static int sumofdigits(int n,int sum){
        if(n==0)return sum;
        return sumofdigits(n/10,sum+(n%10));
    }
    public static int reverseNumber(int n,int rev){
        if(n==0){
            return rev;

        }
        return reverseNumber(n/10, rev*10+(n%10));

    }
    public static boolean palindrome(int n,int rev,int org){
        if(n==0){
            return rev==org;
        }
        return palindrome(n/10, rev*10+(n%10), org);
    }
    public static void recursion_display(int[] arr,int i){
        if(i==arr.length){
            return;
        }
        System.out.print(arr[i]+" ");
        recursion_display(arr, i+1);

        

    }
}
