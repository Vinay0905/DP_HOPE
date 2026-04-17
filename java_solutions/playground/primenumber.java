package java_solutions.playground;
import java.util.Scanner;

public class primenumber {
    
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static long reverse(long x){
        long num=0;
        while(x!=0){
            long rem=x%10;
            num=num*10+rem;
            x=x/10;
        }
        return num;
    }

    public static void main(String[] args) {
    
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int rev=(int)reverse(n);
        if(isPrime(n) && isPrime(rev)){
            System.out.println(n+" is a twisted prime number");
        }
        else{
            System.out.println(n+" is not a twisted prime number");
        }
        sc.close();        
    }
}
