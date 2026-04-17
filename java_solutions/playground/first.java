package java_solutions.playground;
import java.util.Scanner;


public class first {
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
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        System.out.println(reverse(n));
        String str="Hello World";
        System.out.println(str);
        s.close();
    }
}
