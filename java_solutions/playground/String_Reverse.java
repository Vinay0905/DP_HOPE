package java_solutions.playground;

public class String_Reverse {
    public static String rverse(String str){
        String res="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            res=ch+res;
        }
        return res;
    }
    public static boolean isPalindrome(String str,String rev){
        return str.equals(rev);
    }
    public static void main(String[] args) {
        String str="malayalam";
        System.out.println(str);
        System.out.println(rverse(str));
        if(isPalindrome(str,rverse(str))){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}
