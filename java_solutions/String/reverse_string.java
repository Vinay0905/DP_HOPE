package java_solutions.String;

public class reverse_string {

    public static void main(String[] args) {
        String str = "when will you come to my home";
        char[] c = str.toCharArray();
        // int n = c.length;
        str=str+" ";
        reverse(str);
        System.out.println(new String(c));
    }
    public static void reverse(String str) {
        String w="";

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                w=str.charAt(i)+w;
            }
            else{
                System.out.print(w+" ");
                w="";
            }
        }
    }
    // public static void reverseWords(char[] c, int n) {
    //     int start = 0;

    //     for (int i = 0; i <= n; i++) {
    //         if (i == n || c[i] == ' ') {
    //             reverse(c, start, i - 1);   
    //             start = i + 1;
    //         }
    //     }
    // }
}