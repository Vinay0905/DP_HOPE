package java_solutions.recursion;

public class ValidPalindromeII {
    
    // Helper to check if substring is palindrome
    private static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either left or right character
                return isPalindromeRange(s, left + 1, right) || 
                       isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(validPalindrome("aba"));    // true
        System.out.println(validPalindrome("abca"));   // true (delete 'c')
        System.out.println(validPalindrome("abc"));    // false
    }
}
