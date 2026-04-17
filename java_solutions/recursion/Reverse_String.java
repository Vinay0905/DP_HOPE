package java_solutions.recursion;

public class Reverse_String {
    public static void reverseHelper(char[] s,int i){
        if(s.length/2==i)return ;
        char temp = s[i];
        s[i] = s[s.length-1-i];
        s[s.length-1-i] = temp;
        reverseHelper(s, i+1);


        
    }
    public static void reverseStringRecursion(char[] s){
        reverseHelper(s, 0);    

    } 
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        reverseStringRecursion(s);
        System.out.println(s);
    }
}
