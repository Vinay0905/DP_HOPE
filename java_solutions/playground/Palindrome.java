package java_solutions.playground;

public class Palindrome {
    
    public static int addNumtillpallindrome(int num){
        int count = 0;
        while(!isPalindrome(num)){
            num += reverse(num);
            count++;
            if(count>5){
                return -1;
            }
        }
        return count;
    }
    public static boolean isPalindrome(int num){
        return num == reverse(num);

    }
    public static int reverse(int num){
        int rev=0;
        while(num>0){
            rev=rev*10+num%10;
            num=num/10;

        }
        return rev;

    }

    public static void main(String[] args) {
        int num = 39;
    
        int count = addNumtillpallindrome(num);
        System.out.println("Number of additions to reach a palindrome: " + count);
        

    }  
        
}
