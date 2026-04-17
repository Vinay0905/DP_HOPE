package java_solutions.recursion;

public class ValidPalinrome {
    public static boolean helper(String s,int i){
        if(i>=s.length()/2)return true;
        if(s.charAt(i)!=s.charAt(s.length()-1-i))return false;
        return helper(s, i+1);
    }
    public static boolean isPalindrome(String s){
            // Preprocess: keep only alphanumeric characters and convert to lowercase
            String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return helper(cleaned, 0);
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
