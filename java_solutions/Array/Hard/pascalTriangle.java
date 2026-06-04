package java_solutions.Array.Hard;

public class pascalTriangle {
    
    // Multiplies all integers from 2 to n to calculate n factorial.
    // This helper is used in the brute force nCr formula.
    public static long factorial(int n) {
        long fact = 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
    // Calculates the value at row r and column c using the direct nCr formula.
    // It uses factorials, which is simple but does extra repeated work.
    public static long bruteforce(int n,int r,int c){
        // following nCr formula for findint the(r,c) term 
        r=r-1;
        c=c-1;
        long ans= (factorial(r)/(factorial(c)*(factorial(r-c))));
        
        return ans;


    }

    // Computes nCr iteratively without calculating full factorials.
    // This builds the answer step by step using multiplication and division.
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
