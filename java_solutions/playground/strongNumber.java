package java_solutions.playground;

public class strongNumber {
    public static int factorial(int n){
        if (n <= 1) return 1;  
        return n * factorial(n-1);
        
    }
    public static boolean Strongnumb(int n){
        int sum=0;
        int later=n;
        while(n!=0){
            int last=n%10;
            sum=factorial(last)+sum;
            n=n/10;

        }
        return sum==later;
        
    }
    public static void main(String[] args) {
        int n=145;
        System.out.println(Strongnumb(n));
    }
}
