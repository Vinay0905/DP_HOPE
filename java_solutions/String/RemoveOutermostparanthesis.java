package java_solutions.String;

public class RemoveOutermostparanthesis {
    public static String removeparathesis(String s){
        int c=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)==')'){
                c--;
            }
            if (c!=0){
                ans.append(s.charAt(i));
            }
            if (s.charAt(i)=='('){
                c++;

            }
            
        }
        return ans.toString();

    }
    public static void main(String[] args) {
        String val="(()())(())";
        System.out.println(removeparathesis(val));
    }
}
