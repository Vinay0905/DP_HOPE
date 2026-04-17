package java_solutions.String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder res=new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(String s:strs){
                if ( i==s.length() || s.charAt(i)!=c){
                    return res.toString();

                }
            }
            res.append(c);
            
            
        }
        return res.toString();

    }
    public static void main(String[] args) {
        String[] input = {"interview", "internet", "internal", "interval"};
        System.out.println(longestCommonPrefix(input));
    }
}
