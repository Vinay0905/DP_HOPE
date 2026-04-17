package java_solutions.recursion;

public class MyPOW {
    public static double mypow(double x,int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return mypow(1/x, -n);
        }
        return x*mypow(x, n-1);
    }
    
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -10;
        System.out.println(mypow(x, n));
    }
}
