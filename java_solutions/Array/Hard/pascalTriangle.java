package java_solutions.Array.Hard;

public class pascalTriangle {
    
    public static long factorial(int n) {
        long fact = 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
    public static long bruteforce(int n,int r,int c){
        // following nCr formula for findint the(r,c) term 
        r=r-1;
        c=c-1;
        long ans= (factorial(r)/(factorial(c)*(factorial(r-c))));
        
        return ans;


    }

    public static long bettersolution(int r,int c){
        r = r - 1;
        c = c - 1;
        long res=1;
        for(int i=0;i<c;i++){
            res=res*(r-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int N = 5, r = 5, c = 3 ;
        System.out.println(bruteforce(N, r, c));
        System.out.println(bettersolution(r, c));
    }
}
