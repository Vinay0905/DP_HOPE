package Practice.Arrays.twoPointers;

public class ValidPalindrome {
    
    public static boolean isPalindrome(String s){
        int n=s.length();
        int i=0,j=n-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))j--;
            char left=Character.toLowerCase(s.charAt(i));
            char right=Character.toLowerCase(s.charAt(j));
            if(left!=right)return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
