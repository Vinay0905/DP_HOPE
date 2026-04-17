package java_solutions.recursion;

public class NumberofStepstoReduceaNumbertoZero {
    public static int helper_recursion(int n,int count){    
        if(n==0)return count;
        if(n%2==0){
            return helper_recursion(n/2, count+1);
        }
        return helper_recursion(n-1, count+1);

    }

    public static int numberOfSteps(int n){
            
        return helper_recursion(n, 0);
    }
    public static void main(String[] args) {
        int num=14;
        System.out.println(numberOfSteps(num));
    }
}
