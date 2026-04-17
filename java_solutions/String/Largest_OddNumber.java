package java_solutions.String;

public class Largest_OddNumber {
    public static  String OddNumber(String s){
        for(int i=s.length()-1;i>=0;i--){
            if ((s.charAt(i)-'0')%2!=0){
                return s.substring(0,i+1);

            }


        }
        return "";
    }
    public static void main(String[] args) {
        String num = "35427";
        System.out.println(OddNumber(num));


    }
}
