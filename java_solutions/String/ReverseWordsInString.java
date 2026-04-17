package java_solutions.String;

public class ReverseWordsInString {
    public static String ReverseWords(String s){
        StringBuilder ans=new StringBuilder();
        int i=s.length()-1;
        while (i>=0) {
            while (i>=0 && s.charAt(i)==' ' ) {
                i--;
                
            }
            if(i<0)break;
            int end=i;
            while (i>=0 && s.charAt(i)!=' ') {
                i--;
                
            }
            String word=s.substring(i+1,end+1);
            if(ans.length()>0){
                ans.append(" ");
            }
            ans.append(word);

            
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = " amazing coding skills ";
        System.out.println(ReverseWords(s));

    }
}
