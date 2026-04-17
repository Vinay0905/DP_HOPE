package java_solutions.playground;

public class automorphicNumber {
    public static boolean AutoMorphic_Number(int n){
        int actualNumber=n*n;
        int digitCount = String.valueOf(n).length();
        int divisor = (int) Math.pow(10, digitCount);
        int lastDigits = actualNumber % divisor;
        return lastDigits == n;
    }
    public static void main(String[] args) {
        int n=6;
        int n1=23;
        System.out.println(AutoMorphic_Number(n));
        System.out.println(AutoMorphic_Number(n1));
    }
}
